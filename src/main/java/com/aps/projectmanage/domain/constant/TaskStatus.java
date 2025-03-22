package com.aps.projectmanage.domain.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TaskStatus {
    TODO("To Do"),
    IN_PROGRESS("In Progress"),
    DONE("Completed");

    private final String displayName;

    public String getDisplayName() {
        return this.displayName;
    }
}
