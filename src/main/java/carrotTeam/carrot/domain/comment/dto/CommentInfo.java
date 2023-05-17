package carrotTeam.carrot.domain.comment.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class CommentInfo {

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
  private LocalDateTime createAt;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
  private LocalDateTime updateAt;

  private String content;

  @Builder
  public CommentInfo(String content, LocalDateTime createAt, LocalDateTime updateAt) {
    this.content = content;
    this.createAt = createAt;
    this.updateAt = updateAt;
  }

}
