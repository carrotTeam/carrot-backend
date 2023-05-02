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
    public PostInfo creatPost (
            @RequestPart(value = "files", required=true) List<MultipartFile> files,
            @RequestPart(value = "requestDto") PostRequest request
    ) throws Exception {

        List<String> address_list = new ArrayList<>();

        for(MultipartFile file : files) {
            String picture_address = service.upload(file);
            address_list.add(picture_address);
        }

        return service.createPost(request.getUser_id(), request.getTitle(), request.getContent(), address_list);
    }


//    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
//    public PostInfo uploadFile(
//            @RequestPart(value = "images", required = false) MultipartFile multipartFile,
//            @RequestPart(value = "request") PostRequest request
//    ) throws IOException {
//        String picture_address = service.upload(multipartFile);
//        return service.createPost(request, picture_address);
//    }

    @PutMapping
    public PostInfo updatePost (
            @RequestBody PostUpdateRequest request
    ) throws IOException {
        return service.updatePost(request.getPost_id(), request.getTitle(), request.getContent());
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


}
