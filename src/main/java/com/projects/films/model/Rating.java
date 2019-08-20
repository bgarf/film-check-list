package com.projects.films.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "rating")
public class Rating {

    @Id
    private String ratingId;

    private String title;
    private int guardian;
    private int littleWhiteLies;
    private int empire;

    public String getRatingId() {
        return ratingId;
    }

    public void setRatingId(String ratingId) {
        this.ratingId = ratingId;
    }

    public int getGuardian() {
        return guardian;
    }

    public void setGuardian(int guardian) {
        this.guardian = guardian;
    }

    public int getLittleWhiteLies() {
        return littleWhiteLies;
    }

    public void setLittleWhiteLies(int littleWhiteLies) {
        this.littleWhiteLies = littleWhiteLies;
    }

    public int getEmpire() {
        return empire;
    }

    public void setEmpire(int empire) {
        this.empire = empire;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
