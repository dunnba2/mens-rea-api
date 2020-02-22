package com.revature.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "REVIEWS")
@SequenceGenerator(name="review_gen", sequenceName = "review_seq", allocationSize = 1)
public class Review implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "review_gen")
    private int id;

    @JsonManagedReference
    @JoinColumn(name = "user_id", nullable = false)
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST})
    private User user;

    @JsonManagedReference
    @JoinColumn(name = "media_id", nullable = false)
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST})
    private Media media;

    @NotNull
    @Column(nullable = false)
    private boolean recommended;

    @NotNull
    @Column(nullable = false)
    private String review;

    public Review() {
        super();
    }

    public Review(@NotNull boolean recommended, @NotNull String review) {
        this.recommended = recommended;
        this.review = review;
    }

    public Review(User user, @NotNull boolean recommended, @NotNull String review) {
        this.user = user;
        this.recommended = recommended;
        this.review = review;
    }

    public Review(Media media, @NotNull boolean recommended, @NotNull String review) {
        this.media = media;
        this.recommended = recommended;
        this.review = review;
    }

    public Review(User user, Media media, boolean recommended, String review) {
        this.user = user;
        this.media = media;
        this.recommended = recommended;
        this.review = review;
    }

    public Review(int id, User user, Media media, @NotNull boolean recommended, @NotNull String review) {
        this.id = id;
        this.user = user;
        this.media = media;
        this.recommended = recommended;
        this.review = review;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public boolean isRecommended() {
        return recommended;
    }

    public void setRecommended(boolean recommended) {
        this.recommended = recommended;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review1 = (Review) o;
        return id == review1.id &&
                recommended == review1.recommended &&
                Objects.equals(user, review1.user) &&
                Objects.equals(media, review1.media) &&
                Objects.equals(review, review1.review);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, media, recommended, review);
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", user=" + user +
                ", media=" + media +
                ", recommended=" + recommended +
                ", review='" + review + '\'' +
                '}';
    }
}
