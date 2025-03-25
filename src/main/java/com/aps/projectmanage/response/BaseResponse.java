package com.aps.projectmanage.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BaseResponse<T> {
    protected String status;
    protected String message;
    protected T data;

    public static <T> BaseResponse<T> failedResponse(String status, String message) {
        return new BaseResponse<>(status, message, null);
    }

}
