package carrotTeam.carrot.domain.comment.dto;

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
  private LocalDateTime createAt;
  private List<CommentResponse> childrenComment = new ArrayList<>();


}

