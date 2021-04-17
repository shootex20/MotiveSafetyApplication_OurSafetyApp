/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import domain.Phone;


/**
 *
 * @author Chelsey Coughlin
 */
public class PhoneDB {
           
    /**
     *
     * @param phone_ID takes in phone id
     * @return Phone returns a phone
     * @throws Exception throws an exception
     */
    public Phone get(int phone_ID) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            Phone phone = em.find(Phone.class, phone_ID);
            return phone;
        } finally { 
            em.close();
        }
    }
    
    /**
     *
     * @param add takes in phone
     * @return Phone returns a phone
     * @throws Exception throws an exception
     */
    public Phone insert(Phone add) throws Exception {
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
     * @param phone takes in phone
     * @throws Exception throws an exception
     */
    public void update(Phone phone) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.merge(phone);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
        }
    }

    /**
     *
     * @param phone takes in phone
     * @throws Exception throws an exception
     */
    public void delete(Phone phone) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();  
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.remove(phone);
            trans.commit();
        } catch(Exception ex){
            trans.rollback();
        } finally {
            em.close();
        }
    }
}
