package org.example.sqllab2.dto;

public record PlaceDTO(Long id, String name, String userId, Boolean isPublic, String description, double longitude, double latitude, CategoryDTO category) {
}