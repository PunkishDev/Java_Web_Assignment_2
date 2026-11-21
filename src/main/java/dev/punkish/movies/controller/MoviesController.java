package dev.punkish.movies.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.punkish.movies.dto.MovieForm;
import dev.punkish.movies.model.Movie;
import dev.punkish.movies.repository.MovieRepository;
import jakarta.validation.Valid;

@Controller 
@RequestMapping("/movies")
public class MoviesController {
    private MovieRepository movieRepo;

    public MoviesController(MovieRepository movieRepo) {
        this.movieRepo = movieRepo;
    }

    @GetMapping("")
    public String list(Model model) {
        model.addAttribute("movies", movieRepo.findAll());

        return "movies";
    }

    
    @PostMapping("")
    public String save(@Valid @ModelAttribute("movie") MovieForm movieForm, BindingResult result) {
        if (movieRepo.existsByTitleIgnoreCase(movieForm.getTitle())) {
            result.rejectValue("title", "duplicate", "A movie with this title already exists");
        }
        
        if (result.hasErrors()) {
            return "movie-form";
        }
        Movie movie = movieForm.toNewMovie();
        
        movieRepo.save(movie);
        
        return "redirect:/movies";
    }

    @GetMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        Optional<Movie> movie = movieRepo.findById(id);

        if (movie.isEmpty()) {
            return "redirect:/movies";

        }

        movieRepo.delete(movie.get());

        return "redirect:/movies";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("movie") MovieForm movieForm, BindingResult result) {
        if (movieRepo.existsByTitleIgnoreCaseAndIdNot(movieForm.getTitle(), id)) {
            result.rejectValue("title", "duplicate", "A secondary entry in the database exists with this title");
        }
        
        if (result.hasErrors()) {
            return "movie-form";
        }
        Optional<Movie> movie = movieRepo.findById(id);
        
        if (movie.isEmpty()) {
            return "redirect:/movies";
        }

        movieForm.applyTo(movie.get());

        movieRepo.save(movie.get());

        return "redirect:/movies";
    }

    @GetMapping("/new")
    public String add(Model model) {
        model.addAttribute("movie", new MovieForm());
        model.addAttribute("movieId", null);

        return "movie-form";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Optional<Movie> movie = movieRepo.findById(id);

        if (movie.isEmpty()) {
            return "redirect:/movies";
        }

        MovieForm form = MovieForm.fromMovie(movie.get());

        model.addAttribute("movie", form);
        model.addAttribute("movieId", movie.get().getId());

        return "movie-form";
    }
}
