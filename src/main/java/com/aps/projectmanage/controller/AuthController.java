package com.aps.projectmanage.controller;

import com.aps.projectmanage.domain.constant.StatusCode;
import com.aps.projectmanage.payload.CreateUserPayload;
import com.aps.projectmanage.payload.LoginPayload;
import com.aps.projectmanage.response.AuthResponse;
import com.aps.projectmanage.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class AuthController extends BaseController<AuthResponse> {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody CreateUserPayload payload) {
        return handleSuccess(StatusCode.CREATED, "Register success", authService.register(payload));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginPayload payload) {
        log.info("ResponseEntity trả về: {}", handleSuccess("Login success", authService.login(payload)));
        return handleSuccess("Login success", authService.login(payload));
    }
}
