package com.revature.models.mediatypes;

import com.revature.models.Media;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("SHOW")
public class TvShow extends Media {

    public TvShow() {
        super();
    }

    public TvShow(String title, String creator, String year, String targetAudience, int userRating) {
        super(title, creator, year, targetAudience, userRating);
    }

    public TvShow(int id, String title, String creator, String year, String targetAudience, int userRating) {
        super(id, title, creator, year, targetAudience, userRating);
    }
}
