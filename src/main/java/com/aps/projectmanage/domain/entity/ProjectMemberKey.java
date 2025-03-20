package com.aps.projectmanage.domain.entity;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class ProjectMemberKey implements Serializable {

    private int projectId;
    private int userId;
}
