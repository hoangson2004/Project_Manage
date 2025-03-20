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
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody CreateUserPayload userPayload) {
        UserResponse userResponse = new UserResponse().createUser(userService.create(userPayload));
        return ResponseEntity.ok(userResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable int id) {
        return userService.getById(id)
                .map(user -> ResponseEntity.ok(new UserResponse().getUser(user)))
                .orElseThrow(() -> new NotFoundException());
    }


    @GetMapping
    public ResponseEntity<BaseResponse<List<UserDTO>>> getAllUsers() {
        return ResponseEntity.ok(new UserResponse().getAllUsers(userService.getAll()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@RequestBody UpdateUserPayload userPayload, @PathVariable int id) {
        UserResponse userResponse = new UserResponse().updateUser(userService.update(userPayload, id));
        return ResponseEntity.ok(userResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponse> deleteUser(@PathVariable int id) {
        if (!userService.getById(id).isPresent()) {
            throw new NotFoundException("User not found with id: " + id);
        }
        return ResponseEntity.ok(new UserResponse().deleteUser(userService.deleteById(id)));
    }

}
