package carrotTeam.carrot.domain.comment.domain.repository.querydsl;

import carrotTeam.carrot.domain.comment.domain.entity.Comment;
import java.util.List;

public interface CommentRepositoryQuerydsl {

  List<Comment> findByPostId(Long postId);


}
