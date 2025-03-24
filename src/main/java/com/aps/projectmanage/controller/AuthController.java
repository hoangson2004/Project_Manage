package com.aps.projectmanage.controller;

import com.aps.projectmanage.payload.CreateUserPayload;
import com.aps.projectmanage.payload.LoginPayload;
import com.aps.projectmanage.response.AuthResponse;
import com.aps.projectmanage.response.UserResponse;
import com.aps.projectmanage.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private AuthResponse authResponse;
    private UserResponse userResponse = new UserResponse();

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody CreateUserPayload payload) {
        userResponse = userResponse.createUser(authService.register(payload));
        return ResponseEntity.ok(userResponse);

    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginPayload payload) {
        authResponse = authResponse.login(authService.login(payload));
        return ResponseEntity.ok(authResponse);
    }
}
