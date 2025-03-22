package com.aps.projectmanage.domain.repository;

import com.aps.projectmanage.domain.entity.Task;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends BaseRepository<Task, Integer> {
    List<Task> findByProject_Id(int projectId);
}
