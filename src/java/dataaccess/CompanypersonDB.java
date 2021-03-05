/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import domain.Company;
import domain.Companyperson;


/**
 *
 * @author Chelsey Coughlin
 */
public class CompanypersonDB {
    
    public List<Companyperson> getAll(Company companyID) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            Company company = em.find(Company.class, companyID.getCompanyID());
            return company.getCompanypersonList();
        } finally {
            em.close();
        }
    }

    public Companyperson get(int person_ID) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            Companyperson compPer = em.find(Companyperson.class, person_ID);
            return compPer;
        } finally { 
            em.close();
        }
    }
    
    public void update(Companyperson comp) throws Exception {
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
    
            public void insert(Companyperson add) throws Exception {
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
        
        }
    }

    public void delete(Companyperson add) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();  
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.remove(em.merge(add));
            trans.commit();
        } catch(Exception ex){
            trans.rollback();
        } finally {
            em.close();
        }
    }
 
}
