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
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDTO create(CreateUserPayload userPayload) {
        User user = userMapper.toEntity(userPayload);
        user = userRepository.save(user);
        return userMapper.toDTO(user);
    }

    @Override
    public Optional<UserDTO> getById(int id) {
        return userRepository.findById(id)
                .map(userMapper::toDTO);
    }

    @Override
    public List<UserDTO> getAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO update(UpdateUserPayload userPayload, int id) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException());

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
    public int deleteById(int id) {
        if (!userRepository.existsById(id)) {
            throw new NotFoundException();
        }
        User user = userRepository.findById(id).get();
        user.setIsActive(false);
        userRepository.save(user);
        return id;
    }
}
