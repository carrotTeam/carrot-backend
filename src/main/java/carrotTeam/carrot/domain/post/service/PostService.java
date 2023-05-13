package carrotTeam.carrot.domain.post.service;

import carrotTeam.carrot.domain.post.domain.entity.Post;
import carrotTeam.carrot.domain.post.domain.repository.PostRepository;
import carrotTeam.carrot.domain.post.dto.PostInfo;
import carrotTeam.carrot.domain.post.dto.PostInfoWithComment;
import carrotTeam.carrot.domain.post.dto.PostRequest;
import carrotTeam.carrot.domain.post.exception.NotFoundPost;
import carrotTeam.carrot.domain.post.mapper.PostMapper;
import carrotTeam.carrot.domain.user.domain.entity.User;
import carrotTeam.carrot.domain.user.domain.repositorty.UserRepository;
import carrotTeam.carrot.domain.user.exception.NotFoundUser;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import org.springframework.beans.factory.annotation.Value;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    private final PostMapper postMapper;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    private final AmazonS3 amazonS3;

    public String upload(MultipartFile multipartFile) throws IOException {
        // 파일 이름 중복 X -> UUID 로 생성한 랜덤 값에 파일이름 연결
        String s3FileName = UUID.randomUUID() + "-" + multipartFile.getOriginalFilename();

        // Spring Server 에서 S3로 파일을 업로드 -> 이때 피일 사이즈를 ContentLength 로 S3 알려주기 위해 ObjectMetadata 사용
        ObjectMetadata objMeta = new ObjectMetadata();
        objMeta.setContentLength(multipartFile.getInputStream().available());

        // S3 API 메소드인 putObject 사용하여 파일 Stream 을 열어서 S3에 파일을 업로드
        amazonS3.putObject(bucket, s3FileName, multipartFile.getInputStream(), objMeta);

        // getUrl 메소드를 통해서 S3에 업로드된 사진 URL을 가져오는 방식
        return amazonS3.getUrl(bucket, s3FileName).toString();
    }

    public PostInfo createPost(Long user_id, String title, String content, List<String> address_list) {

        if(!userRepository.existsById(user_id)) {
            throw new NotFoundUser();
        }

        User user = userRepository.findById(user_id).get();
        Post post = Post.builder()
                .title(title)
                .content(content)
                .user(user)
                .picture_address(address_list)
                .build();
        postRepository.save(post);
        return postMapper.mapPostEntityToPostInfo(post);
    }

    public PostInfo updatePost(Long id, String title, String content) {
        Post post = postRepository.findById(id).orElseThrow(NotFoundPost::new);
        post.update(title, content);
        postRepository.save(post);
        return postMapper.mapPostEntityToPostInfo(post);
    }

    @Transactional
    public PostInfo deletePost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(NotFoundPost::new);
        if(!post.getIsActive()){
            throw new NotFoundPost();
        }
        post.delete();
        postRepository.save(post);
        return postMapper.mapPostEntityToPostInfo(post);
    }

    public List<PostInfo> findTotal() {
        return postRepository.findAllByIsActive(true).stream()
                .map(PostInfo::of)
                .collect(Collectors.toList());
    }

    public List<PostInfo> findByUserId(Long user_id) {

        if(!userRepository.existsById(user_id)) {
            throw new NotFoundUser();
        }

        return postRepository.findByUserIdAndIsActive(user_id, true).stream()
                .map(PostInfo::of)
                .collect(Collectors.toList());
    }

    public PostInfoWithComment findByPostId(Long id) {
        Post post = postRepository.findByPostIdAndIsActive(id, true);
        return postMapper.mapPostEntityToPostInfoWithComment(post);

    }

    public List<PostInfo> findByWord(String word) {
        return postRepository.findByWordAndIsActive(word, true)
                .stream()
                .map(PostInfo::of)
                .collect(Collectors.toList());
    }
}
