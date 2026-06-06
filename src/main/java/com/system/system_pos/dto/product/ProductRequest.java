package com.system.system_pos.dto.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ProductRequest(
    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    String name,

    @NotNull
    @Size(min = 1, max = 100, message = "La descripción debe tener entre 1 y 100 caracteres")
    String description,

    @NotBlank(message = "El SKU no puede estar vacío")
    @Size(min = 2, max = 20, message = "El SKU debe tener entre 2 y 20 caracteres")
    String sku

){ 
}

