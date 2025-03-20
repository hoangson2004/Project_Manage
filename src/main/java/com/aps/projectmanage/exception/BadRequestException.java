package com.aps.projectmanage.exception;

import com.aps.projectmanage.domain.constant.StatusCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class BadRequestException extends RuntimeException{
    private StatusCode status;
    private String message;

    public BadRequestException() {
        this.status = StatusCode.BAD_REQUEST;
        this.message = "message";
    }
}

