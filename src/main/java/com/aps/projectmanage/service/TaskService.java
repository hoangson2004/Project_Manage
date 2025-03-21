package com.aps.projectmanage.service;

import com.aps.projectmanage.domain.dto.TaskDTO;

public interface TaskService {
    TaskDTO createTask(TaskDTO taskDTO);
    TaskDTO getTaskById(int id);
    TaskDTO getAllTasksByProjectId(int projectId);
    TaskDTO updateTask(TaskDTO taskDTO);
    int deleteTask(int id);
}
