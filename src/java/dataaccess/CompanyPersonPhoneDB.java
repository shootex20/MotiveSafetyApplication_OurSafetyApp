/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.List;
import javax.persistence.EntityManager;
import domain.Companyperson;
import domain.Companypersonphone;
import javax.persistence.EntityTransaction;


/**
 *
 * @author Chelsey Coughlin
 */
public class CompanyPersonPhoneDB {

        public List<Companypersonphone> getAll(Companyperson companyper_ID) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            Companyperson companyPer = em.find(Companyperson.class, companyper_ID.getCompanyPersonID());
            return companyPer.getCompanypersonphoneList();
        } finally {
            em.close();
        }
    }
        
        public Companypersonphone get(Companyperson compPerson) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            Companypersonphone add = em.find(Companypersonphone.class, compPerson);
            return add;
        } finally { 
            em.close();
        }
    }
        
        public void update(Companypersonphone comp) throws Exception {
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
        
        public Companypersonphone insert(Companypersonphone add) throws Exception {
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
            return add;
        }
    }

    public void delete(Companypersonphone add) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();  
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.remove(add);
            trans.commit();
        } catch(Exception ex){
            trans.rollback();
        } finally {
            em.close();
        }
    }
}
