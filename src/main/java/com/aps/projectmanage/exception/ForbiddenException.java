package com.aps.projectmanage.exception;

import com.aps.projectmanage.domain.constant.StatusCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class ForbiddenException extends RuntimeException{
    private StatusCode status;
    private String message;

    public ForbiddenException() {
        this.status = StatusCode.FORBIDDEN;
        this.message = "You have not permission to access this resource";
    }
}
