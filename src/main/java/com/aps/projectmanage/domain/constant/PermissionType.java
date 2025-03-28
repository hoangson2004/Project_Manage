package com.aps.projectmanage.domain.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PermissionType {
    CREATE_PROJECT,
    VIEW_PROJECT,
    EDIT_PROJECT,
    DELETE_PROJECT,
    ASSIGN_TASK,
    CREATE_TASK,
    EDIT_TASK,
    DELETE_TASK,
    MANAGE_MEMBER;
}
