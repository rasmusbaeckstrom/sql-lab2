package org.example.sqllab2.service;

import org.example.sqllab2.model.Place;
import org.example.sqllab2.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class PlaceService {
    @Autowired
    private PlaceRepository placeRepository;

    public List<Place> getAllPublicPlaces() {
        return placeRepository.findByIsPublicTrue();
    }

    public Optional<Place> getPublicPlaceById(Long id) {
        return placeRepository.findById(id).filter(Place::getIsPublic);
    }

    public List<Place> getPublicPlacesByCategory(Long categoryId) {
        return placeRepository.findByCategoryIdAndIsPublicTrue(categoryId);
    }

    public List<Place> getUserPlaces(Long userId) {
        return placeRepository.findByUserId(userId);
    }

    public List<Place> getPlacesWithinRadius(double latitude, double longitude, double radius) {
        String point = String.format(Locale.US, "POINT(%f %f)", longitude, latitude);
        return placeRepository.findPlacesWithinRadius(point, radius);
    }

    public Place createPlace(Place place) {
        place.setCreatedAt(Instant.now());
        place.setLastModified(Instant.now());
        return placeRepository.save(place);
    }

    public Place updatePlace(Place place) {
        place.setLastModified(Instant.now());
        return placeRepository.save(place);
    }

    public void deletePlace(Long id) {
        placeRepository.deleteById(id);
    }
}