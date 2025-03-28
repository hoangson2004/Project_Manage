package com.aps.projectmanage.service;

import com.aps.projectmanage.domain.dto.ProjectDTO;
import com.aps.projectmanage.domain.dto.ProjectMemberDTO;
import com.aps.projectmanage.domain.dto.UserDTO;
import com.aps.projectmanage.payload.CreateMemberPayload;
import com.aps.projectmanage.payload.UpdateMemberPayload;

import java.util.List;

public interface ProjectMemberService {
    List<ProjectDTO> getAllProjectsByUserId(int userId);
    List<UserDTO> getAllUsersByProjectId(int projectId);
    UserDTO addUserToProject(int projectId, CreateMemberPayload payload);
    UserDTO updateMemberRole(int projectId, UpdateMemberPayload payload);
    boolean deleteMemberFromProject(int projectId, int userId);
}
