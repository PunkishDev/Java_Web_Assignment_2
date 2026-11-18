package dev.punkish.movies.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity 
public class Movie {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String director;
    private String genre;
    private Integer releaseYear;
    private Double rating;
    private Integer runtimeMinutes;
    private Boolean available;

    //Constructors
    public Movie() {}
    public Movie(
        String title, 
        String director, 
        String genre, 
        Integer releaseYear, 
        Double rating, 
        Integer runtimeMinutes, 
        Boolean available
    ) {
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.runtimeMinutes = runtimeMinutes;
        this.available = available;
    }

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
