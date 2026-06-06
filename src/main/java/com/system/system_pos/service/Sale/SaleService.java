package com.system.system_pos.service.Sale;

import java.util.List;

import org.springframework.stereotype.Service;

import com.system.system_pos.model.sales.Sale;

@Service
public interface SaleService {

    List<Sale> getAllSales();

    Sale getSaleById(Long id);

    Sale save(Sale sale);

    void delete(Long id);

    Sale update(Sale sale);
}
