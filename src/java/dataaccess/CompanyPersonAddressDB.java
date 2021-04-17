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
    
    /**
     *
     * @param companyper_ID takes in company person id
     * @return Companypersonaddress returns a company person address
     * @throws Exception throws an exception
     */
    public List<Companypersonaddress> getAll(int companyper_ID) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            Companyperson companyPer = em.find(Companyperson.class, companyper_ID);
            return companyPer.getCompanypersonaddressList();
        } finally {
            em.close();
        }
    }
    
    /**
     *
     * @param compPerson takes in company person
     * @return Companypersonaddress returns a company person address
     * @throws Exception throws an exception
     */
    public Companypersonaddress get(Companyperson compPerson) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
               return em.createNamedQuery("Companypersonaddress.findBycompanyPerson_ID", Companypersonaddress.class).setParameter("companyPerson_ID", compPerson).getSingleResult();
        } finally { 
            em.close();
        }
    }
        
    /**
     *
     * @param address_ID takes in address id
     * @return Companypersonaddress returns a companypersonaddress
     * @throws Exception throws an exception
     */
    public Companypersonaddress getID(int address_ID) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            Companypersonaddress add = em.find(Companypersonaddress.class, address_ID);
            return add;
        } finally { 
            em.close();
        }
    }
        
    /**
     *
     * @param comp takes in company person address
     * @throws Exception throws an exception
     */
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
    
    /**
     *
     * @param add takes in company person address
     * @return Companypersonaddress return company person address
     * @throws Exception throws an exception
     */
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
        
    /**
     *
     * @param add --takes in address
     * @throws Exception throws an exception
     */
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
