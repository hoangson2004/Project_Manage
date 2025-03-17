package com.aps.projectmanage.service.impl;

import com.aps.projectmanage.domain.entity.Task;
import com.aps.projectmanage.domain.repository.TaskRepository;
import com.aps.projectmanage.service.TaskService;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl extends BaseServiceImpl <Task, Long> implements TaskService {
    public TaskServiceImpl(TaskRepository taskRepository) {
        super(taskRepository);
    }
}
