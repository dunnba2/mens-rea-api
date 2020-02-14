package com.revature.repos;

import com.revature.models.Favorite;

import com.revature.models.mediatypes.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class FavBookRepository implements CrudRepository<Book> {

    private SessionFactory sessionFactory;

    public Set<Book> findAllByUserId(String user) {
        Set<Book> favList = new HashSet<>();
        try(Session session = sessionFactory.getCurrentSession().getSession()){
            return (Set<Book>) session.createQuery("from favorites where owner = :user", Favorite.class);
            //.setParameter("user", )

        }
    }

    public void delete(Book newObj){
        try(Session session = sessionFactory.getCurrentSession().getSession()){
            session.delete(newObj);
        }
    }

    public void deleteAll(Set<Book> newObj){
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
    public Book save(Book newObj) {
        try(Session session = sessionFactory.getCurrentSession().getSession()){
            return (Book) session.save(newObj);
        }
    }

    @Override
    public Set<Book> findAll() {
        Set<Book> medias = new HashSet<>();

        try(Session session = sessionFactory.getCurrentSession().getSession()){
            session.createQuery("from Book", Book.class);
        }
        return medias;
    }

    @Override
    public Optional<Book> findById(Integer id) {
        Optional<Book> _media = Optional.empty();

        try(Session session = sessionFactory.getCurrentSession().getSession()){
            session.createQuery("from Book where mediaId = :id", Book.class);
        }
        return _media;
    }

    @Override
    public Boolean update(Book updatedObj) {
        return null;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return null;
    }
}

