package carrotTeam.carrot.domain.post.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostInfo {
    private Long user_id;
    private String title;
    private String content;
    private String picture_address;
}
