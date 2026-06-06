package com.system.system_pos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.system.system_pos.model.sales.SaleItem;
import com.system.system_pos.service.SaleItem.SaleItemService;

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
@RequestMapping("/saleitems")
@Tag(name = "SaleItem", description = "Endpoints for managing sale items")
public class SaleItemController {

    @Autowired
    SaleItemService saleItemService;

    public SaleItemController(SaleItemService saleItemService) {
        this.saleItemService = saleItemService;
    }

    @GetMapping("/getAll")
    @Operation(summary = "Get all sale items", description = "Returns a list of all sale items")
    public ResponseEntity<List<SaleItem>> getAllSaleItems() {
        return ResponseEntity.ok(saleItemService.getAllSaleItems());
    }

    @GetMapping("/get/{id}")
    @Operation(summary = "Get a sale item by ID", description = "Returns a single sale item by their ID")
    public ResponseEntity<SaleItem> getSaleItemById(@PathVariable Long id) {
        return ResponseEntity.ok(saleItemService.getSaleItemById(id));
    }

    @PostMapping("/save")
    @Operation(summary = "Save a new sale item", description = "Creates a new sale item") 
    public ResponseEntity<SaleItem> saveSaleItem(@Valid @RequestBody SaleItem saleItem) {
        return ResponseEntity.status(HttpStatus.CREATED).body(saleItemService.save(saleItem));
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete a sale item by ID", description = "Deletes a single sale item by their ID")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        saleItemService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/edit/{id}")
    @Operation(summary = "Update a sale item by ID", description = "Updates a single sale item by their ID")
    public ResponseEntity<Void> update(@PathVariable Long id, @Valid @RequestBody SaleItem saleItem) {
        saleItem.setId(id);
        saleItemService.update(saleItem);
        return ResponseEntity.noContent().build();
    }

}
