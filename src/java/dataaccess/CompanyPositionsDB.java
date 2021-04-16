/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import domain.Company;
import domain.Companyperson;
import domain.Companypositions;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


/**
 *
 * @author 813017, 844817
 */
public class CompanyPositionsDB {

    
    
    
    /**
     * Get a single company by their id.
     *
     * @param companyID The unique username.
     * @return A Company object if found, null otherwise.
     * @throws Exception
    
     */
    
    
    public Companypositions getAllCompanyPos(Company companyID ) throws Exception {
     EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            Companypositions comp = em.find(Companypositions.class, companyID);
            return comp;
        } finally {
            em.close();

        }
    }
    
    /**
     *
     * @param posID
     * @return
     * @throws Exception
     */
    public Companypositions getID(int posID) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            Companypositions add = em.find(Companypositions.class, posID);
            return add;
        } finally { 
            em.close();
        }
    }
    
    /**
     *
     * @param compPos
     * @return
     * @throws Exception
     */
    public Companypositions get(int compPos) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            Companypositions pos = em.find(Companypositions.class, compPos);
            return pos;
        } finally { 
            em.close();
        }
    }
    
    /**
     *
     * @return
     * @throws Exception
     */
    public List<Companypositions> getAll() throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            List<Companypositions> comp = em.createNamedQuery("Companypositions.findAll", Companypositions.class).getResultList();
             return comp;
    
        } finally {
            em.close();
        }
        
    }
     
    /**
     *
     * @param pos
     * @throws Exception
     */
    public void update(Companypositions pos) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.merge(pos);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
     
    /**
     *
     * @param add
     * @return
     * @throws Exception
     */
    public Companypositions insert(Companypositions add) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try {
            Companyperson person = add.getCompanyPersonID();
            person.getCompanypositionsList().add(add);
            trans.begin();
            em.persist(add);
            em.merge(person);
            trans.commit();
        }catch (Exception ex) {
            trans.rollback();
        }finally {
            em.close();
            return add;
        }
    }
  
}