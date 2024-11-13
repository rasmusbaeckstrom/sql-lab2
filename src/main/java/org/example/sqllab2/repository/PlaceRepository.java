package org.example.sqllab2.repository;

import org.example.sqllab2.model.Place;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface PlaceRepository extends ListCrudRepository<Place, Long> {
    List<Place> findByIsPublicTrue();
    List<Place> findByCategoryIdAndIsPublicTrue(Long categoryId);
    List<Place> findByUserId(Long userId);
}