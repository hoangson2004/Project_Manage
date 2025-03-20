package com.aps.projectmanage.exception;

import com.aps.projectmanage.domain.constant.StatusCode;
import lombok.Getter;

@Getter
public class UnknownHostException extends RuntimeException{
    private StatusCode status;
    private String message;

    public UnknownHostException() {
        this.status = StatusCode.UNAUTHORIZED;
        this.message = "You have to login to see this content";
    }
}
