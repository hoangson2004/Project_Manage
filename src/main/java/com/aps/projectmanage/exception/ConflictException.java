package com.aps.projectmanage.exception;

import com.aps.projectmanage.domain.constant.StatusCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class ConflictException extends RuntimeException{
    private StatusCode status;
    private String message;

    public ConflictException() {
        this.status = StatusCode.CONFLICT;
        this.message = "message";
    }

    public ConflictException(String message) {
        this.status = StatusCode.CONFLICT;
        this.message = message;
    }
}
