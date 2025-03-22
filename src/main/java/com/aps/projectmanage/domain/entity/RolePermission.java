package com.aps.projectmanage.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Getter
@Setter
@Entity
@Table(name = "role_permissions")
@SQLDelete(sql = "UPDATE users SET is_active=false WHERE id = ?")
@Where(clause = "is_active != false")
public class RolePermission extends BaseEntity{

    @EmbeddedId
    private RolePermissionKey id;

    @ManyToOne
    @MapsId("roleId")
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne
    @MapsId("permissionId")
    @JoinColumn(name = "permission_id")
    private Permission permission;
}
