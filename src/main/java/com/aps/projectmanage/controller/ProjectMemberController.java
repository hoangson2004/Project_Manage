package com.aps.projectmanage.controller;

import com.aps.projectmanage.domain.dto.UserDTO;
import com.aps.projectmanage.payload.CreateMemberPayload;
import com.aps.projectmanage.response.BaseResponse;
import com.aps.projectmanage.response.MemberResponse;
import com.aps.projectmanage.service.ProjectMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class ProjectMemberController {

    private final ProjectMemberService projectMemberService;

    @PostMapping("/project/{projectId}")
    public ResponseEntity<MemberResponse> addUserToProject(
            @PathVariable int projectId,
            @RequestBody CreateMemberPayload payload) {

        UserDTO member = projectMemberService.addUserToProject(projectId, payload);
        MemberResponse response = new MemberResponse();
        response = response.addMember(member);
        return ResponseEntity.ok(response);
    }


    @DeleteMapping
    public ResponseEntity<MemberResponse> removeUserFromProject(
            @RequestParam int projectId,
            @RequestParam int userId) {
        MemberResponse response = new MemberResponse();
        response = response.deleteMember(projectMemberService.deleteMemberFromProject(projectId, userId));
        return ResponseEntity.ok(response);
    }

}