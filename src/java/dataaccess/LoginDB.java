package dataaccess;

import domain.Logins;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author 809968
 */
public class LoginDB {

    /**
     *
     * @return Logins list
     * @throws Exception throws an exception
     */
    public List<Logins> getAll() throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            List<Logins> login = em.createNamedQuery("Logins.findAll", Logins.class).getResultList();
            return login;

        } finally {
            em.close();
        }

    }

    /**
     * 
     * @param user takes in user
     */
    public void delete(Logins user) {
       EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
        trans.begin();
        em.merge(user);
        trans.commit();
        } catch (Exception ex) {
        trans.rollback();
        } finally {
        em.close();
        }
        
       }

    /**
     * 
     * @param user takes in user
     * @return int for logins
     * @throws Exception throws an exception
     */
    public int insert(Logins user) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {

            trans.begin();
            em.persist(user);
            //em.merge(user);
            trans.commit();

        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
            return 1;
        }
    }

    /**
     * 
     * @param userID takes in user id
     * @return Logins returns logins object
     */
    public Logins get(Integer userID) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            Logins user = em.find(Logins.class, userID);
            return user;
        } finally {
            em.close();

        }
    }

    /**
     * 
     * @param user takes in user id
     * @throws Exception throws an excpetion
     */
    public void update(Logins user) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try {
            trans.begin();
            em.merge(user);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
        }
    }

}
