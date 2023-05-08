package carrotTeam.carrot.domain.comment.domain.repository;

import carrotTeam.carrot.domain.comment.domain.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("SELECT c FROM Comment c join fetch c.post where c.isActive = true and c.post.id=:id")
    List<Comment> findByPostId(@Param("id") Long id);
}
