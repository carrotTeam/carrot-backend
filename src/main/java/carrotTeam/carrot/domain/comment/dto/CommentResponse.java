package carrotTeam.carrot.domain.comment.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CommentResponse {

  private Long comment_Id;
  private String nickName;
  private String content;
  private LocalDateTime localDateTime;

}
