package com.system.system_pos.service.Category;

import java.util.List;

import org.springframework.stereotype.Service;

import com.system.system_pos.exception.ResourceNotFound;
import com.system.system_pos.model.inventory.Category;
import com.system.system_pos.repository.CategoryRepository;

@Service
public class CategoryServiceImp implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImp(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Category not found with id: " + id));
        return category;
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category update(Category category) {
        return categoryRepository.save(category);
    }
}
