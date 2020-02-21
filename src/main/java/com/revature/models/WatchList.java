package com.revature.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="WATCHLIST")
public class WatchList implements Serializable {

    @Id
    @Column
    private int id;

    @NotNull
    @Column(nullable = false)
    private String title;

    @NotNull
    @Column(nullable = false)
    private String creator;

    @NotNull
    @Column(nullable = false)
    private String year;

    @Column(nullable = false)
    private String targetAudience;

    @NotNull
    @Column(nullable = false)
    private int userRating;

    @Enumerated(EnumType.STRING)
    private MediaTypes type;

    @Column(nullable = false)
//    @ManyToOne
    private int userId;


    public WatchList() {
        super();
    }

    public WatchList(@NotNull String title, @NotNull String creator, @NotNull String year, String targetAudience, @NotNull int userRating, MediaTypes type, int userId) {
        this.title = title;
        this.creator = creator;
        this.year = year;
        this.targetAudience = targetAudience;
        this.userRating = userRating;
        this.type = type;
        this.userId = userId;
    }

    public WatchList(int id, @NotNull String title, @NotNull String creator, @NotNull String year, String targetAudience, @NotNull int userRating, MediaTypes type, int userId) {
        this.id = id;
        this.title = title;
        this.creator = creator;
        this.year = year;
        this.targetAudience = targetAudience;
        this.userRating = userRating;
        this.type = type;
        this.userId = userId;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WatchList watchList = (WatchList) o;
        return id == watchList.id &&
                userRating == watchList.userRating &&
                userId == watchList.userId &&
                Objects.equals(title, watchList.title) &&
                Objects.equals(creator, watchList.creator) &&
                Objects.equals(year, watchList.year) &&
                Objects.equals(targetAudience, watchList.targetAudience) &&
                type == watchList.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, creator, year, targetAudience, userRating, type, userId);
    }

    @Override
    public String toString() {
        return "WatchList{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", creator='" + creator + '\'' +
                ", year='" + year + '\'' +
                ", targetAudience='" + targetAudience + '\'' +
                ", userRating=" + userRating +
                ", type=" + type +
                ", userId=" + userId +
                '}';
    }
}
