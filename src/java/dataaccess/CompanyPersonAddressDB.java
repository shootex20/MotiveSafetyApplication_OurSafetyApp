/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import domain.Address;
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
    
    public CompanyPersonAddressDB()
    {
        
    }
    
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
        
    public Companypersonaddress getID(int address_ID) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            Companypersonaddress add = em.find(Companypersonaddress.class, address_ID);
            return add;
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
            Address address = add.getAddressID();
            address.getCompanypersonaddressList().add(add);
            trans.begin();
            em.persist(add);
            em.merge(address);
            trans.commit();
        }catch (Exception ex) {
            trans.rollback();
        }finally {
            em.close();
            return add;
        }
    }
        
        public void updatePerson (Companypersonaddress add) throws Exception
        {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
            try
            {
            Companyperson cperson = add.getCompanyPersonID();
            cperson.getCompanypersonaddressList().add(add);
            trans.begin();
            em.persist(add);
            em.merge(cperson);
            trans.commit();         
        }catch (Exception ex) {
            trans.rollback();
        }finally {
            em.close();
        }
        } 
  
}
