package com.aps.projectmanage.mapper;

import com.aps.projectmanage.domain.constant.RoleName;
import com.aps.projectmanage.domain.entity.Role;

public class RoleMapper {
    public static String toDTO(int role) {
        RoleName roleName = RoleName.fromValue(role);
        return roleName.getLabel();
    }

    public static Role toEntity(String roleDTO) {
        RoleName roleName = RoleName.fromLabel(roleDTO);
        return new Role(roleName.getValue(), roleName.getValue());
    }

    public static int toInt(String roleDTO) {
        RoleName roleName = RoleName.fromLabel(roleDTO);
        return roleName.getValue();
    }
}

