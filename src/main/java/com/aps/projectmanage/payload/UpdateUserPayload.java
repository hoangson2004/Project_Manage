package com.aps.projectmanage.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserPayload {

    @NotBlank(message = "Email cannot be blank")
    private String email;

    @NotBlank(message = "Full name cannot be blank")
    private String fullName;

    @NotBlank
    @Size(min=8, message = "Password have to at least 8 characters")
    private String password;
}