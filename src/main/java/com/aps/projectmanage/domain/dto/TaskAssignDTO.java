package com.aps.projectmanage.domain.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskAssignDTO {
    private Long taskId;
    private Long userId;
    private LocalDateTime createdAt;
}
