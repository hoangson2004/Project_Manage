package com.aps.projectmanage.service.impl;

import com.aps.projectmanage.domain.dto.ProjectDTO;
import com.aps.projectmanage.domain.dto.ProjectMemberDTO;
import com.aps.projectmanage.domain.dto.UserDTO;
import com.aps.projectmanage.domain.entity.ProjectMember;
import com.aps.projectmanage.domain.repository.ProjectMemberRepository;
import com.aps.projectmanage.mapper.ProjectMemberMapper;
import com.aps.projectmanage.mapper.UserMapper;
import com.aps.projectmanage.service.ProjectMemberService;
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
}

