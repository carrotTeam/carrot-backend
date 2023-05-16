package carrotTeam.carrot.domain.post.domain.repository;

import carrotTeam.carrot.domain.post.domain.entity.RedisPost;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedisRepository extends CrudRepository<RedisPost, String> {
}