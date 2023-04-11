package carrotTeam.carrot.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Builder
public class UserUpdateRequest {
    private Long id;
    private String email;
    private String password;
    private String location;
    private LocalDateTime updatedAt;
}