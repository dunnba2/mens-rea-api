package com.revature.repos;

import com.revature.models.Review;
import com.revature.util.HibernateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Optional;
import java.util.Set;

public class ReviewRepository implements CrudRepository<Review> {

    private static final Logger LOG = LogManager.getLogger(ReviewRepository.class);
    private static SessionFactory factory = HibernateUtil.getSessionFactory();

    @Override
    public Review save(Review newReview) {

        try (Session session = factory.getCurrentSession()) {

            session.beginTransaction();

            session.getTransaction().commit();

        }catch(Exception e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
        }
        return null;
    }

    @Override
    public Set<Review> findAll() {

        try (Session session = factory.getCurrentSession()) {

            session.beginTransaction();

            session.getTransaction().commit();

        }catch(Exception e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
        }
        return null;
    }

    @Override
    public Optional<Review> findById(Integer id) {

        try (Session session = factory.getCurrentSession()) {

            session.beginTransaction();

            session.getTransaction().commit();

        }catch(Exception e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public Boolean update(Review updatedObj) {

        try (Session session = factory.getCurrentSession()) {

            session.beginTransaction();

            session.getTransaction().commit();

        }catch(Exception e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
        }
        return null;
    }

    @Override
    public Boolean deleteById(Integer id) {

        try (Session session = factory.getCurrentSession()) {

            session.beginTransaction();

            session.getTransaction().commit();

        }catch(Exception e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
        }
        return null;
    }
}
