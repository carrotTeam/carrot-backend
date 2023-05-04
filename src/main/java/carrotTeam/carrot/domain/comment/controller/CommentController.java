package carrotTeam.carrot.domain.comment.controller;

import carrotTeam.carrot.domain.comment.domain.entity.Comment;
import carrotTeam.carrot.domain.comment.dto.CommentInfo;
import carrotTeam.carrot.domain.comment.dto.CommentRequest;
import org.springframework.web.bind.annotation.*;
import carrotTeam.carrot.domain.comment.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/api/comments")
    public ResponseEntity createComment(@Valid @RequestBody CommentRequest commentRequest) {

        CommentInfo commentInfo = commentService.createComment(commentRequest);
        return ResponseEntity.ok(commentInfo);
    }



}
