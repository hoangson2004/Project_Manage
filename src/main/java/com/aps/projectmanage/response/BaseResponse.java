package com.aps.projectmanage.response;

import com.aps.projectmanage.domain.constant.StatusCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse<T> {
    private String status;
    private String message;
    private T data;

    public static <T> BaseResponse<T> failedResponse(String status, String message) {
        return new BaseResponse<>(status, message, null);
    }

}
