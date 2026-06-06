package com.system.system_pos.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.system.system_pos.dto.user.UserRequest;
import com.system.system_pos.dto.user.UserResponse;
import com.system.system_pos.model.admin.User;
import com.system.system_pos.service.User.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/users")
@Tag(name = "User", description = "Endpoints for managing users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAll")
    @Operation(summary = "Get all users", description = "Returns a list of all users")
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/get/{id}")
    @Operation(summary = "Get a user by ID", description = "Returns a single user by their ID")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping("/save")
    @Operation(summary = "Save a new user", description = "Creates a new user with encryption and normalization")
    public ResponseEntity<UserResponse> saveUser(@Valid @RequestBody UserRequest dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(dto));
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete a user by ID", description = "Deletes a single user by their ID")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/edit/{id}")
    @Operation(summary = "Update a user by ID", description = "Updates a single user by their ID with encryption and normalization")
    public ResponseEntity<UserResponse> update(@PathVariable Long id, @Valid @RequestBody UserRequest dto) {
        UserResponse updatedUser = userService.update(id, dto);
        return ResponseEntity.ok(updatedUser);
    }

}
