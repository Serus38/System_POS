package com.milcolores.system_pos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.milcolores.system_pos.model.sales.Sale;
import com.milcolores.system_pos.service.Sale.SaleService;

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
@RequestMapping("/sales")
@Tag(name = "Sale", description = "Endpoints for managing sales")
public class SaleController {

    @Autowired
    SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping("/getAll")
    @Operation(summary = "Get all sales", description = "Returns a list of all sales")
    public ResponseEntity<List<Sale>> getAllSales() {
        return ResponseEntity.ok(saleService.getAllSales());
    }

    @GetMapping("/get/{id}")
    @Operation(summary = "Get a sale by ID", description = "Returns a single sale by their ID")
    public ResponseEntity<Sale> getSaleById(@PathVariable Long id) {
        return ResponseEntity.ok(saleService.getSaleById(id));
    }

    @PostMapping("/save")
    @Operation(summary = "Save a new sale", description = "Creates a new sale") 
    public ResponseEntity<Sale> saveSale(@Valid @RequestBody Sale sale) {
        return ResponseEntity.status(HttpStatus.CREATED).body(saleService.save(sale));
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete a sale by ID", description = "Deletes a single sale by their ID")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        saleService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/edit/{id}")
    @Operation(summary = "Update a sale by ID", description = "Updates a single sale by their ID")
    public ResponseEntity<Void> update(@PathVariable Long id, @Valid @RequestBody Sale sale) {
        sale.setId(id);
        saleService.update(sale);
        return ResponseEntity.noContent().build();
    }

}
