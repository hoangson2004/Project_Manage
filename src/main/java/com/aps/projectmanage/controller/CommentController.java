package com.aps.projectmanage.controller;

import com.aps.projectmanage.payload.CommentPayload;
import com.aps.projectmanage.response.BaseResponse;
import com.aps.projectmanage.service.CommentService;
import com.aps.projectmanage.util.SercurityUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController extends BaseController<Object> {

    private final CommentService commentService;

    @GetMapping
    public ResponseEntity<?> getAllCommentsByTaskId(@RequestParam int taskId) {
        return handleSuccess("Get all comments success", commentService.getCommentsByTaskId(taskId));
    }

    @PostMapping("/{taskId}")
    public ResponseEntity<?> createComment(@PathVariable int taskId,@Valid @RequestBody CommentPayload payload) {
        Integer userId = SercurityUtil.getCurrentUserId();
        return handleSuccess("Create comment success", commentService.createComment(userId, taskId, payload));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteComment(@RequestParam int id) {
        return handleSuccess("Delete comment success", commentService.deleteComment(id));
    }
}
