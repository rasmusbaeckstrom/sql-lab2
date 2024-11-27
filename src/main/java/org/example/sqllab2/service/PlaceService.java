package org.example.sqllab2.service;

import org.example.sqllab2.model.Place;
import org.example.sqllab2.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

    public List<Place> getUserPlaces(String userId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && authentication.getName().equals(userId)) {
            return placeRepository.findByUserId(userId);
        } else {
            throw new SecurityException("You are not authorized to access this resource");
        }
    }

    public List<Place> getPlacesWithinRadius(double latitude, double longitude, double radius) {
        String point = String.format(Locale.US, "POINT(%f %f)", longitude, latitude);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && !authentication.getName().equals("anonymousUser")) {
            String username = authentication.getName();
            return placeRepository.findPlacesWithinRadiusForUser(point, radius, username);
        } else {
            return placeRepository.findPublicPlacesWithinRadius(point, radius);
        }
    }

    public List<Place> getAllPlacesForUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && !authentication.getName().equals("anonymousUser")) {
            String username = authentication.getName();
            return placeRepository.findByIsPublicTrueOrUserId(username);
        } else {
            return placeRepository.findByIsPublicTrue();
        }
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