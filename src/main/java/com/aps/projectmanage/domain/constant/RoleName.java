package com.aps.projectmanage.domain.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum RoleName {
    ADMIN(1, "Admin"),
    USER(2, "User"),
    MEMBER(3, "Member"),
    PROJECT_MANAGER(4, "Project_Manager");

    private final int value;
    private final String label;

    public static RoleName fromValue(int value) {
        return Arrays.stream(RoleName.values())
                .filter(role -> role.value == value)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid role value: " + value));
    }

    public static RoleName fromLabel(String label) {
        return Arrays.stream(RoleName.values())
                .filter(role -> role.label.equalsIgnoreCase(label))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid role label: " + label));
    }
}
