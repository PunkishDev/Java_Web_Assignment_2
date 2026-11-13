package dev.punkish.movies.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity 
public class Movie {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is a required field")
    @Size(max = 100, message = "Title cannot exceed 100 characters")
    private String title;

    @NotBlank(message = "Director is a required field")
    private String director;

    @NotBlank(message = "Genre is a required field")
    private String genre;

    @Min(value = 1888, message = "Release year cannot be lower than 1888")
    @Max(value = 2030, message = "Release year cannot exceed 2030")
    private Integer releaseYear;

    @DecimalMin(value = "0.0", message = "Minimum rating is 0.0")
    @DecimalMax(value = "10.0", message = "Maximum rating is 10.0")
    private Double rating;

    @Positive(message = "Runtime minutes cannot be a negative value")
    private Integer runtimeMinutes;

    private Boolean available;

    //Constructors
    public Movie() {}

    //Getters
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getDirector() { return director; }
    public String getGenre() { return genre; }
    public Integer getReleaseYear() { return releaseYear; }
    public Double getRating() { return rating; }
    public Integer getRuntimeMinutes() { return runtimeMinutes; }
    public Boolean getAvailable() { return available; }

    //Setters
    public void setId(Long id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setDirector(String director) { this.director = director; }
    public void setGenre(String genre) { this.genre = genre; }
    public void setReleaseYear(Integer releaseYear) { this.releaseYear = releaseYear; }
    public void setRating(Double rating) { this.rating = rating; }
    public void setRuntimeMinutes(Integer runtimeMinutes) { this.runtimeMinutes = runtimeMinutes; }
    public void setAvailable(Boolean available) { this.available = available; }
}
