package carrotTeam.carrot.domain.comment.domain.repository.querydsl;

import static carrotTeam.carrot.domain.comment.domain.entity.QComment.comment;

import carrotTeam.carrot.domain.comment.domain.entity.Comment;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CommentRepositoryQuerydslImpl implements CommentRepositoryQuerydsl {

  private final JPAQueryFactory queryFactory;

  //1. parent_id가 null이면 최상위댓글이므로 오름차순
  //2. createdAt을 오름차순으로
  @Override
  public List<Comment> findByPostId(Long postId) {

    return queryFactory
        .select(comment)
        .from(comment)
        .leftJoin(comment.parentComment)
        .where(comment.post.id.eq(postId))
        .orderBy(
            comment.parentComment.id.asc().nullsFirst(),
            comment.createdAt.asc())
        .fetch();

  }


}
