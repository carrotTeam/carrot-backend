package carrotTeam.carrot.domain.comment.service;

import carrotTeam.carrot.domain.comment.domain.entity.Comment;
import carrotTeam.carrot.domain.comment.domain.repository.CommentRepository;
import carrotTeam.carrot.domain.comment.dto.CommentInfo;
import carrotTeam.carrot.domain.comment.dto.CommentRequest;
import carrotTeam.carrot.domain.post.domain.entity.Post;
import carrotTeam.carrot.domain.post.domain.repository.PostRepository;
import carrotTeam.carrot.domain.post.service.PostService;
import carrotTeam.carrot.domain.user.domain.entity.User;
import carrotTeam.carrot.domain.user.domain.repositorty.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentService {


    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private  final PostRepository postRepository;


    public CommentInfo createComment(CommentRequest commentRequest) {

        Comment createNewCommentEntity = CreateNewCommentEntity(commentRequest);
        Comment comment = commentRepository.save(createNewCommentEntity);
        return commentEntityToCommentInfo(comment);
    }

    public Comment CreateNewCommentEntity(CommentRequest commentRequest) {

        User findUser = getUserById(commentRequest.getUser_id());
        Post findPost = getPostById(commentRequest.getPost_id());

        return Comment.builder()
                .user(findUser)
                .post(findPost)
                .content(commentRequest.getContent())
                .build();
    }

    private CommentInfo commentEntityToCommentInfo(Comment savedComment) {
        return CommentInfo.builder()
                .content(savedComment.getContent())
                .createAt(savedComment.getCreatedAt())
                .updateAt(savedComment.getUpdatedAt())
                .build();
    }

    private User getUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(null);
    }

    private Post getPostById(Long postId) {
        return postRepository.findById(postId).orElseThrow(null);
    }
}


