package com.milcolores.system_pos.model.inventory;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.milcolores.system_pos.model.admin.Supplier;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, length = 50)
    private String name;

    @NotBlank
    @Column(columnDefinition = "TEXT")
    private String description;

    @NotBlank
    @Column(nullable = false, length = 20)
    private String sku;

    @Column(nullable = false, length = 50)
    private String capacity;

    @Column(nullable = false, length = 50)
    private String unit; // unit, kg, l, m, etc.

    @Column(nullable = false, length = 50)
    private String color;

    @NotBlank
    @Column(nullable = false, length = 50)
    private String brand;

    @NotBlank
    @Column(nullable = false, length = 20)
    private BigDecimal price;

    @NotBlank
    @Column(nullable = false, length = 20)
    private BigDecimal cost;

    @NotBlank
    @Column(nullable = false, length = 255)
    private String imageUrl;

    @NotBlank
    @Column(nullable = false, length = 20)
    private int stock;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id", nullable = false)
    private Supplier supplier;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public Product(Long id, @NotBlank String name, @NotBlank String description, @NotBlank String sku, String capacity,
            String unit, String color, @NotBlank String brand, @NotBlank BigDecimal price, @NotBlank BigDecimal cost,
            @NotBlank String imageUrl, @NotBlank int stock, LocalDateTime createdAt, LocalDateTime updatedAt,
            Category category, Supplier supplier) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.sku = sku;
        this.capacity = capacity;
        this.unit = unit;
        this.color = color;
        this.brand = brand;
        this.price = price;
        this.cost = cost;
        this.imageUrl = imageUrl;
        this.stock = stock;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.category = category;
        this.supplier = supplier;
    }
}
