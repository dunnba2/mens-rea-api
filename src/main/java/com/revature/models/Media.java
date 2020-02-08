package com.revature.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="MEDIA_TYPE")
@SequenceGenerator(name="media_gen", sequenceName = "media_seq", allocationSize = 1)
public abstract class Media {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "media_gen")
    private int id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String creator;

    @Column(nullable = false)
    private String year;

    @Column
    private String targetAudience;

    @Column(nullable = false)
    private int userRating;

    public Media () {
        super();
    }

    public Media(String title, String creator, String year, String targetAudience, int userRating) {
        this.title = title;
        this.creator = creator;
        this.year = year;
        this.targetAudience = targetAudience;
        this.userRating = userRating;
    }

    public Media(int id, String title, String creator, String year, String targetAudience, int userRating) {
        this.id = id;
        this.title = title;
        this.creator = creator;
        this.year = year;
        this.targetAudience = targetAudience;
        this.userRating = userRating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public int getUserRating() {
        return userRating;
    }

    public void setUserRating(int userRating) {
        this.userRating = userRating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Media media = (Media) o;
        return id == media.id &&
                userRating == media.userRating &&
                Objects.equals(title, media.title) &&
                Objects.equals(creator, media.creator) &&
                Objects.equals(year, media.year) &&
                Objects.equals(targetAudience, media.targetAudience);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, creator, year, targetAudience, userRating);
    }

    @Override
    public String toString() {
        return "Media{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", creator='" + creator + '\'' +
                ", year='" + year + '\'' +
                ", targetAudience='" + targetAudience + '\'' +
                ", userRating=" + userRating +
                '}';
    }
}
