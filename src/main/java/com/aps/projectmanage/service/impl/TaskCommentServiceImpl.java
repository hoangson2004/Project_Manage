package com.aps.projectmanage.service.impl;

import com.aps.projectmanage.domain.entity.TaskComment;
import com.aps.projectmanage.domain.repository.TaskCommentRepository;
import com.aps.projectmanage.service.TaskCommentService;
import org.springframework.stereotype.Service;

@Service
public class TaskCommentServiceImpl extends BaseServiceImpl<TaskComment, Long> implements TaskCommentService {
    public TaskCommentServiceImpl(TaskCommentRepository taskCommentRepository) {
        super(taskCommentRepository);
    }
}
