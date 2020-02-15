package com.revature.repos;

import com.revature.models.Media;
import com.revature.models.User;
import com.revature.util.HibernateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.*;

public class MediaRepository implements CrudRepository<Media> {

    private static final Logger LOG = LogManager.getLogger(MediaRepository.class);
    private static SessionFactory factory = HibernateUtil.getSessionFactory();

    @Override
    public Media save(Media newMedia) {

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
    public List<Media> findAll() {

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
    public Optional<Media> findById(Integer id) {

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
    public Boolean update(Media updatedObj) {

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

    public List<Media> findFavorites(User user) {
        List<Media> favorites = new ArrayList<>();
        Session session = factory.getCurrentSession();
        favorites = session.createQuery("from Favorites f where f.userid = :userid", Media.class)
                .setParameter("userid", user.getUserId()).getResultList();
        return favorites;
    }

    public List<Media> findWatchlist(User user) {
        List<Media> watchList = new ArrayList<>();
        Session session = factory.getCurrentSession();
        watchList = session.createQuery("from WATCHLIST w where w.userid = :userid", Media.class)
                .setParameter("userid", user.getUserId()).getResultList();
        return watchList;
    }
}
