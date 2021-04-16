/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import domain.Company;
import domain.Item;
import domain.Itemclassfields;
import domain.Logins;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import domain.Manual;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author 813033
 */
public class ManualDB {
    
/**
 * get manual by id
 * @param id manual id
 * @return manual
 * @throws Exception Exception
 */   
   public Manual get(int id) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            Manual manual = em.find(Manual.class, id);
            return manual;
        } finally { 
            em.close();
        }
    }
    
/**
 * get manuals
 * @return all the manual
 * @throws Exception Exception
 */        
    public List<Manual> getAll() throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            List<Manual> manual = em.createNamedQuery("Manual.findAll", Manual.class).getResultList();
             return manual;
    
        } finally {
            em.close();
        }
    }

/**
 * insert manual
 * @param manual manual
 * @throws Exception Exception
 */    
    public void insert(Manual manual) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.persist(manual);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
        }
    }

/**
 * delete manual form database
 * @param manual manual
 * @throws Exception 
 */    
    public void delete(Manual manual) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();  
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.remove(em.merge(manual));            
            trans.commit();
        } catch(Exception ex){
            trans.rollback();
        } finally {
            em.close();
        }
    }
 
/**
 * update manual from database
 * @param manual manual
 * @throws Exception  exception
 */    
    public void update(Manual manual) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.merge(manual);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
}
