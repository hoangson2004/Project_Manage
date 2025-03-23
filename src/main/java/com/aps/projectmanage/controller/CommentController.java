package com.aps.projectmanage.controller;

import com.aps.projectmanage.domain.dto.CommentDTO;
import com.aps.projectmanage.payload.CommentPayload;
import com.aps.projectmanage.response.BaseResponse;
import com.aps.projectmanage.response.CommentResponse;
import com.aps.projectmanage.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    private CommentResponse commentResponse = new CommentResponse();

    @GetMapping
    public ResponseEntity<BaseResponse<List<CommentDTO>>> getAllCommentsByTaskId(@RequestParam int taskId) {
        BaseResponse<List<CommentDTO>> response = new BaseResponse<>();
        response = commentResponse.getCommentsByTask(commentService.getCommentsByTaskId(taskId));
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{taskId}")
    public ResponseEntity<CommentResponse> createComment(@PathVariable int taskId,@Valid @RequestBody CommentPayload payload) {
        commentResponse = commentResponse.createComment(commentService.createComment(taskId,payload));
        return ResponseEntity.ok(commentResponse);
    }

    @DeleteMapping
    public ResponseEntity<CommentResponse> deleteComment(@RequestParam int id) {
        commentResponse = commentResponse.deleteComment(commentService.deleteComment(id));
        return ResponseEntity.ok(commentResponse);
    }
}
