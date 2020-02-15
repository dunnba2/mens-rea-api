package com.revature.repos;

import com.revature.models.Media;
import com.revature.models.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ReviewRepository implements CrudRepository<Review> {

    private SessionFactory factory;

    @Autowired
    public ReviewRepository(SessionFactory factory) {
        super();
        this.factory = factory;
    }

    @Override
    public Review save(Review newReview) {

        Session session = factory.getCurrentSession();
        session.save(newReview);
        return newReview;
    }

    @Override
    public List<Review> findAll() {

        List<Review> reviews = new ArrayList<>();
        Session session = factory.getCurrentSession();
        session.createQuery("from Reviews", Review.class).getResultList();
        return reviews;
    }

    @Override
    public Review findById(Integer id) {

        Session session = factory.getCurrentSession();
        return session.get(Review.class, id);
    }

    @Override
    public void update(Review updatedObj) {

        Session session = factory.getCurrentSession();
        session.saveOrUpdate(updatedObj);
    }

    @Override
    public void deleteById(Integer id) {

    }

    public List<Review> findAllById(int id) {

        List<Review> reviews = new ArrayList<>();
        Session session = factory.getCurrentSession();
        session.createQuery("from Reviews r where r.mediaId = :mediaId", Review.class)
                .setParameter("mediaId", id)
                .getResultList();
        return reviews;
    }
}
