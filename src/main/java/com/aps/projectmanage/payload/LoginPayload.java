package com.aps.projectmanage.payload;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Valid
@Data
public class LoginPayload {
    @NotNull
    private String username;
    @NotNull
    private String password;
}
