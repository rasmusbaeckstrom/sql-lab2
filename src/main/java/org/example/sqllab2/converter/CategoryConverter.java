package org.example.sqllab2.converter;

import org.example.sqllab2.dto.CategoryDTO;
import org.example.sqllab2.model.Category;

public class CategoryConverter {

    public static CategoryDTO convertToDTO(Category category) {
        return new CategoryDTO(
                category.getId(),
                category.getName(),
                category.getSymbol(),
                category.getDescription()
        );
    }
}