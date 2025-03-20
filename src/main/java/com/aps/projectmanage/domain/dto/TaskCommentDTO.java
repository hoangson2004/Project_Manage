package com.aps.projectmanage.domain.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskCommentDTO {
    private int id;
    private int taskId;
    private int userId;
    private String content;
    private LocalDateTime createdAt;
}
