package com.milcolores.system_pos.model.sales;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import com.milcolores.system_pos.model.admin.Customer;
import com.milcolores.system_pos.model.enums.SaleStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "sales")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sale_date", nullable = false)
    private LocalDateTime saleDate;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal totalAmount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SaleStatus status;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SaleItem> items;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        if (this.saleDate == null) {
            this.saleDate = LocalDateTime.now();
        }
    }

    public Sale(Long id, LocalDateTime saleDate, BigDecimal totalAmount, SaleStatus status, LocalDateTime createdAt,
            List<SaleItem> items, Customer customer) {
        this.id = id;
        this.saleDate = saleDate;
        this.totalAmount = totalAmount;
        this.status = status;
        this.createdAt = createdAt;
        this.items = items;
        this.customer = customer;
    }

}
