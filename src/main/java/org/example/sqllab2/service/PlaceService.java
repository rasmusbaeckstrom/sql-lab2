package org.example.sqllab2.service;

import org.example.sqllab2.dto.PlaceDTO;
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
import java.util.stream.Collectors;

@Service
public class PlaceService {
    @Autowired
    private PlaceRepository placeRepository;

    public List<PlaceDTO> getAllPublicPlaces() {
        return placeRepository.findByIsPublicTrue().stream()
                .map(PlaceDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public Optional<PlaceDTO> getPublicPlaceById(Long id) {
        return placeRepository.findById(id)
                .filter(Place::getIsPublic)
                .map(PlaceDTO::fromEntity);
    }

    public List<PlaceDTO> getPublicPlacesByCategory(Long categoryId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && !authentication.getName().equals("anonymousUser")) {
            String userId = authentication.getName();
            return placeRepository.findByCategoryIdAndIsPublicTrueOrUserId(categoryId, userId).stream()
                    .map(PlaceDTO::fromEntity)
                    .collect(Collectors.toList());
        } else {
            return placeRepository.findByCategoryIdAndIsPublicTrue(categoryId).stream()
                    .map(PlaceDTO::fromEntity)
                    .collect(Collectors.toList());
        }
    }

    public List<PlaceDTO> getUserPlaces(String userId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && authentication.getName().equals(userId)) {
            return placeRepository.findByUserId(userId).stream()
                    .map(PlaceDTO::fromEntity)
                    .collect(Collectors.toList());
        } else {
            throw new SecurityException("You are not authorized to access this resource");
        }
    }

    public List<PlaceDTO> getPlacesWithinRadius(double latitude, double longitude, double radius) {
        String point = String.format(Locale.US, "POINT(%f %f)", longitude, latitude);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && !authentication.getName().equals("anonymousUser")) {
            String username = authentication.getName();
            return placeRepository.findPlacesWithinRadiusForUser(point, radius, username).stream()
                    .map(PlaceDTO::fromEntity)
                    .collect(Collectors.toList());
        } else {
            return placeRepository.findPublicPlacesWithinRadius(point, radius).stream()
                    .map(PlaceDTO::fromEntity)
                    .collect(Collectors.toList());
        }
    }

    public List<PlaceDTO> getAllPlacesForUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && !authentication.getName().equals("anonymousUser")) {
            String username = authentication.getName();
            return placeRepository.findByIsPublicTrueOrUserId(username).stream()
                    .map(PlaceDTO::fromEntity)
                    .collect(Collectors.toList());
        } else {
            return placeRepository.findByIsPublicTrue().stream()
                    .map(PlaceDTO::fromEntity)
                    .collect(Collectors.toList());
        }
    }

    public PlaceDTO createPlace(PlaceDTO placeDTO) {
        if (placeDTO.id() != null && placeRepository.existsById(placeDTO.id())) {
            throw new IllegalArgumentException("Place with this ID already exists");
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && !authentication.getName().equals("anonymousUser")) {
            String userId = authentication.getName();
            Place place = placeDTO.toEntity();
            place.setUserId(userId);
            place.setCreatedAt(Instant.now());
            place.setLastModified(Instant.now());
            Place createdPlace = placeRepository.save(place);
            return PlaceDTO.fromEntity(createdPlace);
        } else {
            throw new SecurityException("You are not authorized to create a place");
        }
    }

    public PlaceDTO updatePlace(Long id, PlaceDTO placeDTO) {
        Place place = placeDTO.toEntity();
        place.setId(id);
        place.setLastModified(Instant.now());
        Place updatedPlace = placeRepository.save(place);
        return PlaceDTO.fromEntity(updatedPlace);
    }

    public void deletePlace(Long id) {
        placeRepository.deleteById(id);
    }
}