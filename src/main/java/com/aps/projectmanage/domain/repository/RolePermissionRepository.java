package com.aps.projectmanage.domain.repository;

import com.aps.projectmanage.domain.entity.RolePermission;
import com.aps.projectmanage.domain.entity.RolePermissionKey;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolePermissionRepository extends BaseRepository<RolePermission, RolePermissionKey> {
    List<RolePermission> findByRoleId(int roleId);
    void deleteByRoleId(int roleId);

}
