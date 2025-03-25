package com.aps.projectmanage.controller;

import com.aps.projectmanage.domain.constant.StatusCode;
import com.aps.projectmanage.payload.CreateTaskPayload;
import com.aps.projectmanage.payload.UpdateTaskPayload;
import com.aps.projectmanage.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController extends BaseController {
    private final TaskService taskService;

    @GetMapping
    public ResponseEntity<?> getAllTaskByProjectId(@RequestParam int projectId) {
        return handleSuccess("Get all task by project id: " + projectId + "success",
                taskService.getAllTasksByProjectId(projectId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTaskById(@PathVariable int id) {
        return handleSuccess("Get task by id success", taskService.getTaskById(id));
    }

    @PostMapping
    public ResponseEntity<?> createTask(@RequestParam int projectId,@RequestBody CreateTaskPayload payload) {
        return handleSuccess(StatusCode.CREATED, "Create task success",
                taskService.createTask(payload, projectId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTask(@RequestBody UpdateTaskPayload updateTaskPayload, @PathVariable int id) {
        return handleSuccess("Update task success", taskService.updateTask(id, updateTaskPayload));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable int id) {
        return handleSuccess("Delete task success", taskService.deleteTask(id));
    }

}
