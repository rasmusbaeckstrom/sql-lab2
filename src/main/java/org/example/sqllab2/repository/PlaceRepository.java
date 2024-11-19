package org.example.sqllab2.repository;

import org.example.sqllab2.model.Place;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlaceRepository extends ListCrudRepository<Place, Long> {
    List<Place> findByIsPublicTrue();
    List<Place> findByCategoryIdAndIsPublicTrue(Long categoryId);
    List<Place> findByUserId(Long userId);

    @Query("SELECT p FROM Place p WHERE ST_Distance_Sphere(p.coordinates, ST_GeomFromText(:point, 4326)) <= :radius")
    List<Place> findPlacesWithinRadius(@Param("point") String point, @Param("radius") double radius);
}