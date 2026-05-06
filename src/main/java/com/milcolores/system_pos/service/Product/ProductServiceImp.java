package com.milcolores.system_pos.service.Product;

import java.util.List;

import org.springframework.stereotype.Service;

import com.milcolores.system_pos.exception.ResourceNotFound;
import com.milcolores.system_pos.model.inventory.Product;
import com.milcolores.system_pos.repository.ProductRepository;

@Service
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Product not found with id: " + id));
        return product;
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }
}
