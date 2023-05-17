package carrotTeam.carrot.domain.comment.controller;

import carrotTeam.carrot.domain.comment.dto.CommentInfo;
import carrotTeam.carrot.domain.comment.dto.CommentRequest;
import carrotTeam.carrot.domain.comment.dto.CommentResponse;
import carrotTeam.carrot.domain.comment.service.CommentService;
import carrotTeam.carrot.global.result.ResultCode;
import carrotTeam.carrot.global.result.ResultResponse;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CommentController {

  private final CommentService commentService;

  @PostMapping("/api/comments")
  public ResponseEntity<ResultResponse> createComment(
      @Valid @RequestBody CommentRequest commentRequest) {

    CommentInfo commentInfo = commentService.createComment(commentRequest);
    return ResponseEntity.ok(ResultResponse.of(ResultCode.CREATE_COMMENT_SUCCESS, commentInfo));
  }

  @GetMapping("/api/comments/{post_id}")
  public ResponseEntity<ResultResponse> getCommentList(@PathVariable Long post_id) {

    List<CommentResponse> commentList = commentService.findCommentByPostId(post_id);
    return ResponseEntity.ok(
        ResultResponse.of(ResultCode.GET_ONE_POST_COMMENT_SUCCESS, commentList));
  }

  @DeleteMapping("/api/comments/{comment_id}")
  public ResponseEntity<ResultResponse> deleteComment(@PathVariable Long comment_id) {

    commentService.deleteComment(comment_id);
    return ResponseEntity.ok(ResultResponse.of(ResultCode.DELETE_COMMENT_SUCCESS));
  }


}
