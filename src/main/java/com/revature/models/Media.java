package com.revature.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@SequenceGenerator(name="media_gen", sequenceName = "media_seq", allocationSize = 1)
public class Media {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "media_gen")
    private int mediaId;

    @NotNull
    @Column(nullable = false)
    private String title;

    @NotNull
    @Column(nullable = false)
    private String creator;

    @NotNull
    @Column(nullable = false)
    private String year;

    @Column
    private String targetAudience;

    @NotNull
    @Column(nullable = false)
    private int userRating;

    @Enumerated(EnumType.STRING)
    private MediaTypes type;

    public Media () {
        super();
    }

    public Media(int mediaId) {
        this.mediaId = mediaId;
    }

    public Media(String title, String creator, String year, String targetAudience, int userRating, MediaTypes type) {
        this.title = title;
        this.creator = creator;
        this.year = year;
        this.targetAudience = targetAudience;
        this.userRating = userRating;
        this.type = type;
    }

    public Media(int mediaId, String title, String creator, String year, String targetAudience, int userRating, MediaTypes type) {
        this.mediaId = mediaId;
        this.title = title;
        this.creator = creator;
        this.year = year;
        this.targetAudience = targetAudience;
        this.userRating = userRating;
        this.type = type;
    }

    public int getMediaId() {
        return mediaId;
    }

    public void setMediaId(int mediaId) {
        this.mediaId = mediaId;
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

    public MediaTypes getType() {
        return type;
    }

    public void setType(MediaTypes type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Media media = (Media) o;
        return mediaId == media.mediaId &&
                userRating == media.userRating &&
                Objects.equals(title, media.title) &&
                Objects.equals(creator, media.creator) &&
                Objects.equals(year, media.year) &&
                Objects.equals(targetAudience, media.targetAudience) &&
                type == media.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mediaId, title, creator, year, targetAudience, userRating, type);
    }

    @Override
    public String toString() {
        return "Media{" +
                "mediaId=" + mediaId +
                ", title='" + title + '\'' +
                ", creator='" + creator + '\'' +
                ", year='" + year + '\'' +
                ", targetAudience='" + targetAudience + '\'' +
                ", userRating=" + userRating +
                ", type=" + type +
                '}';
    }
}
