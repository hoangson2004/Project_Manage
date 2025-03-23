package com.aps.projectmanage.domain.entity;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
@Getter
@Setter
public class RolePermissionKey implements Serializable {

    private int roleId;
    private int permissionId;
}
