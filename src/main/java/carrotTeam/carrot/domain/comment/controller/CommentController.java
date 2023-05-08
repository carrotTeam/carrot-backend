package carrotTeam.carrot.domain.comment.controller;

import carrotTeam.carrot.domain.comment.domain.entity.Comment;
import carrotTeam.carrot.domain.comment.dto.CommentInfo;
import carrotTeam.carrot.domain.comment.dto.CommentRequest;
import carrotTeam.carrot.domain.comment.dto.CommentResponse;
import carrotTeam.carrot.global.result.ResultCode;
import carrotTeam.carrot.global.result.ResultResponse;
import org.springframework.web.bind.annotation.*;
import carrotTeam.carrot.domain.comment.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/api/comments")
    public ResponseEntity<ResultResponse> createComment(@Valid @RequestBody CommentRequest commentRequest) {

        CommentInfo commentInfo = commentService.createComment(commentRequest);
        return ResponseEntity.ok(ResultResponse.of(ResultCode.CREATE_COMMENT_SUCCESS, commentInfo));
    }

    @GetMapping("/api/comments/{post_Id}")
    public ResponseEntity<ResultResponse> getCommentList(@PathVariable Long post_Id) {

        List<CommentResponse> commentList = commentService.findCommentByPostId(post_Id);
        return ResponseEntity.ok(ResultResponse.of(ResultCode.GET_ONE_POST_COMMENT_SUCCESS, commentList));
    }


}
