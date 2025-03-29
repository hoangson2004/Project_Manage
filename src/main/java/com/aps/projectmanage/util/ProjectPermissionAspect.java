package com.aps.projectmanage.util;

import com.aps.projectmanage.service.RedisService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Aspect
@RequiredArgsConstructor
public class ProjectPermissionAspect {
    private final RedisService redisService;

    @Around("@annotation(hasProjectPermission) && args(projectId,..)")
    public Object checkPermission(ProceedingJoinPoint joinPoint, HasProjectPermission hasProjectPermission, Integer projectId) throws Throwable {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

        String userId = userDetails.getUserId()+"";

        Map<Integer, List<String>> projectPermissions = redisService.getUserData(userId).getProjectPermissions();

        if (!projectPermissions.containsKey(projectId) ||
                !projectPermissions.get(projectId).contains(hasProjectPermission.value())) {
            throw new AccessDeniedException("Access Denied: " + hasProjectPermission.value());
        }

        return joinPoint.proceed();
    }
}

