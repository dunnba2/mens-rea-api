package com.revature.repos;

import com.revature.models.Media;
import com.revature.models.MediaTypes;
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
