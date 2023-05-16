package carrotTeam.carrot.domain.comment.domain.repository;

import carrotTeam.carrot.domain.comment.domain.entity.Comment;
import carrotTeam.carrot.domain.comment.domain.repository.querydsl.CommentRepositoryQuerydsl;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CommentRepository extends JpaRepository<Comment, Long>, CommentRepositoryQuerydsl {

//  @Query("SELECT c FROM Comment c JOIN FETCH c.user WHERE c.isActive = true AND c.post.id=:id")
//  List<Comment> findByPostId(@Param("id") Long id);
}
