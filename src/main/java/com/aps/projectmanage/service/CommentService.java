package com.aps.projectmanage.service;

import com.aps.projectmanage.domain.dto.CommentDTO;
import com.aps.projectmanage.payload.CommentPayload;

import java.util.List;

public interface CommentService {
    CommentDTO createComment(int userId, int taskId, CommentPayload payload);
    List<CommentDTO> getCommentsByTaskId(int taskId);
    int deleteComment(int commentId);
}
