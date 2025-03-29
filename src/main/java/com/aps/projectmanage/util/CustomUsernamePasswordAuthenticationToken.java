package com.aps.projectmanage.util;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class CustomUsernamePasswordAuthenticationToken extends UsernamePasswordAuthenticationToken {
    @Getter
    private final Map<Integer, List<String>> projectPermissions;

    @Getter
    private final int userId;

    public CustomUsernamePasswordAuthenticationToken(
            Object principal,
            Object credentials,
            Collection<? extends GrantedAuthority> authorities,
            Map<Integer, List<String>> projectPermissions,
            int userId) {
        super(principal, credentials, authorities);
        this.projectPermissions = projectPermissions;
        this.userId = userId;
    }

}
