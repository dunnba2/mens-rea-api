package com.revature.repos;

import com.revature.models.Favorite;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FavoriteRepository implements CrudRepository<Favorite>{

    private SessionFactory factory;

    @Autowired
    public FavoriteRepository(SessionFactory sessionFactory) {
        super();
        this.factory = sessionFactory;
    }

    @Override
    public Favorite save(Favorite newObj) {

        Session session = factory.getCurrentSession();
        session.save(newObj);
        return newObj;
    }

    @Override
    public List<Favorite> findAll() {

        Session session = factory.getCurrentSession();
        List<Favorite> favorites = session.createQuery("from Favorites", Favorite.class).getResultList();
        return favorites;
    }

    @Override
    public Favorite findById(Integer id) {
        return null;
    }

    @Override
    public void update(Favorite updatedObj) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    public List<Favorite> findFavoritesById(int id) {
        List<Favorite> favorites = new ArrayList<>();
        Session session = factory.getCurrentSession();
        Query query = session.createQuery("from Favorites where userId = :id", Favorite.class);
        query.setParameter("id", id);
        favorites = query.getResultList();
        return favorites;
    }
}
