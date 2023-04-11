package carrotTeam.carrot.domain.user.domain.repositorty;

import carrotTeam.carrot.domain.user.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT r FROM User r WHERE r.id = :id AND r.isActive = true")
    Optional<User> findById(@Param("id") Long id);

}
