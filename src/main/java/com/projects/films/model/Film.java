package com.projects.films.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "film")
public class Film {

    @Id
    private String id;

    private String title;
    private String director;
    private int releaseYear;
    private boolean watched;

    public Film() {}

    public Film(String title, String director, int releaseYear, boolean watched) {
        this.title = title;
        this.director = director;
        this.releaseYear = releaseYear;
        this.watched = watched;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public boolean isWatched() {
        return watched;
    }

    public void setWatched(boolean watched) {
        this.watched = watched;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return title.equals(film.title) &&
                director.equals(film.director) &&
                releaseYear == film.releaseYear;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, director, releaseYear);
    }
}
