package com.aps.projectmanage.domain.dto;

import com.aps.projectmanage.domain.constant.PermissionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PermissionDTO {
    private int id;
    private PermissionType type;
}
