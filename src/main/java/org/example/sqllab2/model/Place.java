package org.example.sqllab2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "place", schema = "mydatabase")
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 255)
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @NotNull
    @Column(name = "user_id", nullable = false)
    private String userId;

    @ColumnDefault("1")
    @Column(name = "is_public")
    private Boolean isPublic;

    @Column(name = "last_modified")
    private Instant lastModified;

    @Lob
    @Column(name = "description")
    private String description;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "coordinates", columnDefinition = "geometry")
    private Point<G2D> coordinates;

    @ColumnDefault("false")
    @Column(name = "deleted", nullable = false)
    private Boolean deleted = false;

    public Long getId() { return id;}

    public void setId(Long id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getUserId() { return userId; }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Boolean getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
    }

    public Instant getLastModified() {
        return lastModified;
    }

    public void setLastModified(Instant lastModified) {
        this.lastModified = lastModified;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Point<G2D> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Point<G2D> coordinates) { this.coordinates = coordinates; }

    public Boolean getDeleted() { return deleted; }

    public void setDeleted(Boolean deleted) { this.deleted = deleted; }
}