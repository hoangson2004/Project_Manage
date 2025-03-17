package com.aps.projectmanage.domain.repository;

import com.aps.projectmanage.domain.entity.Task;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends BaseRepository<Task, Long> {
}
