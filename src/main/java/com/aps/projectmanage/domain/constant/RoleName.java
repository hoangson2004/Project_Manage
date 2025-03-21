package com.aps.projectmanage.domain.constant;

import java.util.Arrays;

public enum RoleName {
    ADMIN(1, "Admin"),
    USER(2, "User"),
    MEMBER(3, "Member"),
    PROJECT_MANAGER(4, "Project Manager");

    private final int value;
    private final String label;

    RoleName(int value, String label) {
        this.value = value;
        this.label = label;
    }

    public int getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }

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
