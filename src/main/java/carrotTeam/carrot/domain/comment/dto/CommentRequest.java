package carrotTeam.carrot.domain.comment.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class CommentRequest {

  @NotNull
  @Schema(description = "user 아이디")
  private Long user_id;

  @NotNull
  @Schema(description = "post 아이디")
  private Long post_id;

  @Schema(description = "parent_comment 아이디")
  private Long parent_id;

  @Schema(description = "comment 내용")
  @NotBlank(message = "댓글을 작성해주세요!")
  private String content;


}
