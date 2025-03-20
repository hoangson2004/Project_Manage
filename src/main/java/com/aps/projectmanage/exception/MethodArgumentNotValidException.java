package com.aps.projectmanage.exception;

import com.aps.projectmanage.domain.constant.StatusCode;
import lombok.Getter;

@Getter
public class MethodArgumentNotValidException extends RuntimeException {
    private StatusCode status;
    private String message;

    public MethodArgumentNotValidException(String message) {
        this.status = StatusCode.BAD_REQUEST;
        this.message = message;
    }

    public MethodArgumentNotValidException() {
        this.status = StatusCode.BAD_REQUEST;
        this.message = "Not valid argument";
    }
}
