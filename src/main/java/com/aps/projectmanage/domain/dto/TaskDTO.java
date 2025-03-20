package com.aps.projectmanage.domain.dto;

import com.aps.projectmanage.domain.constant.TaskStatus;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {
    private int id;
    private String name;
    private String description;
    private ProjectDTO project;
    private TaskStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
