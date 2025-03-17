package com.aps.projectmanage.domain.repository;

import com.aps.projectmanage.domain.entity.Project;
import com.aps.projectmanage.domain.entity.ProjectMember;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends BaseRepository<Project, Long>{
}
