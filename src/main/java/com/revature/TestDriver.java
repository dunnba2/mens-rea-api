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

            session.save(role1);
            session.save(role2);

            session.getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
