package com.aps.projectmanage.payload;

import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Valid
@Data
public class CreateTaskPayload {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @Nullable
    private String status;

}
