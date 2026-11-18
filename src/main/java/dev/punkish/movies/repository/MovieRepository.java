package dev.punkish.movies.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.punkish.movies.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{}
