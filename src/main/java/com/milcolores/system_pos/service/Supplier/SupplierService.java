package com.milcolores.system_pos.service.Supplier;

import java.util.List;

import org.springframework.stereotype.Service;

import com.milcolores.system_pos.model.admin.Supplier;

@Service
public interface SupplierService {

    List<Supplier> getAllSuppliers();

    Supplier getSupplierById(Long id);

    Supplier save(Supplier supplier);

    void delete(Long id);

    Supplier update(Supplier supplier);
}
