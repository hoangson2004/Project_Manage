package com.aps.projectmanage.service;

import com.aps.projectmanage.domain.dto.UserDTO;
import com.aps.projectmanage.payload.CreateUserPayload;
import com.aps.projectmanage.payload.UpdateUserPayload;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDTO create(CreateUserPayload payload);
    Optional<UserDTO> getById(int id);
    List<UserDTO> getAll();
    UserDTO update(UpdateUserPayload payload, int id);
    int deleteById(int id);
}
