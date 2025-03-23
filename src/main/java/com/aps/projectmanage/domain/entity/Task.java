package com.aps.projectmanage.domain.entity;

import com.aps.projectmanage.domain.constant.TaskStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tasks")
@SQLDelete(sql = "UPDATE users SET is_active=false WHERE id = ?")
@Where(clause = "is_active != false")
public class Task extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TaskAssignee> assignees = new ArrayList<>();


    @Column(name = "status", nullable = false)
    private TaskStatus status = TaskStatus.TODO;

}
