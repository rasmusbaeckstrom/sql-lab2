package org.example.sqllab2.dto;

import org.example.sqllab2.model.Place;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.geolatte.geom.builder.DSL;
import org.geolatte.geom.crs.CoordinateReferenceSystem;
import org.geolatte.geom.crs.CrsId;
import org.geolatte.geom.crs.CrsRegistry;

public record PlaceDTO(Long id, String name, String userId, Boolean isPublic, String description, double longitude, double latitude, CategoryDTO category) {

    public static PlaceDTO fromEntity(Place place) {
        CategoryDTO categoryDTO = CategoryDTO.fromEntity(place.getCategory());
        return new PlaceDTO(
                place.getId(),
                place.getName(),
                place.getUserId(),
                place.getIsPublic(),
                place.getDescription(),
                place.getCoordinates().getPosition().getCoordinate(1),
                place.getCoordinates().getPosition().getCoordinate(0),
                categoryDTO
        );
    }

    public Place toEntity() {
        Place place = new Place();
        place.setId(this.id());
        place.setName(this.name());
        place.setUserId(this.userId());
        place.setIsPublic(this.isPublic());
        place.setDescription(this.description());
        place.setCategory(this.category().toEntity());
        CoordinateReferenceSystem<G2D> crs = (CoordinateReferenceSystem<G2D>) CrsRegistry.getCoordinateReferenceSystem(CrsId.parse("EPSG:4326"), null);
        Point<G2D> coordinates = DSL.point(crs, DSL.g(this.longitude(), this.latitude()));
        place.setCoordinates(coordinates);
        return place;
    }
}