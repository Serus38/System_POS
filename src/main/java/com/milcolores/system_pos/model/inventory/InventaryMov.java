package com.milcolores.system_pos.model.inventory;

import java.time.LocalDateTime;

import com.milcolores.system_pos.model.enums.MovementType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "inventary_mov")
public class InventaryMov {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MovementType type; // IN, OUT

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false, length = 255)
    private String reason; // reason for the movement, e.g. sale, purchase, adjustment, etc.

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public InventaryMov(Long id, Product product, MovementType type, Integer quantity, String reason,
            LocalDateTime createdAt) {
        this.id = id;
        this.product = product;
        this.type = type;
        this.quantity = quantity;
        this.reason = reason;
        this.createdAt = createdAt;
    }
    
}
