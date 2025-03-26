package com.aps.projectmanage.controller;

import com.aps.projectmanage.payload.CreateMemberPayload;
import com.aps.projectmanage.service.ProjectMemberService;
import com.aps.projectmanage.util.HasProjectPermission;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class ProjectMemberController extends BaseController {

    private final ProjectMemberService projectMemberService;

    @PostMapping("/project/{projectId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> addUserToProject(
            @PathVariable int projectId,
            @RequestBody CreateMemberPayload payload) {

        return handleSuccess("Add user success",
                projectMemberService.addUserToProject(projectId, payload));
    }


    @DeleteMapping
    @HasProjectPermission("MANAGE_MEMBER")
    public ResponseEntity<?> removeUserFromProject(
            @RequestParam int projectId,
            @RequestParam int userId) {

        return handleSuccess("Delete user id: " + userId + " from project id: " + projectId + " success",
                projectMemberService.deleteMemberFromProject(projectId, userId));
    }

}