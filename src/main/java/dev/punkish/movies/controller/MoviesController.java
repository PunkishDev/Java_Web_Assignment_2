package dev.punkish.movies.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.punkish.movies.repository.MovieRepository;

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
}
