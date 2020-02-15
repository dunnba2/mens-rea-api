package com.revature.repos;

import com.revature.models.Favorite;
import com.revature.models.Media;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class FavoriteRepository implements CrudRepository<Media> {

    private SessionFactory sessionFactory;

    public List<Media> findAllByUserId(User currentUser) {
        List<Media> favList = new ArrayList<>();
        try(Session session = sessionFactory.getCurrentSession().getSession()){
            favList = session.createQuery("from favorites fav where fav.userId = :user", Favorite.class)
                    .setParameter("user", currentUser.getUserId()).getResultList();
        } catch (Exception e){
            e.printStackTrace();
        }
        return favList;
    }

    public void delete(Media newObj){
        try(Session session = sessionFactory.getCurrentSession().getSession()){
            session.delete(newObj);
        }
    }

    public void deleteAll(List<Media> newObj){
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
    public List<Media> findAll() {
        List<Media> medias = new ArrayList<>();

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
