package carrotTeam.carrot.domain.comment.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    @Schema(description = "comment 내용")
    @NotNull
    private String content;


}
