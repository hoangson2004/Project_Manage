package com.aps.projectmanage.response;

import com.aps.projectmanage.domain.constant.StatusCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BaseResponse<T> {
    private final String status;
    private final String message;
    private final T data;

    public static <T> BaseResponse<T> successResponse(String status, String message, T data) {
        return new BaseResponse<>(status, message, data);
    }

    public static <T> BaseResponse<T> failedResponse(String status, String message) {
        return new BaseResponse<>(status, message, null);
    }

    public static <T> BaseResponse<T> failedResponse(String status, String message, T data) {
        return new BaseResponse<>(status, message, data);
    }
}
