package com.aps.projectmanage.response;

import com.aps.projectmanage.domain.constant.StatusCode;
import com.aps.projectmanage.domain.dto.PermissionDTO;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class PermissionResponse extends BaseResponse<PermissionDTO> {

    public PermissionResponse(String status, String message, PermissionDTO data) {
        super(status, message, data);
    }

    public BaseResponse<List<PermissionDTO>> getAllPermissions(List<PermissionDTO> permissions) {
        return new BaseResponse<>(
                StatusCode.SUCCESS.getStatusCode(),
                "Fetched all permissions successfully",
                permissions
        );
    }

    public BaseResponse<List<PermissionDTO>> getPermissionsByRole(List<PermissionDTO> permissions) {
        return new BaseResponse<>(
                StatusCode.SUCCESS.getStatusCode(),
                "Fetched permissions by role successfully",
                permissions
        );
    }

    public PermissionResponse updatePermissions(List<PermissionDTO> permissions) {
        return new PermissionResponse(
                StatusCode.SUCCESS.getStatusCode(),
                "Updated permissions successfully",
                null);
    }

}