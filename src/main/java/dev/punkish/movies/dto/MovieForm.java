package dev.punkish.movies.dto;

import dev.punkish.movies.model.Movie;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class MovieForm {
    

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

    public MovieForm() {}

    //Creating new Movie
    public Movie toNewMovie() {
        return new Movie(
            title.trim(), 
            director.trim(), 
            genre.trim(), 
            releaseYear, 
            rating, 
            runtimeMinutes, 
            available
        );
    }

    //Editing an existing Movie
    public static MovieForm fromMovie(Movie movie) {
        MovieForm form = new MovieForm();
        form.setTitle(movie.getTitle());
        form.setDirector(movie.getDirector());
        form.setGenre(movie.getGenre());
        form.setReleaseYear(movie.getReleaseYear());
        form.setRating(movie.getRating());
        form.setRuntimeMinutes(movie.getRuntimeMinutes());
        form.setAvailable(movie.getAvailable());

        return form;
    }

    //Saving a Movie
    public void applyTo(Movie movie) {
        movie.setTitle(this.title.trim());
        movie.setDirector(this.director.trim());
        movie.setGenre(this.genre.trim());
        movie.setReleaseYear(this.releaseYear);
        movie.setRating(this.rating);
        movie.setRuntimeMinutes(this.runtimeMinutes);
        movie.setAvailable(this.available);
    }

    //Getters
    public String getTitle() { return title; }
    public String getDirector() { return director; }
    public String getGenre() { return genre; }
    public Integer getReleaseYear() { return releaseYear; }
    public Double getRating() { return rating; }
    public Integer getRuntimeMinutes() { return runtimeMinutes; }
    public Boolean getAvailable() { return available; }

    //Setters
    public void setTitle(String title) { this.title = title; }
    public void setDirector(String director) { this.director = director; }
    public void setGenre(String genre) { this.genre = genre; }
    public void setReleaseYear(Integer releaseYear) { this.releaseYear = releaseYear; }
    public void setRating(Double rating) { this.rating = rating; }
    public void setRuntimeMinutes(Integer runtimeMinutes) { this.runtimeMinutes = runtimeMinutes; }
    public void setAvailable(Boolean available) { this.available = available; }
}
