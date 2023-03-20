package carrotTeam.carrot.domain.user.service;
import carrotTeam.carrot.domain.user.domain.entity.User;
import carrotTeam.carrot.domain.user.domain.repositorty.UserRepository;
import carrotTeam.carrot.domain.user.dto.UserCreateRequest;
import carrotTeam.carrot.domain.user.dto.UserInfo;
import carrotTeam.carrot.domain.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserInfo createUser(UserCreateRequest userCreateRequest){
        User newUser = userMapper.mapCreateUserToEntity(userCreateRequest);
        User savedUser = userRepository.save(newUser);
        return userMapper.mapUserEntityToUserInfo(savedUser);
    }
}
