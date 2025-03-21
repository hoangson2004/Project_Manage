package com.aps.projectmanage.service.impl;

import com.aps.projectmanage.domain.dto.ProjectDTO;
import com.aps.projectmanage.domain.dto.UserDTO;
import com.aps.projectmanage.domain.entity.Project;
import com.aps.projectmanage.domain.entity.ProjectMember;
import com.aps.projectmanage.domain.entity.ProjectMemberKey;
import com.aps.projectmanage.domain.entity.User;
import com.aps.projectmanage.domain.repository.ProjectMemberRepository;
import com.aps.projectmanage.domain.repository.ProjectRepository;
import com.aps.projectmanage.domain.repository.UserRepository;
import com.aps.projectmanage.exception.ConflictException;
import com.aps.projectmanage.mapper.ProjectMemberMapper;
import com.aps.projectmanage.mapper.RoleMapper;
import com.aps.projectmanage.payload.CreateMemberPayload;
import com.aps.projectmanage.service.ProjectMemberService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectMemberServiceImpl implements ProjectMemberService {
    private final ProjectMemberRepository projectMemberRepository;
    private final ModelMapper modelMapper;
    private final ProjectMemberMapper projectMemberMapper;
    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;

    @Override
    public List<ProjectDTO> getAllProjectsByUserId(int userId) {
        List<ProjectMember> projectMembers = projectMemberRepository.findProjectMembersByIdUserId(userId);

        return projectMembers.stream()
                .map(member -> modelMapper.map(member.getProject(), ProjectDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> getAllUsersByProjectId(int projectId) {
        List<ProjectMember> projectMembers = projectMemberRepository.findProjectMembersByIdProjectId(projectId);

        return projectMembers.stream()
                .map(member -> projectMemberMapper.toDTO(member.getUser(), member))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UserDTO addUserToProject(int projectId, CreateMemberPayload payload) {
        ProjectMemberKey id = new ProjectMemberKey();
        id.setUserId(payload.getUserId());
        id.setProjectId(projectId);

        if (projectMemberRepository.existsById(id)) {
            throw new ConflictException();
        }

        User user = userRepository.getById(payload.getUserId());

        Project project = projectRepository.getById(projectId);

        ProjectMember projectMember = new ProjectMember();
        projectMember.setId(id);
        projectMember.setUser(user);
        projectMember.setProject(project);
        projectMember.setRole(RoleMapper.toEntity(payload.getRole()));

        projectMemberRepository.save(projectMember);

        return projectMemberMapper.toDTO(user,projectMember);
    }

    @Override
    @Transactional
    public boolean deleteMemberFromProject(int projectId, int userId) {
        ProjectMemberKey id = new ProjectMemberKey();
        id.setUserId(userId);
        id.setProjectId(projectId);

        if (!projectMemberRepository.existsById(id)) {
            return false;
        }

        projectMemberRepository.deleteById(id);
        return true;
    }

}

