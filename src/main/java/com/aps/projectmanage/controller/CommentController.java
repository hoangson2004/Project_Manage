package com.aps.projectmanage.controller;

import com.aps.projectmanage.payload.CommentPayload;
import com.aps.projectmanage.response.BaseResponse;
import com.aps.projectmanage.service.CommentService;
import com.aps.projectmanage.util.HasProjectPermission;
import com.aps.projectmanage.util.HasTaskPermission;
import com.aps.projectmanage.util.SecurityUtil;
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
    @HasTaskPermission("EDIT_TASK")
    public ResponseEntity<?> getAllCommentsByTaskId(@RequestParam int taskId) {
        return handleSuccess("Get all comments success", commentService.getCommentsByTaskId(taskId));
    }

    @PostMapping("/{taskId}")
    @HasTaskPermission("EDIT_TASK")
    public ResponseEntity<?> createComment(@PathVariable int taskId,@Valid @RequestBody CommentPayload payload) {
        int userId = SecurityUtil.getCurrentUserId();
        return handleSuccess("Create comment success", commentService.createComment(userId, taskId, payload));
    }

    @DeleteMapping
    @HasTaskPermission("EDIT_TASK")
    public ResponseEntity<?> deleteComment(@RequestParam int id) {
        return handleSuccess("Delete comment success", commentService.deleteComment(id));
    }
}
