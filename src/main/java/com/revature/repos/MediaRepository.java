package com.revature.repos;

import com.revature.models.Media;
import com.revature.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MediaRepository implements CrudRepository<Media> {

    private SessionFactory factory;

    @Autowired
    public MediaRepository(SessionFactory factory) {
        super();
        this.factory = factory;
    }

    @Override
    public Media save(Media newMedia) {

        Session session = factory.getCurrentSession();
        session.save(newMedia);
        return newMedia;
    }

    @Override
    public List<Media> findAll() {

        List<Media> medias = new ArrayList<>();
        Session session = factory.getCurrentSession();
        session.createQuery("from Media", Media.class).getResultList();
        return medias;
    }

    @Override
    public Media findById(Integer id) {

        Session session = factory.getCurrentSession();
        return session.get(Media.class, id);
    }

    @Override
    public void update(Media updatedObj) {

        Session session = factory.getCurrentSession();
        session.saveOrUpdate(updatedObj);
    }

    @Override
    public void deleteById(Integer id) {

    }

    public List<Media> findFavorites(int id) {
        List<Media> favorites = new ArrayList<>();
        Session session = factory.getCurrentSession();
        favorites = session.createQuery("from Favorites f where f.userid = :userid", Media.class)
                .setParameter("userid", id).getResultList();
        return favorites;
    }

    public void saveToFavorites(User user, Media media) {
        Session session = factory.getCurrentSession();
        user.addFavorite(media);
        session.save(media);

    }

    public List<Media> findWatchlist(int id) {
        List<Media> watchList = new ArrayList<>();
        Session session = factory.getCurrentSession();
        watchList = session.createQuery("from WATCHLIST w where w.userid = :userid", Media.class)
                .setParameter("userid", id).getResultList();
        return watchList;
    }

    public void saveToWatchlist(User user, Media media) {
        Session session = factory.getCurrentSession();
        user.addToWatchlist(media);
        session.save(media);
    }

    public List<Media> findAllByType (String type) {
        List<Media> typeList = new ArrayList<>();
        Session session = factory.getCurrentSession();
        typeList = session.createQuery("from Media m where m.media_type = :type", Media.class)
                .setParameter("type", type)
                .getResultList();
        return typeList;
    }

    public List<Media> findAllByTypeAndSearch (String search, String type) {
        List<Media> typeList = new ArrayList<>();
        Session session = factory.getCurrentSession();
        typeList = session.createQuery("from Media m where m.title like :search and m.media_type = :type")
                .setParameter("search", search)
                .setParameter("type", type)
                .getResultList();
        return typeList;
    }

}
