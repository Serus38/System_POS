package com.system.system_pos.dto.product;

public record ProductResponse(
    Long id,
    String name,
    String description,
    String sku,
    String capacity,
    String unit,
    String color
) {
}