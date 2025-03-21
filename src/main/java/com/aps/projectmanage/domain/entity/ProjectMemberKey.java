package com.aps.projectmanage.domain.entity;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
@Setter
@Getter
public class ProjectMemberKey implements Serializable {

    private int projectId;
    private int userId;
}
