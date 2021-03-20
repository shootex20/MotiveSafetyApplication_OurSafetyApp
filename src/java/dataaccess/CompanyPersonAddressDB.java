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
import domain.Companypersonaddress;
import javax.persistence.Query;


/**
 *
 * @author Chelsey Coughlin
 */
public class CompanyPersonAddressDB {
    
    public List<Companypersonaddress> getAll(int companyper_ID) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            Companyperson companyPer = em.find(Companyperson.class, companyper_ID);
            return companyPer.getCompanypersonaddressList();
        } finally {
            em.close();
        }
    }
    
        public Companypersonaddress get(Companyperson compPerson) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
               return em.createNamedQuery("Companypersonaddress.findBycompanyPerson_ID", Companypersonaddress.class).setParameter("companyPerson_ID", compPerson).getSingleResult();
        } finally { 
            em.close();
        }
    }
    
    public void update(Companypersonaddress comp) throws Exception {
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
    
        public Companypersonaddress insert(Companypersonaddress add) throws Exception {
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
        
  
}
