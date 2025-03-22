package com.aps.projectmanage.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;


@Getter
@Setter
@Entity
@Table(name = "task_assignees")
@SQLDelete(sql = "UPDATE users SET is_active=false WHERE id = ?")
@Where(clause = "is_active != false")
public class TaskAssignee extends BaseEntity{

    @EmbeddedId
    private TaskAssigneeKey id;

    @ManyToOne
    @MapsId("taskId")
    @JoinColumn(name = "task_id")
    private Task task;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;
}
