package com.revature;

import com.revature.models.Role;
import com.revature.models.mediatypes.Movie;
import com.revature.util.HibernateUtil;
import org.hibernate.Session;

public class TestDriver {

    public static void main(String[] args) {

       // addRole();
        addMedia();
    }

    public static void addRole() {

        try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {

            session.beginTransaction();
            Role role1 = new Role("ADMIN");
            Role role2 = new Role("MEMBER");

            session.save(role1);
            session.save(role2);

            session.getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addMedia() {

        try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {

            session.beginTransaction();
            Movie m1 = new Movie("Who Framed Roger Rabbit?", "Robert Zemeckis", "1988", "PG", 0);
            Movie m2 = new Movie("Crooked House", "Giles Paquet-Brenner", "2017", "PG-13", 0);
            Movie m3 = new Movie("Murder on the Orient Express", "Kenneth Branagh", "2017", "PG-13", 0);
            Movie m4 = new Movie("Murder Mystery", "Kyle Newacheck", "2019", "PG-13", 0);
            Movie m5 = new Movie("Knives Out", "Rian Johnson", "2019", "PG-13", 0);
            Movie m6 = new Movie("Coco", "Lee Unkrich, Adrian Molina", "2017", "PG", 0);
            Movie m7 = new Movie("Basic Instinct", "Paul Verhoeven", "1992", "R", 0);
            Movie m8 = new Movie("Dick Tracy", "Warren Beatty", "1990", "PG", 0);
            Movie m9 = new Movie("Game Night", "John Francis Daley, Jonathan Goldstein", "2018", "R", 0);
            Movie m10 = new Movie("Eagle Eye", "D.J. Caruso", "2008", "PG-13", 0);
            Movie m11 = new Movie("Perfect Stranger", "James Foley", "2007", "R", 0);
            Movie m12 = new Movie("Minority Report", "Steven Spielberg", "2002", "PG-13", 0);
            Movie m13 = new Movie("Psycho", "Alfred Hitchcock", "1960", "R", 0);



/*            session.save(role1);
            session.save(role2);*/



            session.save(m1);
            session.save(m2);
            session.save(m3);
            session.save(m4);
            session.save(m5);
            session.save(m6);
            session.save(m7);
            session.save(m8);
            session.save(m9);
            session.save(m10);
            session.save(m11);
            session.save(m12);
            session.save(m13);


            session.getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
