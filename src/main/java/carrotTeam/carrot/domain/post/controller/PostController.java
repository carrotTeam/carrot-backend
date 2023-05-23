package carrotTeam.carrot.domain.post.controller;

import carrotTeam.carrot.domain.post.dto.PostInfo;
import carrotTeam.carrot.domain.post.dto.PostInfoWithComment;
import carrotTeam.carrot.domain.post.dto.PostRequest;
import carrotTeam.carrot.domain.post.dto.PostUpdateRequest;
import carrotTeam.carrot.domain.post.service.PostService;

import carrotTeam.carrot.global.result.ResultCode;
import carrotTeam.carrot.global.result.ResultResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/posts")
@RequiredArgsConstructor
@RestController
public class PostController {

  private final PostService service;

  @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<ResultResponse> createPost(
      @RequestPart(value = "files", required = true) List<MultipartFile> files,
      @RequestPart(value = "requestDto") PostRequest postRequest
  ) {
    List<String> address_list = new ArrayList<>();

    for (MultipartFile file : files) {
      String picture_address = service.upload(file);
      address_list.add(picture_address);
    }

    PostInfo postInfo = service.createPost(postRequest.getUser_id(), postRequest.getTitle(),
        postRequest.getContent(), address_list);
    return ResponseEntity.ok(ResultResponse.of(ResultCode.CREATE_POST_SUCCESS, postInfo));
  }


  @PutMapping
  public ResponseEntity<ResultResponse> updatePost(
      @RequestPart(value = "files", required = true) List<MultipartFile> files,
      @RequestPart(value = "requestDto") PostUpdateRequest postUpdateRequest
  ) {
    List<String> address_list = new ArrayList<>();

    for (MultipartFile file : files) {
      String picture_address = service.upload(file);
      address_list.add(picture_address);
    }

    PostInfo postInfo = service.updatePost(postUpdateRequest.getUser_id(),
        postUpdateRequest.getPost_id(),
        postUpdateRequest.getTitle(),
        postUpdateRequest.getContent(), address_list);
    return ResponseEntity.ok(ResultResponse.of(ResultCode.UPDATE_POST_SUCCESS, postInfo));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<ResultResponse> deletePost(
      @PathVariable Long id
  ) {
    PostInfo postInfo = service.deletePost(id);
    return ResponseEntity.ok(ResultResponse.of(ResultCode.DELETE_POST_SUCCESS, postInfo));
  }

  @GetMapping
  public ResponseEntity<ResultResponse> findTotalPost(

  ) {
    List<PostInfo> postList = service.findTotal();
    return ResponseEntity.ok(ResultResponse.of(ResultCode.GET_ALL_POST_SUCCESS, postList));
  }

  @GetMapping("users/{id}")
  public ResponseEntity<ResultResponse> findByUserIdPost(
      @PathVariable Long id
  ) {
    List<PostInfo> postList = service.findByUserId(id);
    return ResponseEntity.ok(ResultResponse.of(ResultCode.GET_USER_POST_SUCCESS, postList));
  }

  @GetMapping("/{id}")
  public PostInfoWithComment findByPostIdPost(
      @PathVariable Long id
  ) {
    return service.findByPostId(id);
  }

  @GetMapping("/word/{word}")
  public ResponseEntity<ResultResponse> findTotalRestaurant(
      @RequestParam String word
  ) {
    List<PostInfo> postList = service.findByWord(word);
    return ResponseEntity.ok(ResultResponse.of(ResultCode.GET_USER_POST_SUCCESS, postList));
  }


}
