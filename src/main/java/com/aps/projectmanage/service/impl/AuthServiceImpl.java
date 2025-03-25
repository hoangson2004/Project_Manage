package com.aps.projectmanage.service.impl;

import com.aps.projectmanage.domain.dto.UserDTO;
import com.aps.projectmanage.domain.entity.User;
import com.aps.projectmanage.domain.repository.UserRepository;
import com.aps.projectmanage.exception.UserNotFoundException;
import com.aps.projectmanage.mapper.UserMapper;
import com.aps.projectmanage.payload.CreateUserPayload;
import com.aps.projectmanage.payload.LoginPayload;
import com.aps.projectmanage.response.AuthResponse;
import com.aps.projectmanage.response.BaseResponse;
import com.aps.projectmanage.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public AuthResponse register(CreateUserPayload payload) {
        User user = userMapper.toEntity(payload);
        user.setPassword(passwordEncoder.encode(payload.getPassword()));
        userRepository.save(user);

        return AuthResponse.builder()
                .token(jwtService.generateToken(user))
                .build();
    }

    @Override
    public AuthResponse login(LoginPayload payload) {
        User user = userRepository.findByUsername(payload.getUsername())
                .orElseThrow(() -> new UserNotFoundException("User Not Found"));

        if (!passwordEncoder.matches(payload.getPassword(), user.getPassword())) {
            throw new UserNotFoundException("Wrong Password");
        }

        return AuthResponse.builder()
                .token(jwtService.generateToken(user))
                .build();
    }
}
