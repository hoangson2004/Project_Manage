package com.aps.projectmanage.response;

import com.aps.projectmanage.domain.constant.StatusCode;
import com.aps.projectmanage.domain.dto.UserDTO;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MemberResponse extends BaseResponse<UserDTO> {
    public MemberResponse(String status, String message) {
        super(status, message, null);
    }

    public MemberResponse(String status, String message, UserDTO data) {
        super(status, message, data);
    }

    public MemberResponse addMember(UserDTO data) {
        return new MemberResponse(
                StatusCode.SUCCESS.getStatusCode(),
                "Added member successfully",
                data);
    }

    public MemberResponse deleteMember(boolean b) {
        return new MemberResponse(
                StatusCode.SUCCESS.getStatusCode(),
                "Deleted member successfully",
                null);}
}
