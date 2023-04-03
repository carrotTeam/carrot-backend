package carrotTeam.carrot.domain.post.domain.repository;

import carrotTeam.carrot.domain.post.domain.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByIsActive(Boolean isActive);

    @Query(value = "SELECT p FROM Post p WHERE p.user.id = :id AND p.isActive = :isActive")
    List<Post> findByIdAndIsActive(Long id, Boolean isActive);

    @Query(value = "SELECT p FROM Post p WHERE (p.title LIKE %:word% OR p.content LIKE %:word%) AND p.isActive = :isActive")
    List<Post> findByWordAndIsActive(String word, Boolean isActive);
}
