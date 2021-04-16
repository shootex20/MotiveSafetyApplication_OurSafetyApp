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
import domain.Company;
import domain.Companypersonaddress;
import javax.persistence.TypedQuery;


/**
 *
 * @author Chelsey Coughlin
 */
public class AddressDB {
    
    /**
     *
     * @param address_ID
     * @return
     * @throws Exception
     */
    public Address get(int address_ID) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            Address add = em.find(Address.class, address_ID);
            return add;
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
    public Address insert(Address add) throws Exception {
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

    /**
     *
     * @param address
     * @throws Exception
     */
    public void update(Address address) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.merge(address);
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
     * @throws Exception
     */
    public void delete(Address add) throws Exception {
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
