package com.system.system_pos.service.InventaryMov;

import java.util.List;

import org.springframework.stereotype.Service;

import com.system.system_pos.exception.ResourceNotFound;
import com.system.system_pos.model.inventory.InventaryMov;
import com.system.system_pos.repository.InventaryMovRepository;

@Service
public class InventaryMovServiceImp implements InventaryMovService {

    private final InventaryMovRepository inventaryMovRepository;

    public InventaryMovServiceImp(InventaryMovRepository inventaryMovRepository) {
        this.inventaryMovRepository = inventaryMovRepository;
    }

    @Override
    public List<InventaryMov> getAllInventaryMovs() {
        return inventaryMovRepository.findAll();
    }

    @Override
    public InventaryMov getInventaryMovById(Long id) {
        InventaryMov inventaryMov = inventaryMovRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("InventaryMov not found with id: " + id));
        return inventaryMov;
    }

    @Override
    public InventaryMov save(InventaryMov inventaryMov) {
        return inventaryMovRepository.save(inventaryMov);
    }

    @Override
    public void delete(Long id) {
        inventaryMovRepository.deleteById(id);
    }

    @Override
    public InventaryMov update(InventaryMov inventaryMov) {
        return inventaryMovRepository.save(inventaryMov);
    }
}
