package com.aps.projectmanage.service;

import com.aps.projectmanage.domain.dto.UserDTO;
import com.aps.projectmanage.payload.CreateUserPayload;
import com.aps.projectmanage.payload.LoginPayload;

public interface AuthService {
    UserDTO register(CreateUserPayload payload);
    String login(LoginPayload payload);
}
