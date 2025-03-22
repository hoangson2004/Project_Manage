package com.aps.projectmanage.payload;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateTaskPayload {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @Nullable
    private String status;

}
