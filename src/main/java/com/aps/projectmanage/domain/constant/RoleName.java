package com.aps.projectmanage.domain.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RoleName {
    ADMIN(1, "Admin"),
    USER(2, "User"),
    MEMBER(3, "Member"),
    PROJECT_MANAGER(4, "Project Manager");

    private final int value;
    private final String label;
    }
}

