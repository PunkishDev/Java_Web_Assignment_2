package dev.punkish.movies.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.punkish.movies.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{
    public Boolean existsByTitleIgnoreCase(String title);
    public List<Movie> findByGenre(String genre);
    public List<Movie> findByDirector(String director);
    public List<Movie> findByAvailable(Boolean available);
    public List<Movie> findByTitleContainingIgnoreCase(String title);
    public List<Movie> findByReleaseYearBetween(Integer earliest, Integer latest);
    public List<Movie> findByRatingGreaterThanEqual(Double rating);
    public List<Movie> findByGenreAndRatingGreaterThan(String genre, Double rating);
    public List<Movie> findByGenreOrderByRatingDesc(String genre);
    public List<Movie> findTop5ByOrderByRatingDesc();
    public List<Movie> findByRuntimeMinutesLessThan(Integer runtimeMinutes);
    public Long countByGenre(String genre);
    public Boolean existsByTitleIgnoreCaseAndIdNot(String title, Long id);
    public Optional<Movie> findTop1ByDirectorOrderByReleaseYearAsc(String director);
}
