/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import domain.Item;
import domain.Itemclass;
import domain.Itemclassfields;
import domain.Company;
import domain.Companyperson;
import domain.Person;
import javax.persistence.Query;


/**
 *
 * @author Chelsey Coughlin
 */
public class PersonDB {
    
     public List<Person> getAll() throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            List<Person> person = em.createNamedQuery("Person.findAll", Person.class).getResultList();
             return person;
    
        } finally {
            em.close();
        }
        
    }
     /*
   
    public Item get(int item_ID) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            Item item = em.find(Item.class, item_ID);
            return item;
        } finally { 
            em.close();
        }
    }
    
        public void insert(Item item) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            Company user = item.getCompanyID();
            user.getItemList().add(item);
            trans.begin();
            em.persist(item);
            em.merge(user);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public void update(Item item) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.merge(item);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public void delete(Item item) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            Company user = item.getCompanyID();
            user.getItemList().remove(item);
            trans.begin();
            em.remove(em.merge(item));
            em.merge(user);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
        }

    }
*/
}
