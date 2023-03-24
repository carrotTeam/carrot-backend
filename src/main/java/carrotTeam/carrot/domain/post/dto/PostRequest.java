package carrotTeam.carrot.domain.post.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;

@Builder
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class PostRequest {

    @NotBlank(message = "회원은 공백일 수 없습니다")
    private Long user_id;

    @NotBlank(message = "제목은 공백일 수 없습니다")
    private String title;

    @NotBlank(message = "내용은 공백일 수 없습니다")
    private String content;
}
