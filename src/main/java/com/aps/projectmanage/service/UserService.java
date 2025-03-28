package com.aps.projectmanage.service;

import com.aps.projectmanage.domain.dto.UserDTO;
import com.aps.projectmanage.domain.entity.User;
import com.aps.projectmanage.payload.CreateUserPayload;
import com.aps.projectmanage.payload.UpdateUserPayload;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDTO createUser(CreateUserPayload payload);
    Optional<UserDTO> getUserById(int id);
    Optional<User> getUserByUsername(String username);
    List<UserDTO> getAllUsers();
    UserDTO updateUser(UpdateUserPayload payload, int id);
    int deleteUserById(int id);
}
