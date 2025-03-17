package com.aps.projectmanage.service.impl;

import com.aps.projectmanage.domain.entity.Permission;
import com.aps.projectmanage.domain.repository.PermissionRepository;
import com.aps.projectmanage.service.PermissionService;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl extends BaseServiceImpl<Permission, Long> implements PermissionService {
    public PermissionServiceImpl(PermissionRepository permissionRepository) {
        super(permissionRepository);
    }
}