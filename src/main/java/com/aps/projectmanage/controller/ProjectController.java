package com.aps.projectmanage.controller;

import com.aps.projectmanage.domain.dto.ProjectDTO;
import com.aps.projectmanage.exception.NotFoundException;
import com.aps.projectmanage.payload.ProjectPayload;
import com.aps.projectmanage.response.BaseResponse;
import com.aps.projectmanage.response.ProjectResponse;
import com.aps.projectmanage.service.ProjectMemberService;
import com.aps.projectmanage.service.ProjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;
    private final ProjectMemberService projectMemberService;
    private ProjectResponse projectResponse = new ProjectResponse();

    @GetMapping
    public ResponseEntity<BaseResponse<List<ProjectDTO>>> getAllProjects() {
        BaseResponse<List<ProjectDTO>> response = new BaseResponse<>();
        response = projectResponse.getAllProjects(projectService.getAllProjects());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<BaseResponse<List<ProjectDTO>>> getProjectsByUserId(@PathVariable int id) {
        BaseResponse<List<ProjectDTO>> response = new BaseResponse<>();
        response = projectResponse.getAllProjects(projectMemberService.getAllProjectsByUserId(id));
        return ResponseEntity.ok(response);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponse> getProjectById(@PathVariable int id) {
        projectResponse = projectResponse.getProject(
                projectService.getProjectById(id));
        return ResponseEntity.ok(projectResponse);
    }

    @PostMapping
    public ResponseEntity<ProjectResponse> createProject(@Valid @RequestBody ProjectPayload payload) {
        projectResponse = projectResponse.createProject(projectService.createProject(payload));
        return ResponseEntity.ok(projectResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectResponse> updateProject(@PathVariable int id, @Valid @RequestBody ProjectPayload payload) {
        projectResponse = projectResponse.updateProject(
                projectService.updateProject(id,payload));
        return ResponseEntity.ok(projectResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProjectResponse> deleteProject(@PathVariable int id) {
        if (projectService.getProjectById(id)==null) {
            throw new NotFoundException();
        }
        projectResponse = projectResponse.deleteProject(projectService.deleteProject(id));
        return ResponseEntity.ok(projectResponse);
    }
}