package com.aps.projectmanage.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserPayload {
    private String email;
    private String fullName;
    private String password;
}