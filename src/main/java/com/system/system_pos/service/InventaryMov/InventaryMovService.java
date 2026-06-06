package com.system.system_pos.service.InventaryMov;

import java.util.List;

import org.springframework.stereotype.Service;

import com.system.system_pos.model.inventory.InventaryMov;

@Service
public interface InventaryMovService {

    List<InventaryMov> getAllInventaryMovs();

    InventaryMov getInventaryMovById(Long id);

    InventaryMov save(InventaryMov inventaryMov);

    void delete(Long id);

    InventaryMov update(InventaryMov inventaryMov);
}
