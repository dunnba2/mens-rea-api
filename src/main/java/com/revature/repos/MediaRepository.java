package com.revature.repos;

import com.revature.models.Media;
import com.revature.util.HibernateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Optional;
import java.util.Set;

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
    public Set<Media> findAll() {

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
}
