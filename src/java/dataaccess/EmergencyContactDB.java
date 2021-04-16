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
import domain.Emergencycontact;
import javax.persistence.Query;


/**
 *
 * @author Chelsey Coughlin
 */
public class EmergencyContactDB {
    
    /**
     *
     * @param compPerson
     * @return
     * @throws Exception
     */
    public Emergencycontact get(int compPerson) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            Emergencycontact add = em.find(Emergencycontact.class, compPerson);
            return add;
        } finally { 
            em.close();
        }
    }

    /**
     *
     * @param con
     * @throws Exception
     */
    public void update(Emergencycontact con) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.merge(con);
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
    public Emergencycontact insert(Emergencycontact add) throws Exception {
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
