package carrotTeam.carrot.domain.post.mapper;

import carrotTeam.carrot.domain.comment.domain.entity.Comment;
import carrotTeam.carrot.domain.post.domain.entity.Post;
import carrotTeam.carrot.domain.post.dto.PostInfo;
import carrotTeam.carrot.domain.post.dto.PostInfoWithComment;
import carrotTeam.carrot.domain.post.dto.PostRequest;
import carrotTeam.carrot.domain.user.dto.UserCreateRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

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

    public PostInfoWithComment mapPostEntityToPostInfoWithComment(Post post){

        ArrayList<String> three_comment_list = new ArrayList<>();
        int count_comment = 0;

        for (Comment c : post.getComment()) {
            String id_content = "comment_user_id : " + c.getId() + ", comment_content : " + c.getContent();
            three_comment_list.add(id_content);

            count_comment++;

            if (count_comment == 3) break;
        }

        return PostInfoWithComment.builder()
                .user_id(post.getUser().getId())
                .title(post.getTitle())
                .content(post.getContent())
                .picture_address(post.getPicture_address())
                .isActive(post.getIsActive())
                .createdAt(post.getCreatedAt())
                .updatedAt(post.getUpdatedAt())
                .comment(three_comment_list)
                .build();
    }

}
