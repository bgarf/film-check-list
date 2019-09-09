package com.projects.films.controller;

import com.projects.films.data.FilmRepository;
import com.projects.films.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
public class FilmController {

    private final FilmRepository filmRepository;

    @Autowired
    public FilmController(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @GetMapping(value = "/", produces = "application/json")
    public List<Film> listFilms() {
        return filmRepository.findAll();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Optional<Film> findById(@PathVariable String id) {
        return filmRepository.findById(id);
    }

    @GetMapping(value = "/{title}", produces = "application/json")
    public Film findByTitle(@PathVariable String title) {
        return filmRepository.findByTitle(title);
    }

    @PostMapping(value = "/")
    public Film saveFilm(@RequestBody Film film) {
//        Optional<Film> existingFilm = filmRepository.findById(film.getId());
//        if(existingFilm.isPresent()) {
//          return HttpClientErrorException.BadRequest();
//        } else {
//            return filmRepository.save(film);
//        }
        return filmRepository.save(film);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteFilmById(@PathVariable String id) {
        filmRepository.deleteById(id);
    }

    @DeleteMapping(value = "/")
    public void deleteAllFilms() {
        filmRepository.deleteAll();
    }

    @PutMapping(value = "/{id}", produces = "application/json")
    public Film updateFilm(@PathVariable String id, @RequestBody Film film) {
        Optional<Film> existingFilm = filmRepository.findById(id);
        if (existingFilm.isPresent()) {
            film.setId(existingFilm.get().getId());
            return filmRepository.save(film);
        } else {
            return filmRepository.save(film);
        }
    }
}
