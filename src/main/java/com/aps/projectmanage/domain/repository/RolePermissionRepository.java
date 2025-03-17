package com.aps.projectmanage.domain.repository;

import com.aps.projectmanage.domain.entity.RolePermission;
import com.aps.projectmanage.domain.entity.RolePermissionKey;
import org.springframework.stereotype.Repository;

@Repository
public interface RolePermissionRepository extends BaseRepository<RolePermission, RolePermissionKey> {
}
