package com.aps.projectmanage.service;

import com.aps.projectmanage.domain.dto.TaskDTO;
import com.aps.projectmanage.payload.CreateTaskPayload;
import com.aps.projectmanage.payload.UpdateTaskPayload;

import java.util.List;

public interface TaskService {
    TaskDTO createTask(CreateTaskPayload payload, int projectId);
    TaskDTO getTaskById(int id);
    List<TaskDTO> getAllTasksByProjectId(int projectId);
    TaskDTO updateTask(int id, UpdateTaskPayload updateTaskPayload);
    int deleteTask(int id);
}
