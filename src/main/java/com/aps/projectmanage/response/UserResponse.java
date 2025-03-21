package com.aps.projectmanage.response;

import com.aps.projectmanage.domain.constant.StatusCode;
import com.aps.projectmanage.domain.dto.ProjectMemberDTO;
import com.aps.projectmanage.domain.dto.UserDTO;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class UserResponse extends BaseResponse<UserDTO> {
    public UserResponse(String status, String message, UserDTO data) {
        super(status, message, data);
    }

    public UserResponse createUser(UserDTO data) {
        return new UserResponse(
                StatusCode.SUCCESS.getStatusCode(),
                "Added user successfully",
                data);
    }

    public UserResponse updateUser(UserDTO data) {
        return new UserResponse(
                StatusCode.SUCCESS.getStatusCode(),
                "Updated user successfully",
                data);
    }

    public BaseResponse<List<UserDTO>> getAllUsers(List<UserDTO> users) {
        return new BaseResponse<>(
                StatusCode.SUCCESS.getStatusCode(),
                "Fetched all users successfully",
                users
        );
    }

    public BaseResponse<List<ProjectMemberDTO>> getAllMembers(List<ProjectMemberDTO> users) {
        return new BaseResponse<>(
                StatusCode.SUCCESS.getStatusCode(),
                "Fetched all users successfully",
                users
        );
    }

    public UserResponse getUser(UserDTO data) {
        return new UserResponse(StatusCode.SUCCESS.getStatusCode(),
                "Fetched user successfully",
                data);
    }

    public UserResponse deleteUser(int userId) {
        return new UserResponse(
                StatusCode.SUCCESS.getStatusCode(),
                "Deleted user with ID " + userId + " successfully",
                null);
    }

}
