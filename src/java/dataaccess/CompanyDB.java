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

import domain.Company;
import domain.Logins;


/**
 *
 * @author 813017, 844817
 */
public class CompanyDB {

    
    
    
    /**
     * Get a single company by their id.
     *
     * @param companyID The unique username.
     * @return A Company object if found, null otherwise.
     * @throws Exception
    
     */
    
    
    public Company get(Integer companyID ) throws Exception {
     EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            Company comp = em.find(Company.class, companyID);
            return comp;
        } finally {
            em.close();

        }
    }
    
    
    
     public List<Company> getAll() throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            List<Company> comp = em.createNamedQuery("Company.findAll", Company.class).getResultList();
             return comp;
    
        } finally {
            em.close();
        }
        
    }
  
    
    
public int insert(Company comp) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            
            trans.begin();
            em.persist(comp);
            //em.merge(user);
            trans.commit();
            
        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
            return 1;
        }
    }

public int update(Company comp) throws Exception {
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
           return 1;
        }
        
    }


public int delete(Company comp) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {

           trans.begin();
           em.remove(em.merge(comp));
           trans.commit();
           
        } catch (Exception ex) {
         trans.rollback();
         
        } finally {
             em.close();
             return 1;
        } 
       
    }





 /**
    public Company get(int id) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            Company comp = em.find(Company.class, id);
            return comp;
        } finally { 
            em.close();
        }
    }
    
    
        public List<Company> getAll(String name) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            Company comp = em.find(Company.class, name);
            return comp.getName();
        } finally {
            em.close();
        }
    }

    
    
     public void insert(Company comp) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            Logins user = comp.getUsername();
           // user.getNoteList().add(note);
            trans.begin();
            em.persist(comp);
            em.merge(user);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
    
    
    
      public void update(Company comp) throws Exception {
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
     
      
         public void delete(Company comp) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            //User user = note.getOwner();
            //user.getNoteList().remove(note);
            trans.begin();
            em.remove(em.merge(comp));
           // em.merge(user);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
     **/
}
