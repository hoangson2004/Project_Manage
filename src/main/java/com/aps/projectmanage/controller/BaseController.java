package com.aps.projectmanage.controller;

import com.aps.projectmanage.domain.constant.StatusCode;
import com.aps.projectmanage.response.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController<T> {

    protected ResponseEntity<?> handleSuccess(String message, T data) {
        return ResponseEntity.ok(BaseResponse.<T>builder()
                .status(StatusCode.SUCCESS.getStatusCode())
                .message(message)
                .data(data)
                .build());
    }

    protected ResponseEntity<?> handleSuccess(StatusCode status,String message, T data) {
        return ResponseEntity.ok(BaseResponse.<T>builder()
                .status(status.getStatusCode())
                .message(message)
                .data(data)
                .build());
    }

    protected BaseResponse<T> handleError(String message) {
        return BaseResponse.<T>builder()
                .status(StatusCode.BAD_REQUEST.getStatusCode())
                .message(message)
                .build();
    }
}
