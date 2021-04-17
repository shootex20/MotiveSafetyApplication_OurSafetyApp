/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import domain.Companynotes;
import java.sql.ResultSet;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;


/**
 *
 * @author Chelsey Coughlin
 */
public class CompanyNotesDB {
    
    /**
     *
     * @return Companynotes list
     * @throws Exception throws an exception
     */
    public List<Companynotes> getAll() throws Exception {
         EntityManager em = DBUtil.getEmFactory().createEntityManager();
          TypedQuery<Companynotes> query = em.createNamedQuery("Companynotes.findAll", Companynotes.class);
         List<Companynotes> results = query.getResultList();
            return results;
    }
   
    /**
     *
     * @param compNotesID takes in company notes id
     * @return Companynotes --returns a companynotes
     * @throws Exception throws an exception
     */
    public Companynotes get(int compNotesID) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            Companynotes add = em.find(Companynotes.class, compNotesID);
            return add;
        } finally { 
            em.close();
        }
    }

    /**
     *
     * @param note takes in Note
     * @throws Exception throws an exception
     */
    public void insert(Companynotes note) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try {       
            trans.begin();
            em.persist(note);
            trans.commit();
        }catch (Exception ex) {
            trans.rollback();
        }finally {
            em.close();
        }
    }

    /**
     *
     * @param note takes in Note
     * @throws Exception throws an exception
     */
    public void update(Companynotes note) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.merge(note);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
        }
    }

    /**
     *
     * @param note takes in Note
     * @throws Exception throws an exception
     */ 
    public void delete(Companynotes note) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();  
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.remove(em.merge(note));
            trans.commit();
        } catch(Exception ex){
            trans.rollback();
        } finally {
            em.close();
        }
    }
}
