package com.aps.projectmanage.util;

import com.aps.projectmanage.domain.repository.TaskRepository;
import com.aps.projectmanage.service.RedisService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Aspect
@Component
@RequiredArgsConstructor
public class TaskPermissionAspect {
    private final RedisService redisService;
    private final TaskRepository taskRepository;

    @Around("@annotation(hasTaskPermission) && args(taskId,..)")
    public Object checkTaskPermission(ProceedingJoinPoint joinPoint, HasTaskPermission hasTaskPermission, Integer taskId) throws Throwable {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

        Integer projectId = taskRepository.findProjectIdByTaskId(taskId);
        if (projectId == null) {
            throw new AccessDeniedException("Cannot determine projectId from taskId");
        }
        String userId = userDetails.getUserId()+"";

        Map<Integer, List<String>> projectPermissions = redisService.getUserData(userId).getProjectPermissions();
        if (!projectPermissions.containsKey(projectId) ||
                !projectPermissions.get(projectId).contains(hasTaskPermission.value())) {
            throw new AccessDeniedException("Access Denied: " + hasTaskPermission.value());
        }

        return joinPoint.proceed();
    }
}
