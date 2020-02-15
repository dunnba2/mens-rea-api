package com.revature.services;

import com.revature.models.Review;
import com.revature.repos.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReviewService {

    private ReviewRepository reviewRepo;

    @Autowired
    public ReviewService(ReviewRepository repo) {
        super();
        this.reviewRepo = repo;
    }

    @Transactional(readOnly = true)
    public List<Review> getAllReviewsById (int id) {
        return reviewRepo.findAllById(id);
    }

    @Transactional
    public Review saveReview(Review review) {
        return reviewRepo.save(review);
    }
}
