package com.revature.repos;

import com.revature.models.WatchList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class WatchlistRepository implements CrudRepository<WatchList>{

    private SessionFactory factory;

    @Autowired
    public WatchlistRepository(SessionFactory sessionFactory) {
        super();
        this.factory = sessionFactory;
    }

    @Override
    public WatchList save(WatchList newObj) {

        Session session = factory.getCurrentSession();
        session.save(newObj);
        return newObj;
    }

    @Override
    public List<WatchList> findAll() {
        return null;
    }

    @Override
    public WatchList findById(Integer id) {
        return null;
    }

    @Override
    public void update(WatchList updatedObj) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    public List<WatchList> findWatchlistById(int id) {
        System.out.println(id);
        List<WatchList> watchList = new ArrayList<>();
        Session session = factory.getCurrentSession();
        Query query = session.createQuery("from Watchlist w where w.userid = :userId", WatchList.class);
        query.setParameter("userId", id);
        System.out.println(id);
        watchList = query.getResultList();
        return watchList;
    }
}
