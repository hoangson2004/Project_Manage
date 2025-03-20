package com.aps.projectmanage.domain.entity;

import com.aps.projectmanage.domain.constant.RoleName;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false, length = 50)
    private String username;

    @Column(unique = true, nullable = false, length = 100)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, length = 100)
    private String fullName;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = true)
    private Role role;

}
