package com.aps.projectmanage.domain.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PermissionType {
    CREATE_PROJECT(1, "CREATE_PROJECT"),
    VIEW_PROJECT(2, "VIEW_PROJECT"),
    EDIT_PROJECT(3, "EDIT_PROJECT"),
    DELETE_PROJECT(4, "DELETE_PROJECT"),
    MANAGE_USERS(5, "MANAGE_USERS"),
    CREATE_TASK(6, "CREATE_TASK"),
    EDIT_TASK(7, "EDIT_TASK"),
    DELETE_TASK(8, "DELETE_TASK"),
    MANAGE_MEMBER(9, "MANAGE_MEMBER");

    private final int value;
    private final String label;
}
