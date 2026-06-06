package com.system.system_pos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.system.system_pos.model.inventory.Product;
import com.system.system_pos.service.Product.ProductService;

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
@RequestMapping("/products")
@Tag(name = "Product", description = "Endpoints for managing products")
public class ProductController {

    @Autowired
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getAll")
    @Operation(summary = "Get all products", description = "Returns a list of all products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/get/{id}")
    @Operation(summary = "Get a product by ID", description = "Returns a single product by their ID")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PostMapping("/save")
    @Operation(summary = "Save a new product", description = "Creates a new product") 
    public ResponseEntity<Product> saveProduct(@Valid @RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product));
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete a product by ID", description = "Deletes a single product by their ID")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/edit/{id}")
    @Operation(summary = "Update a product by ID", description = "Updates a single product by their ID")
    public ResponseEntity<Void> update(@PathVariable Long id, @Valid @RequestBody Product product) {
        product.setId(id);
        productService.update(product);
        return ResponseEntity.noContent().build();
    }

}
