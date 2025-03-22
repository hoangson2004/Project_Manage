package com.aps.projectmanage.response;

import com.aps.projectmanage.domain.constant.StatusCode;
import com.aps.projectmanage.domain.dto.TaskDTO;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class TaskResponse extends BaseResponse<TaskDTO> {
    public TaskResponse(String status, String message, TaskDTO data) {
        super(status, message, data);
    }

    public TaskResponse createTask(TaskDTO data) {
        return new TaskResponse(
                StatusCode.SUCCESS.getStatusCode(),
                "Added task successfully",
                data);
    }

    public TaskResponse updateTask(TaskDTO data) {
        return new TaskResponse(
                StatusCode.SUCCESS.getStatusCode(),
                "Updated task successfully",
                data);
    }

    public BaseResponse<List<TaskDTO>> getAllTasks(List<TaskDTO> tasks) {
        return new BaseResponse<>(
                StatusCode.SUCCESS.getStatusCode(),
                "Fetched all tasks successfully",
                tasks
        );
    }

    public BaseResponse<List<TaskDTO>> getTasksByProject(List<TaskDTO> tasks, int projectId) {
        return new BaseResponse<>(
                StatusCode.SUCCESS.getStatusCode(),
                "Fetched all tasks for project ID " + projectId + " successfully",
                tasks
        );
    }

    public TaskResponse getTask(TaskDTO data) {
        return new TaskResponse(
                StatusCode.SUCCESS.getStatusCode(),
                "Fetched task successfully",
                data);
    }

    public TaskResponse deleteTask(int taskId) {

        return new TaskResponse(
                StatusCode.SUCCESS.getStatusCode(),
                "Deleted task with ID " + taskId + " successfully",
                null);
    }
}