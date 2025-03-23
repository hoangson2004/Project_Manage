package com.aps.projectmanage.service;

import com.aps.projectmanage.domain.dto.PermissionDTO;

import java.util.List;

public interface PermissionService {
    List<PermissionDTO> getAllPermissions();
    List<PermissionDTO> getPermissionsByRole(String role);
    List<PermissionDTO> updatePermissionsByRoleId(String role, List<Integer> permissionIds);
}
