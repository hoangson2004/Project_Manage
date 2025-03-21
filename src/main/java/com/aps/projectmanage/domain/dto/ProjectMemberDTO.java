package com.aps.projectmanage.domain.dto;

import com.aps.projectmanage.domain.entity.Project;
import com.aps.projectmanage.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectMemberDTO {
    private String project;
    private String user;
    private LocalDateTime createdAt;
    private String role;
}
