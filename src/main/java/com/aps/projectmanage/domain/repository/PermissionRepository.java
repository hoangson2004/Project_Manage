package com.aps.projectmanage.domain.repository;

import com.aps.projectmanage.domain.entity.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends BaseRepository<Role, Long>{

}
