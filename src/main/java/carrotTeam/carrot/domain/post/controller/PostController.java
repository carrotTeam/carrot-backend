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
import java.util.ArrayList;
import java.util.List;
@RequestMapping("/api/posts")
@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService service;

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public PostInfo createPost (
            @RequestPart(value = "files", required=true) List<MultipartFile> files,
            @RequestPart(value = "requestDto") PostRequest postRequest
    ) throws Exception {

        List<String> address_list = new ArrayList<>();

        for(MultipartFile file : files) {
            String picture_address = service.upload(file);
            address_list.add(picture_address);
        }

        return service.createPost(postRequest.getUser_id(), postRequest.getTitle(), postRequest.getContent(), address_list);
    }

    @PutMapping
    public PostInfo updatePost (
            @RequestBody PostUpdateRequest postUpdateRequest
    ) throws IOException {
        return service.updatePost(postUpdateRequest.getPost_id(), postUpdateRequest.getTitle(), postUpdateRequest.getContent());
    }

    @DeleteMapping("/{id}")
    public PostInfo updatePost (
            @PathVariable Long id
    ) throws IOException {
        return service.deletePost(id);
    }

    @GetMapping
    public List<PostInfo> findTotalRestaurant (

    ) throws IOException {
        return service.findTotal();
    }

    @GetMapping("/{id}")
    public List<PostInfo> findTotalRestaurant (
            @PathVariable Long id
    ) throws IOException {
        return service.findById(id);
    }

    @GetMapping("/word/{word}")
    public List<PostInfo> findTotalRestaurant (
            @RequestParam String word
    ) throws IOException {
        return service.findByWord(word);
    }


//    @GetMapping("/test")
//    public void flushViewsTest (
//    ) throws IOException {
//        service.flushViews();
//    }

}
