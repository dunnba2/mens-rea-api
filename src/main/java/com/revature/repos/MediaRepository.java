package com.revature.repos;

import com.revature.models.Media;
import com.revature.models.MediaTypes;
import com.revature.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
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
        Query query = session.createQuery("from Media", Media.class);
        medias = query.getResultList();
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
        Query query = session.createQuery("from Favorites f where f.userid = :userid", Media.class);
        query.setParameter("userid", id);
        favorites = query.getResultList();
        return favorites;
    }

    public void saveToFavorites(User user, Media media) {
        Session session = factory.getCurrentSession();
        user = session.get(User.class, user.getUserId());
        media = session.get(Media.class, media.getMediaId());
        user.addFavorite(media);
        session.saveOrUpdate(media);
    }

    public List<Media> removeFromFavorites(User user, Media media){
        Session session = factory.getCurrentSession();
        user.removeFromFavorite(media);
        return findFavorites(user.getUserId());
    }

    public List<Media> findWatchlist(int id) {
        List<Media> watchList = new ArrayList<>();
        Session session = factory.getCurrentSession();
        Query query = session.createQuery("from WATCHLIST w where w.userid = :userid", Media.class);
        query.setParameter("userid", id);
        watchList = query.getResultList();
        return watchList;
    }

    public void saveToWatchlist(User user, Media media) {
        Session session = factory.getCurrentSession();
        user = session.get(User.class, user.getUserId());
        user.addToWatchlist(media);
        session.saveOrUpdate(media);
    }

    public List<Media> removeFromWatchList(User user, Media media){
        Session session = factory.getCurrentSession();
        user.removeFromFavorite(media);
        return findWatchlist(user.getUserId());
    }

    public List<Media> findAllByType (MediaTypes type) {
        List<Media> typeList = new ArrayList<>();
        Session session = factory.getCurrentSession();
        Query query = session.createQuery("from Media m where m.type = :type", Media.class);
        query.setParameter("type", type);
        typeList= query.getResultList();
        return typeList;
    }

    public List<Media> findAllByTypeAndSearch (String search, MediaTypes type) {
        List<Media> typeList = new ArrayList<>();
        Session session = factory.getCurrentSession();
        Query query = session.createQuery("from Media m where m.title like :search and m.type = :type");
        query.setParameter("search", search);
        query.setParameter("type", type);
        typeList = query.getResultList();
        return typeList;
    }

}
