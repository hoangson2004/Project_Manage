package com.aps.projectmanage.domain.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {
    private int id;
    private String content;
    private LocalDateTime createdAt;
}
