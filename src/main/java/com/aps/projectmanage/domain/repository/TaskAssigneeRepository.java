package com.aps.projectmanage.domain.repository;

import com.aps.projectmanage.domain.entity.TaskAssignee;
import com.aps.projectmanage.domain.entity.TaskAssigneeKey;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskAssigneeRepository extends BaseRepository<TaskAssignee, TaskAssigneeKey> {
}
