package peaksoft.dao;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import peaksoft.model.User;
import peaksoft.util.Util;


import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        try (Session session =  Util.getSessionFactory().openSession()) {
            session.beginTransaction();
             session.getTransaction().commit();
                     System.out.println("User table created successfully");
        }

    }

    @Override
    public void dropUsersTable() {
        try (Session session = Util.getSessionFactory().openSession()) {
            session.beginTransaction();
            cleanUsersTable();

            session.getTransaction().commit();

            System.out.println("All students successfully deleted!");
        }


    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try (Session session = Util.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(new User(name, lastName,age));
            session.getTransaction().commit();
            System.out.println("User with name " + name +" added successfully ");
        }
    }

    @Override
    public void removeUserById(long id) {
        try (Session session = Util.getSessionFactory().openSession()) {
            session.beginTransaction();
            User user = session.get(User.class, id);
            System.out.println(user);
            if (user != null) {
                session.delete(user);
            }else {
                System.out.println("Not found id " + id);
            }
            session.getTransaction().commit();

            System.out.println("User with id: " + id + " successfully deleted!");
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> us = new ArrayList<>();
        try (Session session = Util.getSessionFactory().openSession()) {
            session.beginTransaction();
            List<User> user = session.createQuery("from User").getResultList();
            System.out.println(user);
            if (user != null) {
            System.out.println(user.size() + " user(s) have(has) been found!");
            return user;
            } else {
                System.out.println("Users is empty");
            }
            session.getTransaction().commit();
        } return us;
    }

    @Override
    public void cleanUsersTable() {
        try (Session session = Util.getSessionFactory().openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("delete from User");
            query.executeUpdate();
            session.getTransaction().commit();

            System.out.println("All users successfully deleted!");
        }
    }

}