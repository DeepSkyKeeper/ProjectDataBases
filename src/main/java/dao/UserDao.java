package dao;

import hyber.Session;

import models.User;
import org.hibernate.Transaction;

import java.util.List;

public class UserDao {
    public User findById(int id) {
        return Session.getSessionFactory().openSession().get(User.class, id);
    }

    public void save(User user) {
        var session = Session.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    public void update(User user) {
        var session = Session.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }

    public void delete(User user) {
        var session = Session.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }

    public List<User> findAll() {
        return (List<User>) Session.getSessionFactory().openSession().createQuery("From User").list();
    }
}
