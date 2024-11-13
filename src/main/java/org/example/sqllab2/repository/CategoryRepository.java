package org.example.sqllab2.repository;

import org.example.sqllab2.model.Category;
import org.springframework.data.repository.ListCrudRepository;


public interface CategoryRepository extends ListCrudRepository<Category, Long> {
    boolean existsByName(String name);
}