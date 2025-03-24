package com.aps.projectmanage.payload;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Valid
@Data
public class CreateUserPayload{
    @NotBlank
    private String username;
    @NotBlank
    private String email;
    @NotBlank
    private String fullName;
    @NotBlank
    private String password;
}