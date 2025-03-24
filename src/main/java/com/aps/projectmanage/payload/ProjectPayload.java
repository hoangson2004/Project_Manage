package com.aps.projectmanage.payload;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Valid
@Data
public class ProjectPayload {
    @NotBlank(message = "Project name cannot be blank")
    @Size(max = 100, message = "Project name cannot exceed 100 characters")
    private String name;

    private String description;
}