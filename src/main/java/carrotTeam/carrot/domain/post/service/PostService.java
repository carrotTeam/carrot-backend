package carrotTeam.carrot.domain.post.service;

//import carrotTeam.carrot.domain.post.domain.repository.PostRepository;
//import carrotTeam.carrot.domain.post.dto.PostInfo;
//import carrotTeam.carrot.domain.post.dto.PostRequest;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import org.springframework.beans.factory.annotation.Value;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PostService {
    // private final PostRepository repository;

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

//    public PostInfo createPost(PostRequest request) {
//        Post
//    }


}
