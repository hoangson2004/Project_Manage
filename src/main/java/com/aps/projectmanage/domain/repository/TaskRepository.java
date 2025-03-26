package com.aps.projectmanage.domain.repository;

import org.springframework.data.repository.query.Param;
import com.aps.projectmanage.domain.entity.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends BaseRepository<Task, Integer> {
    List<Task> findByProject_Id(int projectId);

    @Query("SELECT t.project.id FROM Task t WHERE t.id = :taskId")
    Integer findProjectIdByTaskId(@Param("taskId") int taskId);
}
