package com.revature.repos;

import com.revature.models.Favorite;
import com.revature.models.Media;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class FavoriteRepository implements CrudRepository<Media> {

    private SessionFactory sessionFactory;

    public Set<Media> findAllByUserId(String user) {
        Set<Media> favList = new HashSet<>();
        try(Session session = sessionFactory.getCurrentSession().getSession()){
            return (Set<Media>) session.createQuery("from favorites where owner = :user", Favorite.class);
                    //.setParameter("user", )

        }
    }

    public void delete(Media newObj){
        try(Session session = sessionFactory.getCurrentSession().getSession()){
            session.delete(newObj);
        }
    }

    public void deleteAll(Set<Media> newObj){
        try(Session session = sessionFactory.getCurrentSession().getSession()){
            while(newObj != null){
                session.delete(newObj);
            }
        }
    }

/*    public Set<Media> sort(Media newObj){
        return null;
    }*/

    @Override
    public Media save(Media newObj) {

        try(Session session = sessionFactory.getCurrentSession().getSession()){
            return (Media) session.save(newObj);
        }
    }


    @Override
    public Set<Media> findAll() {
        Set<Media> medias = new HashSet<>();

        try(Session session = sessionFactory.getCurrentSession().getSession()){
            session.createQuery("from Media", Media.class);
        }
        return medias;
    }

    @Override
    public Optional<Media> findById(Integer id) {
        Optional<Media> _media = Optional.empty();

        try(Session session = sessionFactory.getCurrentSession().getSession()){
            session.createQuery("from Media where mediaId = :id", Media.class);
        }
        return _media;
    }

    @Override
    public Boolean update(Media updatedObj) {
        return null;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return null;
    }


}
