package com.aps.projectmanage.service.impl;

import com.aps.projectmanage.domain.entity.Project;
import com.aps.projectmanage.domain.dto.ProjectDTO;
import com.aps.projectmanage.exception.NotFoundException;
import com.aps.projectmanage.payload.ProjectPayload;
import com.aps.projectmanage.domain.repository.ProjectRepository;
import com.aps.projectmanage.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<ProjectDTO> getAllProjects() {
        return projectRepository.findAll().stream()
                .map(project -> modelMapper.map(project, ProjectDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProjectDTO getProjectById(int id) {
        Project project = projectRepository.findById(id).get();
        ProjectDTO projectDTO = new ProjectDTO();
        modelMapper.map(project, projectDTO);
        return projectDTO;
    }

    @Override
    public ProjectDTO createProject(ProjectPayload payload) {
        Project project = new Project();
        modelMapper.map(payload, project);
        ProjectDTO projectDto = new ProjectDTO();
        modelMapper.map(projectRepository.save(project), projectDto);
        return projectDto;
    }

    @Override
    public ProjectDTO updateProject(int id, ProjectPayload payload) {
        Project project = projectRepository.findById(id).get();
        modelMapper.map(payload, project);
        Project updatedProject = projectRepository.save(project);
        ProjectDTO projectDto = new ProjectDTO();
        modelMapper.map(updatedProject, projectDto);
        return projectDto;
    }

    @Override
    public int deleteProject(int id) {
        Project project = projectRepository.findById(id).get();
        project.setIsActive(false);
        projectRepository.save(project);
        return id;
    }

}