package com.revature.web.controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.revature.exceptions.ResourceNotFoundException;
import com.revature.models.Review;
import com.revature.services.ReviewService;
import com.revature.web.dtos.ErrorResponse;
import com.revature.web.dtos.Reviews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    private ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService service) {
        super();
        this.reviewService = service;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Reviews> getReviewsById (@PathVariable int id) {
        List<Review> reviews = reviewService.getAllReviewsById(id);
        List<Reviews> reviewsList = new ArrayList<>();
        reviews.forEach(r -> reviewsList.add(r.extractReviews()));
        return reviewsList;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Review saveNewReview(@RequestBody ObjectNode json) {
        int userId = json.get("userId").asInt();
        int mediaId = json.get("mediaId").asInt();
        Review review = new Review();
        review.setRecommended(json.get("recommended").asBoolean());
        review.setReview(json.get("review").asText());
        return reviewService.saveReview(userId, mediaId, review);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleResourceNotFoundException(ResourceNotFoundException e) {

        ErrorResponse err = new ErrorResponse();
        err.setMessage(e.getMessage());
        err.setTimestamp(System.currentTimeMillis());
        err.setStatus(404);
        return err;
    }
}
