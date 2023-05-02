package carrotTeam.carrot.domain.comment.domain.entity;

import carrotTeam.carrot.domain.post.domain.entity.Post;
import carrotTeam.carrot.domain.user.domain.entity.User;
import carrotTeam.carrot.global.common.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Comment")
public class Comment extends BaseEntity {

    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @NotNull
    @Column(name = "content", length = 100)
    private String content;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


}
