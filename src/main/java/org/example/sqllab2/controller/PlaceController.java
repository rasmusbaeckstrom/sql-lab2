package org.example.sqllab2.controller;

import org.example.sqllab2.dto.PlaceDTO;
import org.example.sqllab2.model.Place;
import org.example.sqllab2.service.PlaceService;
import org.example.sqllab2.converter.PlaceConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/places")
public class PlaceController {
    @Autowired
    private PlaceService placeService;

    @GetMapping
    public List<PlaceDTO> getAllPlacesForUser() {
        return placeService.getAllPlacesForUser().stream()
                .map(PlaceConverter::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlaceDTO> getPublicPlaceById(@PathVariable Long id) {
        return placeService.getPublicPlaceById(id)
                .map(place -> ResponseEntity.ok(PlaceConverter.convertToDTO(place)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/category/{categoryId}")
    public List<PlaceDTO> getPublicPlacesByCategory(@PathVariable Long categoryId) {
        return placeService.getPublicPlacesByCategory(categoryId).stream()
                .map(PlaceConverter::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/user/{userId}")
    @PreAuthorize("isAuthenticated()")
    public List<PlaceDTO> getUserPlaces(@PathVariable String userId) {
        return placeService.getUserPlaces(userId).stream()
                .map(PlaceConverter::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/radius")
    public List<PlaceDTO> getPlacesWithinRadius(@RequestParam double latitude, @RequestParam double longitude, @RequestParam double radius) {
        return placeService.getPlacesWithinRadius(latitude, longitude, radius).stream()
                .map(PlaceConverter::convertToDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<PlaceDTO> createPlace(@RequestBody Place place) {
        Place createdPlace = placeService.createPlace(place);
        return ResponseEntity.ok(PlaceConverter.convertToDTO(createdPlace));
    }

    @PutMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<PlaceDTO> updatePlace(@PathVariable Long id, @RequestBody Place place) {
        place.setId(id);
        Place updatedPlace = placeService.updatePlace(place);
        return ResponseEntity.ok(PlaceConverter.convertToDTO(updatedPlace));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Void> deletePlace(@PathVariable Long id) {
        placeService.deletePlace(id);
        return ResponseEntity.noContent().build();
    }
}