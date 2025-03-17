package com.aps.projectmanage.domain.repository;

import com.aps.projectmanage.domain.entity.ProjectMember;
import com.aps.projectmanage.domain.entity.ProjectMemberKey;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectMemberRepository extends BaseRepository<ProjectMember, ProjectMemberKey> {
}
