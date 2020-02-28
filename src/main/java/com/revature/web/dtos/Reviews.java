package com.revature.web.dtos;

import java.util.Objects;

public class Reviews {

    private int userId;
    private int mediaId;
    private String review;
    private boolean recommended;

    public Reviews(int userId, int mediaId, String review, boolean recommended) {
        this.userId = userId;
        this.mediaId = mediaId;
        this.review = review;
        this.recommended = recommended;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMediaId() {
        return mediaId;
    }

    public void setMediaId(int mediaId) {
        this.mediaId = mediaId;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public boolean isRecommended() {
        return recommended;
    }

    public void setRecommended(boolean recommended) {
        this.recommended = recommended;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reviews reviews = (Reviews) o;
        return userId == reviews.userId &&
                mediaId == reviews.mediaId &&
                recommended == reviews.recommended &&
                Objects.equals(review, reviews.review);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, mediaId, review, recommended);
    }

    @Override
    public String toString() {
        return "Reviews{" +
                "userId=" + userId +
                ", mediaId=" + mediaId +
                ", review='" + review + '\'' +
                ", recommended=" + recommended +
                '}';
    }
}
