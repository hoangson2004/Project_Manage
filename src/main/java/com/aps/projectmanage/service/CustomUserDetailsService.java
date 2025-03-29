package com.aps.projectmanage.service;

import com.aps.projectmanage.domain.constant.RoleName;
import com.aps.projectmanage.domain.dto.UserCacheData;
import com.aps.projectmanage.domain.entity.ProjectMember;
import com.aps.projectmanage.domain.entity.Role;
import com.aps.projectmanage.domain.entity.User;
import com.aps.projectmanage.domain.repository.ProjectMemberRepository;
import com.aps.projectmanage.domain.repository.RolePermissionRepository;
import com.aps.projectmanage.domain.repository.UserRepository;
import com.aps.projectmanage.util.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final ProjectMemberRepository projectMemberRepository;
    private final RolePermissionRepository rolePermissionRepository;
    private final RedisService redisService;

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        String userId = String.valueOf(user.getId());

        UserCacheData cachedData = redisService.getUserData(userId);
        if (cachedData != null) {
            return new CustomUserDetails(user,
                    cachedData.getRoles().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toSet()),
                    cachedData.getProjectPermissions());
        }

        Set<GrantedAuthority> authorities =  Collections.singleton(
                new SimpleGrantedAuthority("ROLE_" + RoleName.fromValue(user.getRole().getRoleValue()))
        );

        List<ProjectMember> projectMembers = projectMemberRepository.findProjectMembersByIdUserId(user.getId());

        Map<Integer, List<String>> projectPermissions = new HashMap<>();

        for (ProjectMember projectMember : projectMembers) {
            Integer projectId = projectMember.getProject().getId();
            Role roleProject = projectMember.getRole();

            List<String> permissions = rolePermissionRepository.findByRoleId(roleProject.getId())
                    .stream()
                    .map(rp -> rp.getPermission().getName())
                    .collect(Collectors.toList());

            projectPermissions.put(projectId, permissions);
        }

        CustomUserDetails userDetails = new CustomUserDetails(user, authorities, projectPermissions);

        redisService.saveUserData(userId, projectPermissions,
                authorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()));

        return userDetails;
    }

    public void evictUserCache(String userId) {
        redisService.evictUserCache(userId);
    }
}
