package com.aps.projectmanage.service;

import com.aps.projectmanage.domain.dto.UserDTO;
import com.aps.projectmanage.payload.CreateUserPayload;
import com.aps.projectmanage.payload.LoginPayload;
import com.aps.projectmanage.response.AuthResponse;

public interface AuthService {
    AuthResponse register(CreateUserPayload payload);
    AuthResponse login(LoginPayload payload);
}
