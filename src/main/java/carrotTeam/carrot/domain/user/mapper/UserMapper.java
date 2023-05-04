package carrotTeam.carrot.domain.user.mapper;
import carrotTeam.carrot.domain.user.domain.entity.User;
import carrotTeam.carrot.domain.user.dto.UserCreateRequest;
import carrotTeam.carrot.domain.user.dto.UserInfo;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User mapCreateUserToEntity(UserCreateRequest userCreateRequest){
        return User.builder()
                .nickname(userCreateRequest.getNickName())
                .email(userCreateRequest.getEmail())
                .password(userCreateRequest.getEmail())
                .location(userCreateRequest.getLocation())
                .build();
    }

    public UserInfo mapUserEntityToUserInfo(User user) {
        return UserInfo.builder()
                .nickName(user.getNickname())
                .email(user.getEmail())
                .password(user.getPassword())
                .location(user.getLocation())
                .createdAt(user.getCreatedAt())
                .build();
    }

}
