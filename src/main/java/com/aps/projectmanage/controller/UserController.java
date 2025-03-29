package com.aps.projectmanage.controller;


import com.aps.projectmanage.domain.constant.StatusCode;
import com.aps.projectmanage.payload.CreateUserPayload;
import com.aps.projectmanage.payload.UpdateUserPayload;
import com.aps.projectmanage.service.ProjectMemberService;
import com.aps.projectmanage.service.UserService;
import com.aps.projectmanage.util.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController extends BaseController {
    private final UserService userService;
    private final ProjectMemberService projectMemberService;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getAllUsers() {
        return handleSuccess("Get all users", userService.getAllUsers());
    }

    @GetMapping("/project/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getUsersByProjectId(@PathVariable int id) {
        return handleSuccess("Get users by project id:" + id + "success",
                projectMemberService.getAllUsersByProjectId(id));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        return handleSuccess("Get user by id success", userService.getUserById(id));
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> createUser(@RequestBody CreateUserPayload userPayload) {
        return handleSuccess(StatusCode.CREATED, "Create user success",
                userService.createUser(userPayload));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateUser(
            @RequestBody UpdateUserPayload userPayload, @PathVariable int id) {
        return handleSuccess("Update user success", userService.updateUser(userPayload, id));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        return handleSuccess("Delete user success", deleteUser(userService.deleteUserById(id)));
    }

    @PutMapping("/myaccount") //updatev2
    public ResponseEntity<?> updateMyAccount(@RequestBody UpdateUserPayload payload) {
        Integer userId = SecurityUtil.getCurrentUserId();
        return handleSuccess("Update user success", userService.updateUser(payload,userId));
    }

}
