package carrotTeam.carrot.domain.user.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Builder
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class UserCreateRequest {

  @NotBlank(message = "닉네임은 공백일 수 없습니다")
  private String nickName;

  @NotBlank(message = "이메일은 공백일 수 없습니다")
  private String email;

  @NotBlank(message = "비밀번호는 공백일 수 없습니다")
  private String password;

  @NotBlank(message = "자신의 위치를 입력해주세요")
  private String location;
}
