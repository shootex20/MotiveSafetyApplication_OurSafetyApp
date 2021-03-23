/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    public List<Logins> getAll() throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            List<Logins> login = em.createNamedQuery("Logins.findAll", Logins.class).getResultList();
            return login;

        } finally {
            em.close();
        }

    }

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
    
  /**  public int delete(Logins user) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.remove(user);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
            return 1;
        }
    }
**/
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

    public Logins get(Integer userID) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            Logins user = em.find(Logins.class, userID);
            return user;
        } finally {
            em.close();

        }
    }

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
