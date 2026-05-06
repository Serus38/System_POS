package com.milcolores.system_pos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.milcolores.system_pos.model.admin.User;
import com.milcolores.system_pos.service.User.UserService;

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

    @Autowired
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAll")
    @Operation(summary = "Get all users", description = "Returns a list of all users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/get/{id}")
    @Operation(summary = "Get a user by ID", description = "Returns a single user by their ID")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping("/save")
    @Operation(summary = "Save a new user", description = "Creates a new user") 
    public ResponseEntity<User> saveUser(@Valid @RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete a user by ID", description = "Deletes a single user by their ID")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/edit/{id}")
    @Operation(summary = "Update a user by ID", description = "Updates a single user by their ID")
    public ResponseEntity<Void> update(@PathVariable Long id, @Valid @RequestBody User user) {
        user.setId(id);
        userService.update(user);
        return ResponseEntity.noContent().build();
    }

}
