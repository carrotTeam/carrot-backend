package carrotTeam.carrot.domain.comment.mapper;

import carrotTeam.carrot.domain.comment.domain.entity.Comment;
import carrotTeam.carrot.domain.comment.dto.CommentInfo;
import org.springframework.stereotype.Component;

@Component
public class CommentMapper {

  public CommentInfo mapCommentEntityToCommentInfo(Comment Comment) {
    return CommentInfo.builder()
        .content(Comment.getContent())
        .createAt(Comment.getCreatedAt())
        .updateAt(Comment.getUpdatedAt())
        .build();
  }

}
