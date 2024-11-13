package org.example.sqllab2.controller;

import org.example.sqllab2.model.Place;
import org.example.sqllab2.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/places")
public class PlaceController {
    @Autowired
    private PlaceService placeService;

    @GetMapping
    public List<Place> getAllPublicPlaces() {
        return placeService.getAllPublicPlaces();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Place> getPublicPlaceById(@PathVariable Long id) {
        return placeService.getPublicPlaceById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/category/{categoryId}")
    public List<Place> getPublicPlacesByCategory(@PathVariable Long categoryId) {
        return placeService.getPublicPlacesByCategory(categoryId);
    }

    @GetMapping("/user/{userId}")
    public List<Place> getUserPlaces(@PathVariable Long userId) {
        return placeService.getUserPlaces(userId);
    }

    @PostMapping
    public ResponseEntity<Place> createPlace(@RequestBody Place place) {
        return ResponseEntity.ok(placeService.createPlace(place));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Place> updatePlace(@PathVariable Long id, @RequestBody Place place) {
        place.setId(id);
        return ResponseEntity.ok(placeService.updatePlace(place));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlace(@PathVariable Long id) {
        placeService.deletePlace(id);
        return ResponseEntity.noContent().build();
    }
}