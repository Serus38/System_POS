package com.system.system_pos.service.Product;

import java.util.List;

import org.springframework.stereotype.Service;

import com.system.system_pos.model.inventory.Product;

@Service
public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(Long id);

    Product save(Product product);

    void delete(Long id);

    Product update(Product product);
}
