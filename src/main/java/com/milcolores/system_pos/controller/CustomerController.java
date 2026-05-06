package com.milcolores.system_pos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.milcolores.system_pos.model.admin.Customer;
import com.milcolores.system_pos.service.Customer.CustomerService;

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
@RequestMapping("/customers")
@Tag(name = "Customer", description = "Endpoints for managing customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/getAll")
    @Operation(summary = "Get all customers", description = "Returns a list of all customers")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @GetMapping("/get/{id}")
    @Operation(summary = "Get a customer by ID", description = "Returns a single customer by their ID")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @PostMapping("/save")
    @Operation(summary = "Save a new customer", description = "Creates a new customer") 
    public ResponseEntity<Customer> saveCustomer(@Valid @RequestBody Customer customer) {
        
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.save(customer));
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete a customer by ID", description = "Deletes a single customer by their ID")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        customerService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/edit/{id}")
    @Operation(summary = "Update a customer by ID", description = "Updates a single customer by their ID")
    public ResponseEntity<Void> update(@PathVariable Long id, @Valid @RequestBody Customer customer) {
        customer.setId(id);
        customerService.update(customer);
        return ResponseEntity.noContent().build();
    }

}
