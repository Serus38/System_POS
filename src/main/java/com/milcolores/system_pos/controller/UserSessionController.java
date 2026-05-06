package com.milcolores.system_pos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.milcolores.system_pos.model.admin.UserSession;
import com.milcolores.system_pos.service.UserSession.UserSessionService;

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
@RequestMapping("/usersessions")
@Tag(name = "UserSession", description = "Endpoints for managing user sessions")
public class UserSessionController {

    @Autowired
    UserSessionService userSessionService;

    public UserSessionController(UserSessionService userSessionService) {
        this.userSessionService = userSessionService;
    }

    @GetMapping("/getAll")
    @Operation(summary = "Get all user sessions", description = "Returns a list of all user sessions")
    public ResponseEntity<List<UserSession>> getAllUserSessions() {
        return ResponseEntity.ok(userSessionService.getAllUserSessions());
    }

    @GetMapping("/get/{id}")
    @Operation(summary = "Get a user session by ID", description = "Returns a single user session by their ID")
    public ResponseEntity<UserSession> getUserSessionById(@PathVariable Long id) {
        return ResponseEntity.ok(userSessionService.getUserSessionById(id));
    }

    @PostMapping("/save")
    @Operation(summary = "Save a new user session", description = "Creates a new user session") 
    public ResponseEntity<UserSession> saveUserSession(@Valid @RequestBody UserSession userSession) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userSessionService.save(userSession));
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete a user session by ID", description = "Deletes a single user session by their ID")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userSessionService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/edit/{id}")
    @Operation(summary = "Update a user session by ID", description = "Updates a single user session by their ID")
    public ResponseEntity<Void> update(@PathVariable Long id, @Valid @RequestBody UserSession userSession) {
        userSession.setId(id);
        userSessionService.update(userSession);
        return ResponseEntity.noContent().build();
    }

}
