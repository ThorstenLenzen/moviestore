package com.toto.moviestore.controllers;

import com.toto.moviestore.entities.MovieEntity;
import com.toto.moviestore.modelBuilders.MovieEntityBuilder;
import com.toto.moviestore.repositories.MovieRepository;
import com.toto.moviestore.serviceModel.NewMovie;
import com.toto.moviestore.serviceModel.UpdatedMovie;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/movies")
public class MovieController {

    private final MovieRepository repository;
    private final MovieEntityBuilder builder;

    public MovieController(MovieRepository repository, MovieEntityBuilder builder) {
        this.repository = repository;
        this.builder = builder;
    }

    @GetMapping
    public List<MovieEntity> getAllMovies() {
        return this.repository.findAll();
    }

    @GetMapping("{movieId}")
    public MovieEntity getMovieById(@PathVariable int movieId) {
        return this.repository.findById(movieId).get();
    }

    @PostMapping
    public void createMovie(@RequestBody NewMovie dto) {
        MovieEntity entity = this.builder.Create(dto);
        this.repository.save(entity);
    }

    @DeleteMapping ("{movieId}")
    public void deleteMovie(@PathVariable int movieId) {
        this.repository.deleteById(movieId);
    }

    @PutMapping ("{movieId}")
    public void updateMovie(@PathVariable int movieId, @RequestBody UpdatedMovie dto) {
        MovieEntity entity = this.repository.findById(movieId).get();
        this.builder.Update(entity, dto);
        this.repository.save(entity);
    }
}
