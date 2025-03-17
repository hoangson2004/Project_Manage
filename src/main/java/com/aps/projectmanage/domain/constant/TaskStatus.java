package com.aps.projectmanage.domain.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TaskStatus {
    TODO(1, "To Do"),
    IN_PROGRESS(2, "In Progress"),
    DONE(3, "Done");

    private final int value;
    private final String label;
    }
}