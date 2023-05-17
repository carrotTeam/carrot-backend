package carrotTeam.carrot.domain.comment.domain.entity;

import carrotTeam.carrot.domain.post.domain.entity.Post;
import carrotTeam.carrot.domain.user.domain.entity.User;
import carrotTeam.carrot.global.common.BaseEntity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "Comment")
public class Comment extends BaseEntity {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "comment_id", nullable = false)
  private Long id;


  @Column(name = "content", length = 100, nullable = false)
  private String content;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "post_id", nullable = false)
  private Post post;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "parent_id")
  private Comment parentComment;

  @OneToMany(mappedBy = "parentComment", orphanRemoval = true)
  private List<Comment> childrenComment = new ArrayList<>();

  @Builder
  private Comment(String content, Post post, User user, Comment parentComment) {
    this.content = content;
    this.post = post;
    this.user = user;
    this.parentComment = parentComment;
  }

}
