package com.aps.projectmanage.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLInsert;
import org.hibernate.annotations.Where;

@Getter
@Setter
@Entity
@Table(name = "project_members")
@SQLDelete(sql = "UPDATE project_members SET is_active=false WHERE user_id = ? AND project_id=?")
@Where(clause = "is_active != false")
public class ProjectMember extends BaseEntity{

    @EmbeddedId
    private ProjectMemberKey id;

    @ManyToOne
    @MapsId("projectId")
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;
}
