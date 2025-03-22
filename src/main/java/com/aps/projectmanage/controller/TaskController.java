package com.aps.projectmanage.controller;

import com.aps.projectmanage.domain.dto.TaskDTO;
import com.aps.projectmanage.payload.CreateTaskPayload;
import com.aps.projectmanage.payload.UpdateTaskPayload;
import com.aps.projectmanage.response.BaseResponse;
import com.aps.projectmanage.response.TaskResponse;
import com.aps.projectmanage.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;
    private TaskResponse taskResponse = new TaskResponse();

    @GetMapping
    public ResponseEntity<BaseResponse<List<TaskDTO>>> getAllTaskByProjectId(@RequestParam int projectId) {
        BaseResponse<List<TaskDTO>> response = new BaseResponse<>();
        response = taskResponse.getAllTasks(taskService.getAllTasksByProjectId(projectId));
        return ResponseEntity.ok(response);
    }


    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> getTaskById(@PathVariable int id) {
        TaskDTO taskDTO = taskService.getTaskById(id);
        taskResponse = taskResponse.getTask(taskDTO);
        return ResponseEntity.ok(taskResponse);
    }

    @PostMapping
    public ResponseEntity<TaskResponse> createTask(@RequestParam int projectId,@RequestBody CreateTaskPayload payload) {
        taskResponse = taskResponse.createTask(
                taskService.createTask(payload, projectId));
        return ResponseEntity.ok(taskResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponse> updateTask(@RequestBody UpdateTaskPayload updateTaskPayload, @PathVariable int id) {
        TaskDTO updatedTask = taskService.updateTask(id, updateTaskPayload);
        taskResponse = taskResponse.updateTask(updatedTask);
        return ResponseEntity.ok(taskResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TaskResponse> deleteTask(@PathVariable int id) {
        taskResponse = taskResponse.deleteTask(taskService.deleteTask(id));
        return ResponseEntity.ok(taskResponse);
    }

}
