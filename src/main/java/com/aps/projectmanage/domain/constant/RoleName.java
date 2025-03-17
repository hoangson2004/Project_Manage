package com.aps.projectmanage.domain.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum RoleName {
    ADMIN(1, "Admin"),
    USER(2, "User"),
    MEMBER(3, "Member"),
    PROJECT_MANAGER(4, "Project Manager");

    private final int value;
    private final String label;

    public static RoleName fromValue(int value) {
        return Arrays.stream(RoleName.values())
                .filter(role -> role.value == value)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid Role Value: " + value));
    }

    public static String getLabelByValue(int value) {
        return fromValue(value).label;
    }
}

