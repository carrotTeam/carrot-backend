package carrotTeam.carrot.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Builder
public class UserUpdateRequest {
  @NotNull(message = "아이디는 공백일 수 없습니다.")
  private Long id;

  @NotBlank(message = "닉네임은 공백일 수 없습니다")
  private String nickName;

  @NotBlank(message = "이메일은 공백일 수 없습니다.")
  private String email;

  @NotBlank(message = "비밀번호는 공백일 수 없습니다.")
  private String password;

  @NotBlank(message = "위치는 공백일 수 없습니다.")
  private String location;

  private LocalDateTime updatedAt;
}
