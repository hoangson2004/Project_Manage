package com.aps.projectmanage.domain.entity;

import com.aps.projectmanage.domain.constant.RoleName;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class Role extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_value", nullable = false, unique = true)
    private int roleValue = RoleName.USER.getValue();

}

