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
    public ResponseEntity<List<PlaceDTO>> getAllPlacesForUser() {
        List<PlaceDTO> places = placeService.getAllPlacesForUser();
        return ResponseEntity.ok(places);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlaceDTO> getPublicPlaceById(@PathVariable Long id) {
        return placeService.getPublicPlaceById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<PlaceDTO>> getPublicPlacesByCategory(@PathVariable Long categoryId) {
        List<PlaceDTO> places = placeService.getPublicPlacesByCategory(categoryId);
        return ResponseEntity.ok(places);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<PlaceDTO>> getUserPlaces(@PathVariable String userId) {
        List<PlaceDTO> places = placeService.getUserPlaces(userId);
        return ResponseEntity.ok(places);
    }

    @GetMapping("/radius")
    public ResponseEntity<List<PlaceDTO>> getPlacesWithinRadius(@RequestParam double latitude, @RequestParam double longitude, @RequestParam double radius) {
        List<PlaceDTO> places = placeService.getPlacesWithinRadius(latitude, longitude, radius);
        return ResponseEntity.ok(places);
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