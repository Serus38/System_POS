package com.system.system_pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.system_pos.model.sales.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
    
}
