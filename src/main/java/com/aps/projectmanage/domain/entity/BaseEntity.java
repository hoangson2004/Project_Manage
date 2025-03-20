package com.aps.projectmanage.domain.entity;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity {
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column
    private LocalDateTime updatedAt;

    @Column(updatable = false)
    private String createdBy;

    @Column
    private String updatedBy;

    @Column
    private Boolean IsActive = true;

    @PrePersist
    public void prePersist() {
        String currentUser = getCurrentUser();
        this.createdBy = currentUser;
        this.updatedBy = currentUser;
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedBy = getCurrentUser();
    }

    private String getCurrentUser() {
        try {
            return SecurityContextHolder.getContext().getAuthentication().getName();
        } catch (Exception e) {
            return "system";
        }
    }
}