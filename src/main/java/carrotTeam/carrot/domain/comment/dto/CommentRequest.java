package carrotTeam.carrot.domain.comment.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class CommentRequest {

    @NotNull
    @Schema(description = "post 아이디")
    private Long post_id;

    @Schema(description = "comment 내용")
    @NotNull
    private String content;



}
