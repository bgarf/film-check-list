package com.projects.films.data;

import com.projects.films.model.Film;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends MongoRepository<Film, String> {
    List<Film> findByTitle(String title);
}
