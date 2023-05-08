package carrotTeam.carrot.domain.comment.dto;
import carrotTeam.carrot.domain.comment.domain.entity.Comment;
import carrotTeam.carrot.domain.post.dto.PostInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class CommentResponse {

    private Long comment_Id;
    private String nickName;
    private String content;
    private LocalDateTime localDateTime;

}
