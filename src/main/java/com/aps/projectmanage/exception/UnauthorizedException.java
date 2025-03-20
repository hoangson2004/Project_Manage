package com.aps.projectmanage.exception;

import com.aps.projectmanage.domain.constant.StatusCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class UnauthorizedException extends RuntimeException{
    private StatusCode status;
    private String message;

    public UnauthorizedException() {
        this.status = StatusCode.UNAUTHORIZED;
        this.message = "You have to login to see this content";
    }
}
