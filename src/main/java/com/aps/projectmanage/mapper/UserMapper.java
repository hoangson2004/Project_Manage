package com.aps.projectmanage.mapper;

import com.aps.projectmanage.domain.constant.RoleName;
import com.aps.projectmanage.domain.dto.RoleDTO;
import com.aps.projectmanage.domain.dto.UserDTO;
import com.aps.projectmanage.domain.entity.Role;
import com.aps.projectmanage.domain.entity.User;
import com.aps.projectmanage.payload.CreateUserPayload;
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
        } else dto.setRole(RoleName.USER.getLabel());
        return dto;
    }

    public User toEntity(CreateUserPayload userPayload) {
        User user = modelMapper.map(userPayload, User.class);
        user.setRole(new Role( RoleName.USER.getValue(), RoleName.USER.getValue()));
        return user;
    }
}
