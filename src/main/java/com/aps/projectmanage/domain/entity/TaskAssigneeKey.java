package com.aps.projectmanage.domain.entity;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class TaskAssigneeKey implements Serializable {

    private int taskId;
    private int userId;
}
