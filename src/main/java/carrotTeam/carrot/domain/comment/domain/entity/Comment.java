package carrotTeam.carrot.domain.comment.domain.entity;

import carrotTeam.carrot.domain.post.domain.entity.Post;
import carrotTeam.carrot.domain.user.domain.entity.User;
import carrotTeam.carrot.global.common.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "Comment")
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id", nullable = false)
    private Long id;

}
