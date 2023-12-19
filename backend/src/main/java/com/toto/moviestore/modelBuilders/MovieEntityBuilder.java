package com.toto.moviestore.modelBuilders;

import com.toto.moviestore.entities.MovieEntity;
import com.toto.moviestore.serviceModel.NewMovie;
import com.toto.moviestore.serviceModel.UpdatedMovie;
import org.springframework.stereotype.Component;

@Component
public class MovieEntityBuilder {

    public MovieEntity Create(NewMovie movie) {
        MovieEntity entity = new MovieEntity();
        entity.setName(movie.name());
        entity.setDescription(movie.description());
        entity.setReleased(movie.released());

        return entity;
    }

    public void Update(MovieEntity entity, UpdatedMovie movie) {
        entity.setName(movie.name());
        entity.setDescription(movie.description());
        entity.setReleased(movie.released());
    }
}
