package com.milcolores.system_pos.service.SaleItem;

import java.util.List;

import org.springframework.stereotype.Service;

import com.milcolores.system_pos.model.sales.SaleItem;

@Service
public interface SaleItemService {

    List<SaleItem> getAllSaleItems();

    SaleItem getSaleItemById(Long id);

    SaleItem save(SaleItem saleItem);

    void delete(Long id);

    SaleItem update(SaleItem saleItem);
}
