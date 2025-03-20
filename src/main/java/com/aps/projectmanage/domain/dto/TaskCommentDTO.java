package com.aps.projectmanage.domain.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskCommentDTO {
    private Long id;
    private Long taskId;
    private Long userId;
    private String content;
    private LocalDateTime createdAt;
}
