package com.aps.projectmanage.util;

import com.aps.projectmanage.domain.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.*;

@Setter
public class CustomUserDetails extends org.springframework.security.core.userdetails.User {
    @Getter
    private final Map<Integer, List<String>> projectPermissions;

    public CustomUserDetails(User user, Set<GrantedAuthority> authorities, Map<Integer, List<String>> projectPermissions) {
        super(user.getUsername(), user.getPassword(), authorities);
        this.projectPermissions = projectPermissions;
    }

}
