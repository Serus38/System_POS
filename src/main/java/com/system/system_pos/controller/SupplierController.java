package com.system.system_pos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.system.system_pos.model.admin.Supplier;
import com.system.system_pos.service.Supplier.SupplierService;

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
@RequestMapping("/suppliers")
@Tag(name = "Supplier", description = "Endpoints for managing suppliers")
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping("/getAll")
    @Operation(summary = "Get all suppliers", description = "Returns a list of all suppliers")
    public ResponseEntity<List<Supplier>> getAllSuppliers() {
        return ResponseEntity.ok(supplierService.getAllSuppliers());
    }

    @GetMapping("/get/{id}")
    @Operation(summary = "Get a supplier by ID", description = "Returns a single supplier by their ID")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable Long id) {
        return ResponseEntity.ok(supplierService.getSupplierById(id));
    }

    @PostMapping("/save")
    @Operation(summary = "Save a new supplier", description = "Creates a new supplier") 
    public ResponseEntity<Supplier> saveSupplier(@Valid @RequestBody Supplier supplier) {
        return ResponseEntity.status(HttpStatus.CREATED).body(supplierService.save(supplier));
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete a supplier by ID", description = "Deletes a single supplier by their ID")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        supplierService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/edit/{id}")
    @Operation(summary = "Update a supplier by ID", description = "Updates a single supplier by their ID")
    public ResponseEntity<Void> update(@PathVariable Long id, @Valid @RequestBody Supplier supplier) {
        supplier.setId(id);
        supplierService.update(supplier);
        return ResponseEntity.noContent().build();
    }

}
