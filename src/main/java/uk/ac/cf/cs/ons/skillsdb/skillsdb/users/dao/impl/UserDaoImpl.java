package uk.ac.cf.cs.ons.skillsdb.skillsdb.users.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.dao.UserDao;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;




    public List<User> getUserDetails() {
        Criteria criteria = sessionFactory.openSession().createCriteria(User.class);
        return criteria.list();
    }

    public User findUserByUsername(String username) {
        User user = null;
        Criteria criteria = sessionFactory.openSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("username", username));
        List<User> entityList = criteria.list();
        if(!entityList.isEmpty()) {
            user = entityList.get(0);
        }
        return user;
    }



    public void saveUser(User user) {
/*
        user.setPassword(encoder.encode(user.getPassword()));
*/
        Session session = sessionFactory.openSession();
        session.save(user);

        EntityManagerFactory emf= Persistence.
                createEntityManagerFactory("jpa");
        EntityManager em=emf.createEntityManager();
        try{
            EntityTransaction entr=em.getTransaction();
            entr.begin();

            em.persist(user);
            entr.commit();
        }
        finally{
            em.close();
        }
    }

}




