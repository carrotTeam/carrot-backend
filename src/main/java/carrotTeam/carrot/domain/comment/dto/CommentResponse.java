package carrotTeam.carrot.domain.comment.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Builder
@AllArgsConstructor
public class CommentResponse {

  private Long comment_Id;
  private String nickName;
  private String content;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
  private LocalDateTime createAt;
  private List<CommentResponse> childrenComment = new ArrayList<>();

  public List<CommentResponse> getChildrenComment() {
    if (childrenComment == null) {
      childrenComment = new ArrayList<>();
    }
    return childrenComment;
  }

}

