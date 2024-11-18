package org.example.sqllab2.converter;

import org.example.sqllab2.dto.CategoryDTO;
import org.example.sqllab2.dto.PlaceDTO;
import org.example.sqllab2.model.Place;

public class PlaceConverter {

    public static PlaceDTO convertToDTO(Place place) {
        CategoryDTO categoryDTO = new CategoryDTO(
                place.getCategory().getId(),
                place.getCategory().getName(),
                place.getCategory().getSymbol(),
                place.getCategory().getDescription()
        );
        return new PlaceDTO(
                place.getId(),
                place.getName(),
                place.getUserId(),
                place.getIsPublic(),
                place.getDescription(),
                place.getCoordinates().getPosition().getCoordinate(0),
                place.getCoordinates().getPosition().getCoordinate(1),
                categoryDTO
        );
    }
}