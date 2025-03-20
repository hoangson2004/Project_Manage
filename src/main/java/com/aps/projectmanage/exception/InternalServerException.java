package com.aps.projectmanage.exception;

import com.aps.projectmanage.domain.constant.StatusCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class InternalServerException extends RuntimeException{
    private StatusCode status;
    private String message;

    public InternalServerException() {
        this.status = StatusCode.INTERNAL_SERVER_ERROR;
        this.message = "System error, please try again later";
    }

    public InternalServerException(String message) {
        this.status = StatusCode.INTERNAL_SERVER_ERROR;
        this.message = message;
    }
}
