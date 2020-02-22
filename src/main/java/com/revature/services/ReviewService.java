package com.revature.services;

import com.revature.exceptions.ResourceNotFoundException;
import com.revature.models.Media;
import com.revature.models.Review;
import com.revature.models.User;
import com.revature.repos.MediaRepository;
import com.revature.repos.ReviewRepository;
import com.revature.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewService {

    private ReviewRepository reviewRepo;
    private UserRepository userRepo;
    private MediaRepository mediaRepo;

    @Autowired
    public ReviewService(ReviewRepository repo, UserRepository userRepository, MediaRepository mediaRepository) {
        super();
        this.reviewRepo = repo;
        this.userRepo = userRepository;
        this.mediaRepo = mediaRepository;
    }

    @Transactional
    public List<Review> getAllReviewsById (int id) {
        try {
            List<Review> reviews = new ArrayList<>();
            Media media = mediaRepo.findById(id);
            reviews = media.getReviews();
            return reviews;
        }catch(Exception e) {
            throw new ResourceNotFoundException("There are no reviews for this media");
        }
    }

    @Transactional
    public Review saveReview(int userId, int mediaId, Review review) {
        User user = getUserById(userId);
        Media media = getMediaById(mediaId);
        user.addReview(review);
        media.addReview(review);
        return reviewRepo.save(review);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public User getUserById(int id) {
        return userRepo.findById(id);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Media getMediaById(int id) {
        return mediaRepo.findById(id);
    }
}
