package com.milcolores.system_pos.service.Supplier;

import java.util.List;

import org.springframework.stereotype.Service;

import com.milcolores.system_pos.exception.ResourceNotFound;
import com.milcolores.system_pos.model.admin.Supplier;
import com.milcolores.system_pos.repository.SupplierRepository;

@Service
public class SupplierServiceImp implements SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierServiceImp(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    @Override
    public Supplier getSupplierById(Long id) {
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Supplier not found with id: " + id));
        return supplier;
    }

    @Override
    public Supplier save(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public void delete(Long id) {
        supplierRepository.deleteById(id);
    }

    @Override
    public Supplier update(Supplier supplier) {
        return supplierRepository.save(supplier);
    }
}
