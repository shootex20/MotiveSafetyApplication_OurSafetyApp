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

import domain.Company;
import domain.Logins;
import javax.persistence.metamodel.SingularAttribute;

/**
 *
 * @author Chelsey, Azeb
 */
public class CompanyDB {

    /**
     * Get a single company by their id.
     *
     * @param companyID The unique username.
     * @return A Company object if found, null otherwise.
     * @throws Exception throws an exception
     *
     */
    public Company get(int companyID) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            Company comp = em.find(Company.class, companyID);
            return comp;
        } finally {
            em.close();

        }
    }

    /**
     *
     * @return Company list
     * @throws Exception throws an exception
     */
    public List<Company> getAll() throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            List<Company> comp = em.createNamedQuery("Company.findAll", Company.class).getResultList();
            return comp;

        } finally {
            em.close();
        }

    }

    /**
     *
     * @param comp company
     * @return Integer an integer
     * @throws Exception throws exception
     */
    public int insert(Company comp) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {

            trans.begin();
            em.persist(comp);
            trans.commit();

        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
            return 1;
        }
    }

    /**
     *
     * @param comp company
     * @return integer for update
     * @throws Exception throws an exception
     */
    public int update(Company comp) throws Exception {
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
            return 1;
        }

    }

    /**
     *
     * @param comp a company
     * @return integer for delete
     * @throws Exception throws an exception
     */
    public int delete(Company comp) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try {

            trans.begin();
            em.remove(em.merge(comp));
            trans.commit();

        } catch (Exception ex) {
            trans.rollback();

        } finally {
            em.close();
            return 1;
        }

    }

    /**
     *
     * @param companyID takes in company id
     * @return Company returns a company
     */
    public Company get(SingularAttribute<Company, Integer> companyID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param companyID takes in company id
     * @return Company returns a company
     */
    public Company get(Company companyID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
