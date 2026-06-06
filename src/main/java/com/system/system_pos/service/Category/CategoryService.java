package com.system.system_pos.service.Category;

import java.util.List;

import org.springframework.stereotype.Service;

import com.system.system_pos.model.inventory.Category;

@Service
public interface CategoryService {

    List<Category> getAllCategories();

    Category getCategoryById(Long id);

    Category save(Category category);

    void delete(Long id);

    Category update(Category category);
}
