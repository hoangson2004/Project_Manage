package com.aps.projectmanage.service.impl;

import com.aps.projectmanage.domain.constant.TaskStatus;
import com.aps.projectmanage.domain.dto.TaskDTO;
import com.aps.projectmanage.domain.entity.Task;
import com.aps.projectmanage.domain.repository.ProjectRepository;
import com.aps.projectmanage.domain.repository.TaskRepository;
import com.aps.projectmanage.payload.CreateTaskPayload;
import com.aps.projectmanage.payload.UpdateTaskPayload;
import com.aps.projectmanage.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    @Override
    public TaskDTO createTask(CreateTaskPayload createTaskPayload, int projectId) {
        Task task = modelMapper.map(createTaskPayload, Task.class);
        task.setProject(projectRepository.getById(projectId));
        task.setStatus(TaskStatus.TODO);
        Task savedTask = taskRepository.save(task);
        return modelMapper.map(savedTask, TaskDTO.class);

    }

    @Override
    public TaskDTO getTaskById(int id) {
        Task task = taskRepository.getById(id);
        TaskDTO taskDTO = new TaskDTO();
        modelMapper.map(task, taskDTO);
        return taskDTO;
    }

    @Override
    public List<TaskDTO> getAllTasksByProjectId(int projectId) {
        List<Task> tasks = taskRepository.findByProject_Id(projectId);

        return tasks.stream()
                .map(task -> modelMapper.map(task, TaskDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public TaskDTO updateTask(int id, UpdateTaskPayload updateTaskPayload) {
        Task task = taskRepository.getById(id);
        task.setStatus(TaskStatus.valueOf(updateTaskPayload.getStatus()));
        taskRepository.save(task);
        TaskDTO taskDTO = new TaskDTO();
        modelMapper.map(task, taskDTO);
        return taskDTO;
    }

    @Override
    public int deleteTask(int id) {
        Task task = taskRepository.getById(id);
        task.setIsActive(false);
        taskRepository.save(task);
        return task.getId();
    }
}
