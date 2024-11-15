package org.example.sqllab2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "category", schema = "mydatabase")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 255)
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Size(max = 255)
    @Column(name = "symbol")
    private String symbol;

    @Lob
    @Column(name = "description")
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private Set<Place> places = new LinkedHashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @Size(max = 255) @NotNull String getName() {
        return name;
    }

    public void setName(@Size(max = 255) @NotNull String name) {
        this.name = name;
    }

    public @Size(max = 255) String getSymbol() {
        return symbol;
    }

    public void setSymbol(@Size(max = 255) String symbol) {
        this.symbol = symbol;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Place> getPlaces() {
        return places;
    }

    public void setPlaces(Set<Place> places) {
        this.places = places;
    }
}