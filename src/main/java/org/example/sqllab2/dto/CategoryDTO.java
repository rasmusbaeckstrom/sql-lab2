package org.example.sqllab2.dto;

import org.example.sqllab2.model.Category;

public record CategoryDTO(Long id, String name, String symbol, String description) {

    public static CategoryDTO fromEntity(Category category) {
        return new CategoryDTO(
                category.getId(),
                category.getName(),
                category.getSymbol(),
                category.getDescription()
        );
    }

    public Category toEntity() {
        Category category = new Category();
        category.setId(this.id());
        category.setName(this.name());
        category.setSymbol(this.symbol());
        category.setDescription(this.description());
        return category;
    }
}