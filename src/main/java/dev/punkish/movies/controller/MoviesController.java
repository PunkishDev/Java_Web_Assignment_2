package dev.punkish.movies.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @GetMapping("/new")
    public String add(Model model) {
        model.addAttribute("movie", new MovieForm());

        return "movie-form";
    }

    @PostMapping("/new")
    public String save(@Valid @ModelAttribute("movie") MovieForm movieForm, BindingResult result) {
        if (result.hasErrors()) {
            return "movie-form";
        }
        Movie movie = movieForm.toNewMovie();

        movieRepo.save(movie);

        return "redirect:/movies";
    }
}
