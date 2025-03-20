package com.aps.projectmanage.mapper;

import com.aps.projectmanage.domain.dto.RoleDTO;
import com.aps.projectmanage.domain.dto.UserDTO;
import com.aps.projectmanage.domain.entity.Role;
import com.aps.projectmanage.domain.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    private final ModelMapper modelMapper;

    public UserMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public UserDTO toDTO(User user) {
        UserDTO dto = modelMapper.map(user, UserDTO.class);
        if (user.getRole() != null) {
            dto.setRole(RoleMapper.toDTO(user.getRole().getRoleValue()));
        }
        return dto;
    }

    public User toEntity(UserDTO dto) {
        User user = modelMapper.map(dto, User.class);
        if (dto.getRole() != null) {
            user.setRole(RoleMapper.toEntity(dto.getRole()));
        }
        return user;
    }
}
