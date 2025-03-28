package com.aps.projectmanage.controller;

import com.aps.projectmanage.payload.CreateMemberPayload;
import com.aps.projectmanage.payload.UpdateMemberPayload;
import com.aps.projectmanage.service.ProjectMemberService;
import com.aps.projectmanage.util.HasProjectPermission;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class ProjectMemberController extends BaseController {

    private final ProjectMemberService projectMemberService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> addUserToProject(
            @RequestParam int projectId,
            @Valid @RequestBody CreateMemberPayload payload) {

        return handleSuccess("Add user success",
                projectMemberService.addUserToProject(projectId, payload));
    }

    @PutMapping
    @HasProjectPermission("EDIT_PROJECT")
    public ResponseEntity<?> updateMember(
            @RequestParam int projectId,
            @Valid @RequestBody UpdateMemberPayload payload ) {
        return handleSuccess("Update member success", projectMemberService.updateMemberRole(projectId,payload));
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