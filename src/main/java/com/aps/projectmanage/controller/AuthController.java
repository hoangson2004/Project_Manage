package com.aps.projectmanage.controller;

import com.aps.projectmanage.domain.constant.StatusCode;
import com.aps.projectmanage.domain.entity.User;
import com.aps.projectmanage.payload.CreateUserPayload;
import com.aps.projectmanage.payload.LoginPayload;
import com.aps.projectmanage.response.AuthResponse;
import com.aps.projectmanage.service.AuthService;
import com.aps.projectmanage.service.UserService;
import com.aps.projectmanage.service.JwtService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class AuthController extends BaseController<AuthResponse> {
    private final AuthService authService;
    private final JwtService jwtService;
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody CreateUserPayload payload) {
        return handleSuccess(StatusCode.CREATED, "Register success", authService.register(payload));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginPayload payload) {
        log.info("ResponseEntity trả về: {}", handleSuccess("Login success", authService.login(payload)));
        return handleSuccess("Login success", authService.login(payload));
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<?> refreshToken(@RequestHeader("Authorization") String refreshToken) {
        if (refreshToken.startsWith("Bearer ")) {
            refreshToken = refreshToken.substring(7);
            String username = jwtService.extractUsername(refreshToken);
            User user = userService.getUserByUsername(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));

            if (jwtService.isTokenValid(refreshToken, username)) {
                return ResponseEntity.ok(new AuthResponse(jwtService.generateAccessToken(user), refreshToken));
            }
        }

        return ResponseEntity.status(HttpServletResponse.SC_UNAUTHORIZED).body(null);
    }
}
