package com.aps.projectmanage.controller;

import com.aps.projectmanage.payload.PermissionPayload;
import com.aps.projectmanage.service.PermissionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/permissions")
@RequiredArgsConstructor
public class PermissionController extends BaseController {

    private final PermissionService permissionService;

    @GetMapping
    public ResponseEntity<?> getAllPermissions() {
        return handleSuccess("Get all permissions success", permissionService.getAllPermissions());
    }

    @GetMapping("/{roleLabel}")
    public ResponseEntity<?> getPermissionsByRole(@PathVariable String roleLabel) {
        return handleSuccess("Get all permissions success", permissionService.getPermissionsByRole(roleLabel));
    }

    @PutMapping("/{roleLabel}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updatePermissionsForRole(
            @PathVariable String roleLabel,
            @Valid @RequestBody PermissionPayload payload) {

        return handleSuccess("Update Permissions success", permissionService.updatePermissionsByRoleId(
                roleLabel, payload.getPermissionIds()));
    }
}