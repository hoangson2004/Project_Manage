package com.aps.projectmanage.response;

import com.aps.projectmanage.domain.constant.StatusCode;
import com.aps.projectmanage.domain.dto.UserDTO;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AuthResponse extends BaseResponse<String> {

    public AuthResponse(String status, String message, String data) {
        super(status, message, data);
    }

    public AuthResponse login(String token) {
        return new AuthResponse(
                StatusCode.SUCCESS.getStatusCode(),
                "Login success",
                token
        );
    }

}
