package com.revature.repos;

import com.revature.dtos.Credentials;
import com.revature.models.User;
import com.revature.util.HibernateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;


public class UserRepository implements CrudRepository<User> {

    private static final Logger LOG = LogManager.getLogger(UserRepository.class);
    private static SessionFactory factory = HibernateUtil.getSessionFactory();

    @Override
    public User save(User newUser) {

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
    public List<User> findAll() {

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
    public Optional<User> findById(Integer id) {

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
    public Boolean update(User updatedObj) {

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
    public Optional<User> findByCredentials(Credentials c) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();

            session.getTransaction().commit();
        }
        catch(Exception e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
        }
        return Optional.empty();
    }
}
