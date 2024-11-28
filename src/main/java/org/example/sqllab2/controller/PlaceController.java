package org.example.sqllab2.controller;

import org.example.sqllab2.dto.PlaceDTO;
import org.example.sqllab2.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/places")
public class PlaceController {
    @Autowired
    private PlaceService placeService;

    @GetMapping
    public List<PlaceDTO> getAllPlacesForUser() {
        return placeService.getAllPlacesForUser();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlaceDTO> getPublicPlaceById(@PathVariable Long id) {
        return placeService.getPublicPlaceById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/category/{categoryId}")
    public List<PlaceDTO> getPublicPlacesByCategory(@PathVariable Long categoryId) {
        return placeService.getPublicPlacesByCategory(categoryId);
    }

    @GetMapping("/user/{userId}")
    @PreAuthorize("isAuthenticated()")
    public List<PlaceDTO> getUserPlaces(@PathVariable String userId) {
        return placeService.getUserPlaces(userId);
    }

    @GetMapping("/radius")
    public List<PlaceDTO> getPlacesWithinRadius(@RequestParam double latitude, @RequestParam double longitude, @RequestParam double radius) {
        return placeService.getPlacesWithinRadius(latitude, longitude, radius);
    }

    @PostMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<PlaceDTO> createPlace(@RequestBody PlaceDTO placeDTO) {
        PlaceDTO createdPlace = placeService.createPlace(placeDTO);
        return ResponseEntity.created(URI.create("/api/places/" + createdPlace.id())).body(createdPlace);
    }

    @PutMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<PlaceDTO> updatePlace(@PathVariable Long id, @RequestBody PlaceDTO placeDTO) {
        PlaceDTO updatedPlace = placeService.updatePlace(id, placeDTO);
        return ResponseEntity.ok(updatedPlace);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Void> deletePlace(@PathVariable Long id) {
        placeService.deletePlace(id);
        return ResponseEntity.noContent().build();
    }
}