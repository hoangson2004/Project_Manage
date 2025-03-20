package com.aps.projectmanage.payload;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserPayload{
    private String username;
    private String email;
    private String fullName;
    private String password;
}