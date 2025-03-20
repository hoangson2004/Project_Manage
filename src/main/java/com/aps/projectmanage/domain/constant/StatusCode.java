package com.aps.projectmanage.domain.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusCode {
    SUCCESS("200 Success"),
    CREATED("201 Created"),
    NO_CONTENT("204 No Content"),

    BAD_REQUEST("400 Bad Request"),
    UNAUTHORIZED("401 Unauthorized"),
    FORBIDDEN("403 Forbidden"),
    NOT_FOUND("404 Not Found"),
    CONFLICT("409 Conflict"),

    INTERNAL_SERVER_ERROR("500 Internal Server Error"),
    SERVICE_UNAVAILABLE("503 Service Unavailable");

    private final String statusCode;
}
