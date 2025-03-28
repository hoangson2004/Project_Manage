package com.aps.projectmanage.controller;

import com.aps.projectmanage.domain.constant.StatusCode;
import com.aps.projectmanage.payload.AssignTaskPayload;
import com.aps.projectmanage.payload.CreateTaskPayload;
import com.aps.projectmanage.payload.UpdateTaskPayload;
import com.aps.projectmanage.service.TaskAssigneeService;
import com.aps.projectmanage.service.TaskService;
import com.aps.projectmanage.util.HasProjectPermission;
import com.aps.projectmanage.util.HasTaskPermission;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController extends BaseController {
    private final TaskService taskService;
    private final TaskAssigneeService taskAssigneeService;

    @GetMapping
    @HasProjectPermission("VIEW_PROJECT")
    public ResponseEntity<?> getAllTaskByProjectId(@RequestParam int projectId) {
        return handleSuccess("Get all task by project id: " + projectId + "success",
                taskService.getAllTasksByProjectId(projectId));
    }

    @GetMapping("/{taskId}")
    @HasTaskPermission("VIEW_PROJECT")
    public ResponseEntity<?> getTaskById(@PathVariable int taskId) {
        return handleSuccess("Get task by id success", taskService.getTaskById(taskId));
    }

    @PostMapping
    @HasProjectPermission("CREATE_TASK")
    public ResponseEntity<?> createTask(@RequestParam int projectId,@RequestBody CreateTaskPayload payload) {
        return handleSuccess(StatusCode.CREATED, "Create task success",
                taskService.createTask(payload, projectId));
    }

    @PutMapping("/{taskId}")
    @HasTaskPermission("EDIT_TASK")
    public ResponseEntity<?> updateTask(@RequestBody UpdateTaskPayload payload, @PathVariable int taskId) {
        return handleSuccess("Update task success", taskService.updateTask(taskId, payload));
    }

    @PostMapping("/{taskId}")
    @HasTaskPermission("ASSIGN_TASK")
    public ResponseEntity<?> assignTask(@PathVariable int taskId,@Valid @RequestBody AssignTaskPayload payload) {
        return handleSuccess("Assign task success", taskAssigneeService.assignTask(taskId, payload));
    }

    @DeleteMapping("/{taskId}")
    @HasTaskPermission("DELETE_TASK")
    public ResponseEntity<?> deleteTask(@PathVariable int taskId) {
        return handleSuccess("Delete task success", taskService.deleteTask(taskId));
    }
}
