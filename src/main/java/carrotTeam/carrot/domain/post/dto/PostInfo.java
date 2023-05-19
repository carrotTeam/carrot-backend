package carrotTeam.carrot.domain.post.dto;

import carrotTeam.carrot.domain.post.domain.entity.Post;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostInfo {

  private Long user_id;
  private String title;
  private String content;
  private List<String> picture_address;
  private Boolean isActive;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
  private LocalDateTime createdAt;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
  private LocalDateTime updatedAt;

  public static PostInfo of(Post entity) {
    return PostInfo.builder()
        .user_id(entity.getUser().getId())
        .title(entity.getTitle())
        .content(entity.getContent())
        .picture_address(entity.getPicture_address())
        .isActive(entity.getIsActive())
        .createdAt(entity.getCreatedAt())
        .updatedAt(entity.getUpdatedAt())
        .build();
  }
}
