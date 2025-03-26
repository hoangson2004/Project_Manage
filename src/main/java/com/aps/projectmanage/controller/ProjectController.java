package com.aps.projectmanage.controller;

import com.aps.projectmanage.domain.constant.StatusCode;
import com.aps.projectmanage.payload.ProjectPayload;
import com.aps.projectmanage.service.ProjectMemberService;
import com.aps.projectmanage.service.ProjectService;
import com.aps.projectmanage.util.HasProjectPermission;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController extends BaseController {

    private final ProjectService projectService;
    private final ProjectMemberService projectMemberService;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getAllProjects() {
        return handleSuccess("Get all projects", projectService.getAllProjects());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getProjectsByUserId(@PathVariable int id) {
        return handleSuccess("Get all project by user id: " + id + " success",
                projectMemberService.getAllProjectsByUserId(id));
    }

    @GetMapping("/{id}")
    @HasProjectPermission("VIEW_PROJECT")
    public ResponseEntity<?> getProjectById(@PathVariable int id) {
        return handleSuccess("Get project by project id: " + id + " success",
                projectService.getProjectById(id));
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> createProject(@Valid @RequestBody ProjectPayload payload) {
        return handleSuccess(StatusCode.CREATED, "Create project success",
                projectService.createProject(payload));
    }

    @PutMapping("/{id}")
    @HasProjectPermission("EDIT_PROJECT")
    public ResponseEntity<?> updateProject(@PathVariable int id, @Valid @RequestBody ProjectPayload payload) {
        return handleSuccess("Update project success",
                projectService.updateProject(id, payload));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteProject(@PathVariable int id) {
        return handleSuccess("Delete project success", projectService.deleteProject(id));
    }
}