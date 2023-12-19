package com.toto.moviestore.repositories;

import com.toto.moviestore.entities.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieEntity, Integer> {

}
