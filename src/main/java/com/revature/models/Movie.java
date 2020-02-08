package com.revature.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("MOVIE")
public class Movie extends Media {

    public Movie() {
        super();
    }

    public Movie(String title, String creator, String year, String targetAudience, int userRating) {
        super(title, creator, year, targetAudience, userRating);
    }

    public Movie(int id, String title, String creator, String year, String targetAudience, int userRating) {
        super(id, title, creator, year, targetAudience, userRating);
    }
}
