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
import domain.Phone;
import javax.persistence.EntityTransaction;
import servlets.EmployeeServlet;


/**
 *
 * @author Chelsey Coughlin
 */
public class CompanyPersonPhoneDB {

    /**
     *
     * @param companyper_ID takes in company person id
     * @return Companypersonphone list
     * @throws Exception throws an exception
     */
    public List<Companypersonphone> getAll(int companyper_ID) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            Companyperson companyPer = em.find(Companyperson.class, companyper_ID);
            return companyPer.getCompanypersonphoneList();
        } finally {
            em.close();
        }
    }
        
    /**
     *
     * @param compPerson takes in company person.
     * @return Companypersonphone list
     * @throws Exception throws an exception
     */
    public Companypersonphone get(Companyperson compPerson) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
             return em.createNamedQuery("Companypersonphone.findBycompanyPerson_ID", Companypersonphone.class).setParameter("companyPerson_ID", compPerson).getSingleResult();
        } finally { 
            em.close();
        }
    }
        
    /**
     *
     * @param phoneID takes in phoneID
     * @return Companypersonphone returns company person phone
     * @throws Exception throws an exception.
     */
    public Companypersonphone getID(int phoneID) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            Companypersonphone add = em.find(Companypersonphone.class, phoneID);
            return add;
        } finally { 
            em.close();
        }
    }
      
    /**
     *
     * @param comp takes in Comapny person phone
     * @throws Exception throws an exception.
     */
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
        
    /**
     *
     * @param add takes in company person phone
     * @return Companypersonphone returns company person phone
     * @throws Exception throws an exception 
     */
    public Companypersonphone insert(Companypersonphone add) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try {
            Phone address = add.getPhoneID();
            address.getCompanypersonphoneList().add(add);
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
     * @param add takes in company person phone
     * @throws Exception throws an exception
     */
    public void updatePerson (Companypersonphone add) throws Exception
        {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
            try
            {
                Companyperson cPerson = add.getCompanyPersonID();
                cPerson.getCompanypersonphoneList().add(add);
                trans.begin();
                em.merge(cPerson);
                trans.commit();        
            }catch (Exception ex) {
                trans.rollback();
            }finally {
                em.close();
            }
        } 
        /*
        public void updatePhone (Companypersonphone add) throws Exception
        {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
            try
            {
            Phone ph = add.getPhoneID();
            ph.getCompanypersonphoneList().add(add);
            trans.begin();
            em.merge(ph);
            trans.commit();       
            }catch (Exception ex) {
                trans.rollback();
                return;
            }finally {
                em.close();
            }
        }
        */

    /**
     *
     * @param add takes in company person phone
     * @throws Exception throws an exception
     */
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
