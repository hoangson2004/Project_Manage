package com.aps.projectmanage.service;

import com.aps.projectmanage.domain.dto.ProjectDTO;
import com.aps.projectmanage.payload.ProjectPayload;

import java.util.List;

public interface ProjectService {
    List<ProjectDTO> getAllProjects();
    ProjectDTO getProjectById(int id);
    ProjectDTO createProject(ProjectPayload payload);
    ProjectDTO updateProject(int id, ProjectPayload payload);
    int deleteProject(int id);
}