package carrotTeam.carrot.domain.post.domain.entity;

import carrotTeam.carrot.domain.user.domain.entity.User;
import carrotTeam.carrot.global.common.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Post extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "post_id", nullable = false)
    private Long id;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "content", nullable = false, length = 500)
    private String content;

    @Column(name = "picture_address", nullable = false, length = 2000)
    @ElementCollection
    private List<String> picture_address;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Builder
    public Post(User user, String title, String content, List<String> picture_address) {
        this.user = user;
        this.title = title;
        this.content = content;
        this.picture_address = picture_address;
    }

    public void update (String title, String content) {
        this.title = title;
        this.content = content;
    }
}
