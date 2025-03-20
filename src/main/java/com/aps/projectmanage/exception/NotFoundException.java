package com.aps.projectmanage.exception;

import com.aps.projectmanage.domain.constant.StatusCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class NotFoundException extends RuntimeException {
    private final StatusCode status;

    public NotFoundException() {
        super("Not Found content");
        this.status = StatusCode.NOT_FOUND;
    }

    public NotFoundException(String message) {
        super(message);
        this.status = StatusCode.NOT_FOUND;
    }
}

