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
import domain.Person;
import javax.persistence.TypedQuery;

/**
 *
 * @author Chelsey Coughlin
 */
public class CompanypersonDB {

    /**
     *
     * @param companyID takes in company id
     * @return Companyperson returns company person list.
     * @throws Exception throws an exception
     */
    public List<Companyperson> getAll(Company companyID) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        em.clear();
        try {
            Company company = em.find(Company.class, companyID.getCompanyID());
            return company.getCompanypersonList();
        } finally {
            em.close();
        }
    }

    /**
     *
     * @param person_ID takes in company id
     * @return Companyperson returns company person list.
     * @throws Exception throws an exception
     */
    public Companyperson get(int person_ID) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            Companyperson compPer = em.find(Companyperson.class, person_ID);
            return compPer;
        } finally {
            em.close();
        }
    }

    /**
     *
     * @param company_ID takes in company id
     * @param person_ID takes in company id
     * @param email takes in email
     * @return Companyperson returns company person
     */
    public Companyperson getByFields(int company_ID, int person_ID, String email) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            Companyperson compPer = em.createNamedQuery("Companyperson.findByFields", Companyperson.class).setParameter("company_ID", company_ID).setParameter("person_ID", person_ID).setParameter("email", email).getSingleResult();
            return compPer;
        } finally {
            em.close();
        }
    }

    /**
     *
     * @param comp takes in company person 
     * @throws Exception throws an exception
     */
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

    /**
     *
     * @param add takes in address
     * @return Companyperson returns company person
     * @throws Exception throws an exception
     */
    public Companyperson insert(Companyperson add) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try {
            Company comp = add.getCompanyID();
            comp.getCompanypersonList().add(add);
            trans.begin();
            em.persist(add);
            em.merge(comp);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
            return add;
        }
    }


    /*Does not work.*/
 /*
        public void delete(Companyperson person) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            Company user = person.getCompanyID();
            user.getCompanypersonList().remove(person);
            trans.begin();
            em.remove(em.merge(person));
            em.merge(user);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
     */
}
