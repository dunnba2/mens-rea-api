package com.revature.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="FAVORITES")
public class Favorite implements Serializable {

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

    public Favorite() {
        super();
    }

    public Favorite(@NotNull String title, @NotNull String creator, @NotNull String year, String targetAudience, @NotNull int userRating, MediaTypes type, int userId) {
        this.title = title;
        this.creator = creator;
        this.year = year;
        this.targetAudience = targetAudience;
        this.userRating = userRating;
        this.type = type;
        this.userId = userId;
    }

    public Favorite(int id, @NotNull String title, @NotNull String creator, @NotNull String year, String targetAudience, @NotNull int userRating, MediaTypes type, @NotNull int userId) {
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
        Favorite favorite = (Favorite) o;
        return id == favorite.id &&
                userRating == favorite.userRating &&
                userId == favorite.userId &&
                Objects.equals(title, favorite.title) &&
                Objects.equals(creator, favorite.creator) &&
                Objects.equals(year, favorite.year) &&
                Objects.equals(targetAudience, favorite.targetAudience) &&
                type == favorite.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, creator, year, targetAudience, userRating, type, userId);
    }

    @Override
    public String toString() {
        return "Favorite{" +
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
