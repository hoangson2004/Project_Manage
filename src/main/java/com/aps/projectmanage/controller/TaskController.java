package com.aps.projectmanage.controller;

import com.aps.projectmanage.domain.constant.StatusCode;
import com.aps.projectmanage.payload.CreateTaskPayload;
import com.aps.projectmanage.payload.UpdateTaskPayload;
import com.aps.projectmanage.service.TaskService;
import com.aps.projectmanage.util.HasProjectPermission;
import com.aps.projectmanage.util.HasTaskPermission;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController extends BaseController {
    private final TaskService taskService;

    @GetMapping
    @HasProjectPermission("VIEW_PROJECT")
    public ResponseEntity<?> getAllTaskByProjectId(@RequestParam int projectId) {
        return handleSuccess("Get all task by project id: " + projectId + "success",
                taskService.getAllTasksByProjectId(projectId));
    }

    @GetMapping("/{id}")
    @HasTaskPermission("VIEW_PROJECT")
    public ResponseEntity<?> getTaskById(@PathVariable int id) {
        return handleSuccess("Get task by id success", taskService.getTaskById(id));
    }

    @PostMapping
    @HasTaskPermission("EDIT_PROJECT")
    public ResponseEntity<?> createTask(@RequestParam int projectId,@RequestBody CreateTaskPayload payload) {
        return handleSuccess(StatusCode.CREATED, "Create task success",
                taskService.createTask(payload, projectId));
    }

    @PutMapping("/{id}")
    @HasTaskPermission("EDIT_PROJECT")
    public ResponseEntity<?> updateTask(@RequestBody UpdateTaskPayload updateTaskPayload, @PathVariable int id) {
        return handleSuccess("Update task success", taskService.updateTask(id, updateTaskPayload));
    }

    @DeleteMapping("/{id}")
    @HasTaskPermission("EDIT_PROJECT")
    public ResponseEntity<?> deleteTask(@PathVariable int id) {
        return handleSuccess("Delete task success", taskService.deleteTask(id));
    }

}
