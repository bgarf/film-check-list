package com.projects.films.data;

import com.projects.films.model.Film;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends MongoRepository<Film, String> {
    Film findByTitle(String title);
}
