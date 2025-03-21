package com.aps.projectmanage.service;

import com.aps.projectmanage.domain.dto.ProjectDTO;
import com.aps.projectmanage.domain.dto.UserDTO;

import java.util.List;

public interface ProjectMemberService {
    List<ProjectDTO> getAllProjectsByUserId(int userId);
    List<UserDTO> getAllUsersByProjectId(int projectId);
}
