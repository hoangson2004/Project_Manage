package com.aps.projectmanage.payload;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;

@Valid
@Data
public class PermissionPayload {
    @NotNull(message = "Permission ids are required")
    private List<Integer> permissionIds;
}