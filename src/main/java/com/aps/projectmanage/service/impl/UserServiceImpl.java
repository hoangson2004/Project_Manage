package com.aps.projectmanage.service.impl;

import com.aps.projectmanage.domain.dto.UserDTO;
import com.aps.projectmanage.domain.entity.User;
import com.aps.projectmanage.domain.repository.UserRepository;
import com.aps.projectmanage.exception.GlobalExceptionHandler;
import com.aps.projectmanage.exception.NotFoundException;
import com.aps.projectmanage.mapper.UserMapper;
import com.aps.projectmanage.payload.CreateUserPayload;
import com.aps.projectmanage.payload.UpdateUserPayload;
import com.aps.projectmanage.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDTO createUser(CreateUserPayload userPayload) {
        User user = userMapper.toEntity(userPayload);
        user.setPassword(passwordEncoder.encode(userPayload.getPassword()));
        user = userRepository.save(user);
        return userMapper.toDTO(user);
    }

    @Override
    public Optional<UserDTO> getUserById(int id) {
        return userRepository.findById(id)
                .map(userMapper::toDTO);
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO updateUser(UpdateUserPayload userPayload, int id) {
        User existingUser = userRepository.getById(id);

        if (userPayload.getFullName() != null) {
            existingUser.setFullName(userPayload.getFullName());
        }
        if (userPayload.getEmail() != null) {
            existingUser.setEmail(userPayload.getEmail());
        }
        if (userPayload.getPassword() != null) {
            existingUser.setPassword(userPayload.getPassword());
        }

        return userMapper.toDTO(userRepository.save(existingUser));
    }


    @Override
    public int deleteUserById(int id) {
        userRepository.existsById(id);
        User user = userRepository.findById(id).get();
        user.setIsActive(false);
        userRepository.save(user);
        return id;
    }
}
