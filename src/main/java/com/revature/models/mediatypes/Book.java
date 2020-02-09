package com.revature.models.mediatypes;

import com.revature.models.Media;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("BOOK")
public class Book extends Media {

    public Book() {
        super();
    }

    public Book(String title, String creator, String year, String targetAudience, int userRating) {
        super(title, creator, year, targetAudience, userRating);
    }

    public Book(int id, String title, String creator, String year, String targetAudience, int userRating) {
        super(id, title, creator, year, targetAudience, userRating);
    }
}
