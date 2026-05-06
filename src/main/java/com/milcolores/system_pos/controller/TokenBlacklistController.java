package com.milcolores.system_pos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.milcolores.system_pos.model.admin.TokenBlacklist;
import com.milcolores.system_pos.service.TokenBlacklist.TokenBlacklistService;

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
@RequestMapping("/tokenblacklists")
@Tag(name = "TokenBlacklist", description = "Endpoints for managing token blacklists")
public class TokenBlacklistController {

    @Autowired
    TokenBlacklistService tokenBlacklistService;

    public TokenBlacklistController(TokenBlacklistService tokenBlacklistService) {
        this.tokenBlacklistService = tokenBlacklistService;
    }

    @GetMapping("/getAll")
    @Operation(summary = "Get all token blacklists", description = "Returns a list of all token blacklists")
    public ResponseEntity<List<TokenBlacklist>> getAllTokenBlacklists() {
        return ResponseEntity.ok(tokenBlacklistService.getAllTokenBlacklists());
    }

    @GetMapping("/get/{id}")
    @Operation(summary = "Get a token blacklist by ID", description = "Returns a single token blacklist by their ID")
    public ResponseEntity<TokenBlacklist> getTokenBlacklistById(@PathVariable Long id) {
        return ResponseEntity.ok(tokenBlacklistService.getTokenBlacklistById(id));
    }

    @PostMapping("/save")
    @Operation(summary = "Save a new token blacklist", description = "Creates a new token blacklist") 
    public ResponseEntity<TokenBlacklist> saveTokenBlacklist(@Valid @RequestBody TokenBlacklist tokenBlacklist) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tokenBlacklistService.save(tokenBlacklist));
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete a token blacklist by ID", description = "Deletes a single token blacklist by their ID")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        tokenBlacklistService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/edit/{id}")
    @Operation(summary = "Update a token blacklist by ID", description = "Updates a single token blacklist by their ID")
    public ResponseEntity<Void> update(@PathVariable Long id, @Valid @RequestBody TokenBlacklist tokenBlacklist) {
        tokenBlacklist.setId(id);
        tokenBlacklistService.update(tokenBlacklist);
        return ResponseEntity.noContent().build();
    }

}
