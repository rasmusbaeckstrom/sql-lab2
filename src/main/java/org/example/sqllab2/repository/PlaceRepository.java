package org.example.sqllab2.repository;

import org.example.sqllab2.model.Place;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends ListCrudRepository<Place, Long> {
    List<Place> findByIsPublicTrue();
    List<Place> findByCategoryIdAndIsPublicTrue(Long categoryId);
    List<Place> findByUserId(String userId);

    @Query("SELECT p FROM Place p WHERE ST_Distance_Sphere(p.coordinates, ST_GeomFromText(:point, 4326)) <= :radius AND p.isPublic = true")
    List<Place> findPublicPlacesWithinRadius(@Param("point") String point, @Param("radius") double radius);

    @Query("SELECT p FROM Place p WHERE ST_Distance_Sphere(p.coordinates, ST_GeomFromText(:point, 4326)) <= :radius AND (p.isPublic = true OR p.userId = :userId)")
    List<Place> findPlacesWithinRadiusForUser(@Param("point") String point, @Param("radius") double radius, @Param("userId") String userId);

    @Query("SELECT p FROM Place p WHERE p.isPublic = true OR p.userId = :userId")
    List<Place> findByIsPublicTrueOrUserId(@Param("userId") String userId);
}