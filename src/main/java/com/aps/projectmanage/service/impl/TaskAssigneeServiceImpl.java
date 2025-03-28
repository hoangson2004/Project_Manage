package com.aps.projectmanage.service.impl;

import com.aps.projectmanage.domain.dto.UserDTO;
import com.aps.projectmanage.domain.entity.*;
import com.aps.projectmanage.domain.repository.ProjectMemberRepository;
import com.aps.projectmanage.domain.repository.TaskAssigneeRepository;
import com.aps.projectmanage.domain.repository.TaskRepository;
import com.aps.projectmanage.domain.repository.UserRepository;
import com.aps.projectmanage.exception.NotFoundException;
import com.aps.projectmanage.payload.AssignTaskPayload;
import com.aps.projectmanage.service.TaskAssigneeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskAssigneeServiceImpl implements TaskAssigneeService {
    private final TaskAssigneeRepository taskAssigneeRepository;
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final ProjectMemberRepository projectMemberRepository;

    @Override
    public List<Integer> assignTask(int taskId, AssignTaskPayload payload) {
        Task task = taskRepository.getById(taskId);
        Project project = task.getProject();
        int projectId = project.getId();

        List<Integer> userIds = payload.getUserId();
        List<TaskAssignee> taskAssignees = new ArrayList<>();

        List<Integer> projectMemberIds = projectMemberRepository.findProjectMembersByIdProjectId(projectId)
                .stream()
                .map(pm -> pm.getUser().getId())
                .collect(Collectors.toList());

        for (Integer userId : userIds) {
            User user = userRepository.getById(userId);
            if (!projectMemberIds.contains(user.getId())) {
                throw new NotFoundException("User with id " + userId + " not belong to project with id " + projectId);
            }

            TaskAssigneeKey key = new TaskAssigneeKey(taskId, userId);
            TaskAssignee taskAssignee = new TaskAssignee(key,task,user);
            taskAssignees.add(taskAssignee);
        }

        taskAssigneeRepository.saveAll(taskAssignees);
        return userIds;
    }
}
