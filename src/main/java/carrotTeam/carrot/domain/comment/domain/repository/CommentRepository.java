package carrotTeam.carrot.domain.comment.domain.repository;

import carrotTeam.carrot.domain.comment.domain.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CommentRepository extends JpaRepository<Comment, Long> {
}
