package org.example.sqllab2.service;

import org.example.sqllab2.dto.CategoryDTO;
import org.example.sqllab2.model.Category;
import org.example.sqllab2.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(CategoryDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public Optional<CategoryDTO> getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .map(CategoryDTO::fromEntity);
    }

    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        if (categoryDTO.id() != null && categoryRepository.existsById(categoryDTO.id())) {
            throw new IllegalArgumentException("Category with this ID already exists");
        }
        Category category = categoryDTO.toEntity();
        if (categoryRepository.existsByName(category.getName())) {
            throw new IllegalArgumentException("Category name already exists");
        }
        Category createdCategory = categoryRepository.save(category);
        return CategoryDTO.fromEntity(createdCategory);
    }
}