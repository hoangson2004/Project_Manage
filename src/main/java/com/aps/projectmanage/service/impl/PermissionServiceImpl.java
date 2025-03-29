package com.aps.projectmanage.service.impl;

import com.aps.projectmanage.domain.constant.RoleName;
import com.aps.projectmanage.domain.dto.PermissionDTO;
import com.aps.projectmanage.domain.entity.Permission;
import com.aps.projectmanage.domain.entity.Role;
import com.aps.projectmanage.domain.entity.RolePermission;
import com.aps.projectmanage.domain.entity.RolePermissionKey;
import com.aps.projectmanage.domain.repository.PermissionRepository;
import com.aps.projectmanage.domain.repository.RolePermissionRepository;
import com.aps.projectmanage.domain.repository.RoleRepository;
import com.aps.projectmanage.service.PermissionService;
import com.aps.projectmanage.service.RedisService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService {
    private final PermissionRepository permissionRepository;
    private final RolePermissionRepository rolePermissionRepository;
    private final RoleRepository roleRepository;
    private ModelMapper modelMapper = new ModelMapper();
    private final RedisService redisService;

    @Override
    public List<PermissionDTO> getAllPermissions() {
        List<Permission> permissions = permissionRepository.findAll();
        return permissions.stream()
                .map(permission -> modelMapper.map(permission, PermissionDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PermissionDTO> getPermissionsByRole(String roleLabel) {
        RoleName roleName;
        roleName = RoleName.fromLabel(roleLabel);


        int roleId = roleName.getValue();
        List<RolePermission> rolePermissions = rolePermissionRepository.findByRoleId(roleId);
        return rolePermissions.stream()
                .map(rp -> modelMapper.map(rp.getPermission(), PermissionDTO.class))
                .collect(Collectors.toList());
    }


    @Override
    @Transactional
    public List<PermissionDTO> updatePermissionsByRoleId(String roleLabel, List<Integer> permissionIds) {
        RoleName roleName;
        roleName = RoleName.fromLabel(roleLabel);

        int roleId = roleName.getValue();
        Role role = roleRepository.findById(roleId).get();

        rolePermissionRepository.deleteByRoleId(roleId);

        List<RolePermission> newRolePermissions = new ArrayList<>();

        for (Integer p : permissionIds) {
            Permission permission = permissionRepository.findById(p).get();
            RolePermission rolePermission = new RolePermission();
            RolePermissionKey key = new RolePermissionKey();
            key.setRoleId(roleId);
            key.setPermissionId(p);

            rolePermission.setId(key);
            rolePermission.setRole(role);
            rolePermission.setPermission(permission);

            newRolePermissions.add(rolePermission);
        }

        rolePermissionRepository.saveAll(newRolePermissions);

        redisService.clearAllCache();

        return newRolePermissions.stream()
                .map(rp -> modelMapper.map(rp.getPermission(), PermissionDTO.class))
                .collect(Collectors.toList());
    }

}
