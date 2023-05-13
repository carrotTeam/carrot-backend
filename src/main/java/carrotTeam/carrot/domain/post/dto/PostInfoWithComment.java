package carrotTeam.carrot.domain.post.dto;

import carrotTeam.carrot.domain.comment.domain.entity.Comment;
import carrotTeam.carrot.domain.post.domain.entity.Post;
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
public class PostInfoWithComment {
    private Long user_id;
    private String title;
    private String content;
    private List<String> picture_address;
    private Boolean isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<String> comment;

}

