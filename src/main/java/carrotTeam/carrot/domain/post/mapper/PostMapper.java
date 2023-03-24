package carrotTeam.carrot.domain.post.mapper;

import carrotTeam.carrot.domain.post.domain.entity.Post;
import carrotTeam.carrot.domain.post.dto.PostInfo;
import carrotTeam.carrot.domain.post.dto.PostRequest;
import carrotTeam.carrot.domain.user.dto.UserCreateRequest;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {

    public PostInfo mapPostEntityToPostInfo(Post post){
        return PostInfo.builder()
                .title(post.getTitle())
                .content(post.getContent())
                .user_id(post.getUser().getId())
                .picture_address(post.getPicture_address())
                .build();
    }

}
