package carrotTeam.carrot.domain.user.service;
import carrotTeam.carrot.domain.user.domain.entity.User;
import carrotTeam.carrot.domain.user.domain.repositorty.UserRepository;
import carrotTeam.carrot.domain.user.dto.UserCreateRequest;
import carrotTeam.carrot.domain.user.dto.UserInfo;
import carrotTeam.carrot.domain.user.dto.UserUpdateRequest;
import carrotTeam.carrot.domain.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

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
    public UserInfo findUserId(Long id){
        User findUser = userRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        return userMapper.mapUserEntityToUserInfo(findUser);
    }
    public UserInfo updateUser(UserUpdateRequest userUpdateRequest){
        User findUser = userRepository.findById(userUpdateRequest.getId())
                .orElseThrow(EntityNotFoundException::new);
        findUser.update(userUpdateRequest);
        User savedUser = userRepository.save(findUser);
        return userMapper.mapUserEntityToUserInfo(savedUser);
    }
    public UserInfo DeleteUser(Long id){
        User findUser = userRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        findUser.delete();
        userRepository.save(findUser);
        return userMapper.mapUserEntityToUserInfo(findUser);
    }
}

