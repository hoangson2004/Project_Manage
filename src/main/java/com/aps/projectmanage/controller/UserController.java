package com.aps.projectmanage.controller;


import com.aps.projectmanage.domain.dto.UserDTO;
import com.aps.projectmanage.exception.NotFoundException;
import com.aps.projectmanage.payload.CreateUserPayload;
import com.aps.projectmanage.payload.UpdateUserPayload;
import com.aps.projectmanage.response.BaseResponse;
import com.aps.projectmanage.response.UserResponse;
import com.aps.projectmanage.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    UserResponse userResponse = new UserResponse();

    @GetMapping
    public ResponseEntity<BaseResponse<List<UserDTO>>> getAllUsers() {
        BaseResponse<List<UserDTO>> response = new BaseResponse<>();
        response = userResponse.getAllUsers(userService.getAllUsers());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable int id) {
        userResponse = userResponse.getUser(
                userService.getUserById(id)
                        .orElseThrow(() -> new NotFoundException()));
        return ResponseEntity.ok(userResponse);
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody CreateUserPayload userPayload) {
        userResponse = userResponse.createUser(
                userService.createUser(userPayload));
        return ResponseEntity.ok(userResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@RequestBody UpdateUserPayload userPayload, @PathVariable int id) {
        userResponse = userResponse.updateUser(
                userService.updateUser(userPayload, id));
        return ResponseEntity.ok(userResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponse> deleteUser(@PathVariable int id) {
        if (!userService.getUserById(id).isPresent()) {
            throw new NotFoundException();
        }
        userResponse = userResponse.deleteUser(userService.deleteUserById(id));
        return ResponseEntity.ok(userResponse);
    }

}
