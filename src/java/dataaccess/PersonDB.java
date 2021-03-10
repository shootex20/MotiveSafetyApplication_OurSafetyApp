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
import java.util.logging.Level;
import java.util.logging.Logger;
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
     
         public Person get(int person_ID) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            Person person = em.find(Person.class, person_ID);
            return person;
        } finally { 
            em.close();
        }
    }
         
    public void update(Person comp) throws Exception {
            EntityManager em = DBUtil.getEmFactory().createEntityManager();
            EntityTransaction trans = em.getTransaction();
            try {
                trans.begin();
               em.merge(comp);
               trans.commit();

            } catch (Exception ex) {
                trans.rollback();
            } finally {
               em.close();
            }

        }
    
        public int insert(Person add) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try {
            trans.begin();
            em.persist(add);
            trans.commit();
        }catch (Exception ex) {
            trans.rollback();
        }finally {
            em.close();
            return add.getPersonID();
        }
    }
  
}
