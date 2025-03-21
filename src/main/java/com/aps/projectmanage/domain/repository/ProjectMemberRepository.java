package com.aps.projectmanage.domain.repository;

import com.aps.projectmanage.domain.entity.ProjectMember;
import com.aps.projectmanage.domain.entity.ProjectMemberKey;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectMemberRepository extends BaseRepository<ProjectMember, ProjectMemberKey> {
    List<ProjectMember> findProjectMembersByIdUserId(int userId);
    List<ProjectMember> findProjectMembersByIdProjectId(int projectId);
}
