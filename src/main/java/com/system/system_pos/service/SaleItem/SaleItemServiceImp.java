package com.system.system_pos.service.SaleItem;

import java.util.List;

import org.springframework.stereotype.Service;

import com.system.system_pos.exception.ResourceNotFound;
import com.system.system_pos.model.sales.SaleItem;
import com.system.system_pos.repository.SaleItemRepository;

@Service
public class SaleItemServiceImp implements SaleItemService {

    private final SaleItemRepository saleItemRepository;

    public SaleItemServiceImp(SaleItemRepository saleItemRepository) {
        this.saleItemRepository = saleItemRepository;
    }

    @Override
    public List<SaleItem> getAllSaleItems() {
        return saleItemRepository.findAll();
    }

    @Override
    public SaleItem getSaleItemById(Long id) {
        SaleItem saleItem = saleItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("SaleItem not found with id: " + id));
        return saleItem;
    }

    @Override
    public SaleItem save(SaleItem saleItem) {
        return saleItemRepository.save(saleItem);
    }

    @Override
    public void delete(Long id) {
        saleItemRepository.deleteById(id);
    }

    @Override
    public SaleItem update(SaleItem saleItem) {
        return saleItemRepository.save(saleItem);
    }
}
