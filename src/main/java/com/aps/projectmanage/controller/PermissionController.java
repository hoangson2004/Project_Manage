package com.aps.projectmanage.controller;

import com.aps.projectmanage.domain.dto.PermissionDTO;
import com.aps.projectmanage.payload.PermissionPayload;
import com.aps.projectmanage.response.BaseResponse;
import com.aps.projectmanage.response.PermissionResponse;
import com.aps.projectmanage.service.PermissionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/permissions")
@RequiredArgsConstructor
public class PermissionController {

    private final PermissionService permissionService;
    private PermissionResponse permissionResponse = new PermissionResponse();

    @GetMapping
    public ResponseEntity<BaseResponse<List<PermissionDTO>>> getAllPermissions() {
        BaseResponse<List<PermissionDTO>> response;
        response = permissionResponse.getAllPermissions(permissionService.getAllPermissions());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{roleLabel}")
    public ResponseEntity<BaseResponse<List<PermissionDTO>>> getPermissionsByRole(@PathVariable String roleLabel) {
        BaseResponse<List<PermissionDTO>> response;
        response = permissionResponse.getPermissionsByRole(permissionService.getPermissionsByRole(roleLabel));
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{roleLabel}")
    public ResponseEntity<PermissionResponse> updatePermissionsForRole(
            @PathVariable String roleLabel,
            @Valid @RequestBody PermissionPayload payload) {

        List<PermissionDTO> updatedPermissions = permissionService.updatePermissionsByRoleId(
                roleLabel, payload.getPermissionIds());
        PermissionResponse response = permissionResponse.updatePermissions(updatedPermissions);
        return ResponseEntity.ok(response);
    }
}