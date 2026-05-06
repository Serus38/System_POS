package com.milcolores.system_pos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.milcolores.system_pos.model.inventory.InventaryMov;
import com.milcolores.system_pos.service.InventaryMov.InventaryMovService;

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
@RequestMapping("/inventarymovs")
@Tag(name = "InventaryMov", description = "Endpoints for managing inventory movements")
public class InventaryMovController {

    @Autowired
    InventaryMovService inventaryMovService;

    public InventaryMovController(InventaryMovService inventaryMovService) {
        this.inventaryMovService = inventaryMovService;
    }

    @GetMapping("/getAll")
    @Operation(summary = "Get all inventory movements", description = "Returns a list of all inventory movements")
    public ResponseEntity<List<InventaryMov>> getAllInventaryMovs() {
        return ResponseEntity.ok(inventaryMovService.getAllInventaryMovs());
    }

    @GetMapping("/get/{id}")
    @Operation(summary = "Get an inventory movement by ID", description = "Returns a single inventory movement by their ID")
    public ResponseEntity<InventaryMov> getInventaryMovById(@PathVariable Long id) {
        return ResponseEntity.ok(inventaryMovService.getInventaryMovById(id));
    }

    @PostMapping("/save")
    @Operation(summary = "Save a new inventory movement", description = "Creates a new inventory movement") 
    public ResponseEntity<InventaryMov> saveInventaryMov(@Valid @RequestBody InventaryMov inventaryMov) {
        return ResponseEntity.status(HttpStatus.CREATED).body(inventaryMovService.save(inventaryMov));
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete an inventory movement by ID", description = "Deletes a single inventory movement by their ID")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        inventaryMovService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/edit/{id}")
    @Operation(summary = "Update an inventory movement by ID", description = "Updates a single inventory movement by their ID")
    public ResponseEntity<Void> update(@PathVariable Long id, @Valid @RequestBody InventaryMov inventaryMov) {
        inventaryMov.setId(id);
        inventaryMovService.update(inventaryMov);
        return ResponseEntity.noContent().build();
    }

}
