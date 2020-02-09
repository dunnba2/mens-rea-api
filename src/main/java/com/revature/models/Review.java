package com.revature.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "REVIEWS")
public class Review implements Serializable {

    @Id
    @JoinColumn(name = "user_id", nullable = false)
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST})
    private User userId;

    @Id
    @JoinColumn(name = "media_id", nullable = false)
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST})
    private Media mediaId;

    @Column(nullable = false)
    private boolean recommended;

    @Column(nullable = false)
    private String review;

    public Review() {
        super();
    }

    public Review(User userId, Media mediaId, boolean recommended, String review) {
        this.userId = userId;
        this.mediaId = mediaId;
        this.recommended = recommended;
        this.review = review;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Media getMediaId() {
        return mediaId;
    }

    public void setMediaId(Media mediaId) {
        this.mediaId = mediaId;
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
        return userId == review1.userId &&
                mediaId == review1.mediaId &&
                recommended == review1.recommended &&
                Objects.equals(review, review1.review);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, mediaId, recommended, review);
    }

    @Override
    public String toString() {
        return "Review{" +
                "userId=" + userId +
                ", mediaId=" + mediaId +
                ", userRating=" + recommended +
                ", review='" + review + '\'' +
                '}';
    }
}
