package com.aps.projectmanage.domain.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {
    private int id;
    private String name;
    private String description;
    private LocalDateTime createdAt;
    private String createdBy;
}
