package carrotTeam.carrot.domain.comment.dto;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;


@Getter
@NoArgsConstructor
public class CommentInfo {

  @DateTimeFormat
  private LocalDateTime createAt;

  @DateTimeFormat
  private LocalDateTime updateAt;

  private String content;

  @Builder
  public CommentInfo(String content, LocalDateTime createAt, LocalDateTime updateAt) {
    this.content = content;
    this.createAt = createAt;
    this.updateAt = updateAt;
  }

}
