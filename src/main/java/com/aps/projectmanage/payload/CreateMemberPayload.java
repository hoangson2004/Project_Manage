package com.aps.projectmanage.payload;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Valid
@Data
public class CreateMemberPayload {
    @NotNull
    private int userId;

    @NotNull
    private String role;
}
