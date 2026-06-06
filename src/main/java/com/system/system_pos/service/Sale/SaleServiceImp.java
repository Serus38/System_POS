package com.system.system_pos.service.Sale;

import java.util.List;

import org.springframework.stereotype.Service;

import com.system.system_pos.exception.ResourceNotFound;
import com.system.system_pos.model.sales.Sale;
import com.system.system_pos.repository.SaleRepository;

@Service
public class SaleServiceImp implements SaleService {

    private final SaleRepository saleRepository;

    public SaleServiceImp(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }

    @Override
    public Sale getSaleById(Long id) {
        Sale sale = saleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Sale not found with id: " + id));
        return sale;
    }

    @Override
    public Sale save(Sale sale) {
        return saleRepository.save(sale);
    }

    @Override
    public void delete(Long id) {
        saleRepository.deleteById(id);
    }

    @Override
    public Sale update(Sale sale) {
        return saleRepository.save(sale);
    }
}
