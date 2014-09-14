package dao;


import model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.persistence.EntityManager;

@Repository //("userDAO")
public class UserDAOImpl implements UserDAO {



//    @Autowired
//    private SessionFactory sessionFactory;
//    @Override
//    public void persistUser(User user) {
//        sessionFactory.getCurrentSession().persist(user);
//    }
//
//    @Override
//    public User findUserById(int id) {
//        return (User) sessionFactory.getCurrentSession().get(User.class, id);
//    }
//
//    @Override
//    public void updateUser(User user) {
//        sessionFactory.getCurrentSession().update(user);
//
//    }
//    @Override
//    public void deleteUser(User user) {
//        sessionFactory.getCurrentSession().delete(user);
//    }

    @Autowired
    private EntityManager em;

    // @Transactional can be also placed on the service level
    @Override
    @Transactional
    public void persistUser(User user) {
        em.persist(user);
    }

    @Override
    public User findUserById(int id) {
        return em.find(User.class, id);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        em.merge(user);

    }

    @Override
    @Transactional
    public void deleteUser(User user) {
        em.remove(user);
    }
}
