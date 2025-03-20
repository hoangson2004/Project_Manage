package com.aps.projectmanage.domain.entity;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class RolePermissionKey implements Serializable {

    private int roleId;
    private int permissionId;
}
