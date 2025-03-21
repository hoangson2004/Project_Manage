package com.aps.projectmanage.response;

import com.aps.projectmanage.domain.constant.StatusCode;
import com.aps.projectmanage.domain.dto.ProjectDTO;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class ProjectResponse extends BaseResponse<ProjectDTO> {
    public ProjectResponse(String status, String message, ProjectDTO data) {
        super(status, message, data);
    }

    public ProjectResponse createProject(ProjectDTO data) {
        return new ProjectResponse(
                StatusCode.SUCCESS.getStatusCode(),
                "Added project successfully",
                data);
    }

    public ProjectResponse updateProject(ProjectDTO data) {
        return new ProjectResponse(
                StatusCode.SUCCESS.getStatusCode(),
                "Updated project successfully",
                data);
    }

    public BaseResponse<List<ProjectDTO>> getAllProjects(List<ProjectDTO> projects) {
        return new BaseResponse<>(
                StatusCode.SUCCESS.getStatusCode(),
                "Fetched all projects successfully",
                projects
        );
    }

    public ProjectResponse getProject(ProjectDTO data) {
        return new ProjectResponse(
                StatusCode.SUCCESS.getStatusCode(),
                "Fetched project successfully",
                data);
    }

    public ProjectResponse deleteProject(int projectId) {
        return new ProjectResponse(
                StatusCode.SUCCESS.getStatusCode(),
                "Deleted project with ID " + projectId + " successfully",
                null);
    }
}