package carrotTeam.carrot.domain.post.controller;

import carrotTeam.carrot.domain.post.dto.PostInfo;
import carrotTeam.carrot.domain.post.dto.PostRequest;
import carrotTeam.carrot.domain.post.dto.PostUpdateRequest;
import carrotTeam.carrot.domain.post.service.PostService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService service;


    @PostMapping(value = "/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public PostInfo uploadFile(@RequestPart(value = "images", required = false) MultipartFile multipartFile, @RequestPart(value = "request") PostRequest request) throws IOException {
        String picture_address = service.upload(multipartFile);
        return service.createPost(request, picture_address);
    }

    @PutMapping(value = "/update")
    public PostInfo updatePost(@RequestBody PostUpdateRequest request) throws IOException {
        return service.updatePost(request.getPost_id(), request.getTitle(), request.getContent());
    }

    @DeleteMapping(value = "/delete/{id}")
    public PostInfo updatePost(@PathVariable Long id) throws IOException {
        return service.deletePost(id);
    }
}
