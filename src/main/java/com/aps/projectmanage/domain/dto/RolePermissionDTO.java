package com.aps.projectmanage.domain.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RolePermissionDTO {
    private Long roleId;
    private Long permissionId;
}
