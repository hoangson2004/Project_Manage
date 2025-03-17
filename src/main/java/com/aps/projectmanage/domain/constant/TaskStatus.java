package com.aps.projectmanage.domain.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

<<<<<<< HEAD
=======
import java.util.Arrays;

>>>>>>> eef54f1 (fix repo)
@Getter
@RequiredArgsConstructor
public enum TaskStatus {
    TODO(1, "To Do"),
    IN_PROGRESS(2, "In Progress"),
    DONE(3, "Done");

    private final int value;
    private final String label;
<<<<<<< HEAD
=======

    public static TaskStatus fromValue(int value) {
        return Arrays.stream(TaskStatus.values())
                .filter(status -> status.value == value)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid Task Status Value: " + value));
    }

    public static String getLabelByValue(int value) {
        return fromValue(value).label;
    }
>>>>>>> eef54f1 (fix repo)
}