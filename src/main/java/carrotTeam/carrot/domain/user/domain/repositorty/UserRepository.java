package carrotTeam.carrot.domain.user.domain.repositorty;

import carrotTeam.carrot.domain.user.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {



}
