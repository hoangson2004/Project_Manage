package com.aps.projectmanage.service;

import com.aps.projectmanage.domain.dto.UserDTO;
import com.aps.projectmanage.payload.AssignTaskPayload;

import java.util.List;

public interface TaskAssigneeService {
    List<Integer> assignTask(int taskId, AssignTaskPayload payload);
}
