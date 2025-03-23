package com.aps.projectmanage.response;

import com.aps.projectmanage.domain.constant.StatusCode;
import com.aps.projectmanage.domain.dto.CommentDTO;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class CommentResponse extends BaseResponse<CommentDTO> {
    public CommentResponse(String status, String message, CommentDTO data) {
        super(status, message, data);
    }


    public CommentResponse createComment(CommentDTO data) {
        return new CommentResponse(
                StatusCode.SUCCESS.getStatusCode(),
                "Added comment successfully",
                data);
    }

    public BaseResponse<List<CommentDTO>> getCommentsByTask(List<CommentDTO> comments) {
        return new BaseResponse<>(
                StatusCode.SUCCESS.getStatusCode(),
                "Fetched all comments for task ID successfully",
                comments
        );
    }
    
    public CommentResponse deleteComment(int commentId) {
        return new CommentResponse(
                StatusCode.SUCCESS.getStatusCode(),
                "Deleted comment with ID " + commentId + " successfully",
                null);
    }
}

