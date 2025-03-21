package com.aps.projectmanage.mapper;

import com.aps.projectmanage.domain.constant.RoleName;
import com.aps.projectmanage.domain.dto.ProjectMemberDTO;
import com.aps.projectmanage.domain.dto.RoleDTO;
import com.aps.projectmanage.domain.dto.UserDTO;
import com.aps.projectmanage.domain.entity.ProjectMember;
import com.aps.projectmanage.domain.entity.Role;
import com.aps.projectmanage.domain.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProjectMemberMapper {
    private final ModelMapper modelMapper;
    private final RoleMapper roleMapper = new RoleMapper();

    public ProjectMemberMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public UserDTO toDTO(User user, ProjectMember projectMember) {
        UserDTO dto = modelMapper.map(user, UserDTO.class);
        dto.setRole(roleMapper.toDTO(projectMember.getRole().getRoleValue()));
        return dto;
    }
}
