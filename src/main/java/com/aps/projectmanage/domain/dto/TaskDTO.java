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
    private String project;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
