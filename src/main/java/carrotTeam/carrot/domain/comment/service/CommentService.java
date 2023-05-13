package carrotTeam.carrot.domain.comment.service;

import carrotTeam.carrot.domain.comment.domain.entity.Comment;
import carrotTeam.carrot.domain.comment.domain.repository.CommentRepository;
import carrotTeam.carrot.domain.comment.dto.CommentInfo;
import carrotTeam.carrot.domain.comment.dto.CommentRequest;
import carrotTeam.carrot.domain.comment.dto.CommentResponse;
import carrotTeam.carrot.domain.comment.exception.NotFoundComment;
import carrotTeam.carrot.domain.comment.mapper.CommentMapper;
import carrotTeam.carrot.domain.post.domain.entity.Post;
import carrotTeam.carrot.domain.post.domain.repository.PostRepository;
import carrotTeam.carrot.domain.post.exception.NotFoundPost;
import carrotTeam.carrot.domain.user.domain.entity.User;
import carrotTeam.carrot.domain.user.domain.repositorty.UserRepository;
import carrotTeam.carrot.domain.user.exception.NotFoundUser;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentService {


  private final CommentRepository commentRepository;
  private final UserRepository userRepository;
  private final PostRepository postRepository;
  private final CommentMapper commentMapper;


  public CommentInfo createComment(CommentRequest commentRequest) {

    Comment newComment = createCommentToEntity(commentRequest);
    Comment savedComment = commentRepository.save(newComment);
    return commentMapper.mapCommentEntityToCommentInfo(savedComment);
  }

  public Comment createCommentToEntity(CommentRequest commentRequest) {

    User findUser = getUserById(commentRequest.getUser_id());
    Post findPost = getPostById(commentRequest.getPost_id());

    Comment findParent = null;
    if (commentRequest.getParent_id() != null) {
      findParent = commentRepository.findById(commentRequest.getParent_id())
          .orElseThrow(NotFoundComment::new);
    }

    return Comment.builder()
        .user(findUser)
        .post(findPost)
        .content(commentRequest.getContent())
        .parentComment(findParent)
        .build();
  }

  public List<CommentResponse> findCommentByPostId(Long id) {

    if (!postRepository.existsById(id)) {
      throw new NotFoundPost();
    }
    List<CommentResponse> commentList =
        commentRepository.findByPostId(id).stream()
            .map(this::commentEntityToCommentResponse)
            .collect(Collectors.toList());
    return commentList;
  }

  private CommentResponse commentEntityToCommentResponse(Comment comment) {
    return CommentResponse.builder()
        .comment_Id(comment.getId())
        .content(comment.getContent())
        .nickName(comment.getUser().getNickname())
        .localDateTime(comment.getCreatedAt())
        .build();
  }

  @Transactional
  public void deleteComment(Long comment_id) {

    Comment foundComment = commentRepository.findById(comment_id).orElseThrow(NotFoundComment::new);
    if (!foundComment.getIsActive()) {
      throw new NotFoundComment();
    }
    foundComment.delete();
    commentRepository.save(foundComment);
  }


  private User getUserById(Long userId) {

    return userRepository.findById(userId).orElseThrow(NotFoundUser::new);
  }

  private Post getPostById(Long postId) {

    return postRepository.findById(postId).orElseThrow(NotFoundPost::new);
  }

  private Comment getCommentById(Long commentId) {

    return commentRepository.findById(commentId).orElseThrow(NotFoundComment::new);
  }
}


