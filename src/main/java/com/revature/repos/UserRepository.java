package com.revature.repos;


import com.revature.exceptions.InvalidRequestException;
import com.revature.models.User;
import com.revature.web.dtos.Credentials;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements CrudRepository<User> {

    private SessionFactory factory;

    @Autowired
    public UserRepository(SessionFactory factory) {
        super();
        this.factory = factory;
    }

    @Override
    public User save(User newUser) throws ConstraintViolationException, DataIntegrityViolationException {

        try {
            Session session = factory.getCurrentSession();
            session.save(newUser);
        }catch (Exception e) {
            throw new InvalidRequestException("Sorry username is already taken.");
        }
        return newUser;
    }

    @Override
    public List<User> findAll() {

        List<User> users = new ArrayList<>();
        Session session = factory.getCurrentSession();
        session.createQuery("from User", User.class).getResultList();
        return users;
    }

    @Override
    public User findById(Integer id) {

        Session session = factory.getCurrentSession();
        return session.get(User.class, id);
    }

    @Override
    public void update(User updatedObj) {

        Session session = factory.getCurrentSession();
        session.saveOrUpdate(updatedObj);

    }

    @Override
    public void deleteById(Integer id) {

    }

    public User findByCredentials(Credentials creds) {

        Session session = factory.getCurrentSession();
        return session.createQuery("from User au where au.username = :un and au.password = :pw", User.class)
                .setParameter("un", creds.getUsername())
                .setParameter("pw", creds.getPassword())
                .getSingleResult();
    }
}
