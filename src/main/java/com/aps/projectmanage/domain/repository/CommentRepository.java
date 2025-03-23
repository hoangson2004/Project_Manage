package com.aps.projectmanage.domain.repository;

import com.aps.projectmanage.domain.entity.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends BaseRepository<Comment, Integer> {
    List<Comment> findByTaskIdOrderByCreatedAtDesc(int taskId);
}
