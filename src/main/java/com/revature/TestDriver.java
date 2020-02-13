package com.revature;

import com.revature.models.Role;
import com.revature.util.HibernateUtil;
import org.hibernate.Session;

public class TestDriver {

    public static void main(String[] args) {

        addRole();
    }

    public static void addRole() {

        try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {

            session.beginTransaction();
            Role role1 = new Role("ADMIN");
            Role role2 = new Role("MEMBER");

/*<<<<<<< Updated upstream
            session.save(role1);
            session.save(role2);
=======


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
>>>>>>> Stashed changes*/

            session.getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
