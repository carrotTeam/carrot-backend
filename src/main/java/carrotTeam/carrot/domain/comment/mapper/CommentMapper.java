package carrotTeam.carrot.domain.comment.mapper;

import carrotTeam.carrot.domain.comment.domain.entity.Comment;
import carrotTeam.carrot.domain.comment.dto.CommentInfo;
import carrotTeam.carrot.domain.comment.dto.CommentRequest;
import carrotTeam.carrot.domain.post.domain.entity.Post;
import carrotTeam.carrot.domain.user.domain.entity.User;
import carrotTeam.carrot.domain.user.service.UserService;
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
