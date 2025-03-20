package com.aps.projectmanage.domain.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskAssignDTO {
    private int taskId;
    private int userId;
    private LocalDateTime createdAt;
}
