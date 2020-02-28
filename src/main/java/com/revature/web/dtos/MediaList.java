package com.revature.web.dtos;

import com.revature.models.MediaTypes;

import java.util.Objects;

public class MediaList {

    private int id;
    private String title;
    private String creator;
    private String year;
    private String targetAudience;
    private int userRating;
    private MediaTypes type;

    public MediaList(int id, String title, String creator, String year, String targetAudience, int userRating, MediaTypes type) {
        this.id = id;
        this.title = title;
        this.creator = creator;
        this.year = year;
        this.targetAudience = targetAudience;
        this.userRating = userRating;
        this.type = type;
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
        MediaList mediaList = (MediaList) o;
        return id == mediaList.id &&
                userRating == mediaList.userRating &&
                Objects.equals(title, mediaList.title) &&
                Objects.equals(creator, mediaList.creator) &&
                Objects.equals(year, mediaList.year) &&
                Objects.equals(targetAudience, mediaList.targetAudience) &&
                type == mediaList.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, creator, year, targetAudience, userRating, type);
    }

    @Override
    public String toString() {
        return "MediaList{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", creator='" + creator + '\'' +
                ", year='" + year + '\'' +
                ", targetAudience='" + targetAudience + '\'' +
                ", userRating=" + userRating +
                ", type=" + type +
                '}';
    }
}
