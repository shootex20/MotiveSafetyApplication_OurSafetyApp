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
import domain.Emergencycontact;
import domain.Person;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;

/**
 *
 * @author Chelsey Coughlin
 */
public class PersonDB {

    /**
     *
     * @return Person list
     * @throws Exception throws an exception
     */
    public List<Person> getAll() throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            List<Person> person = em.createNamedQuery("Person.findAll", Person.class).getResultList();
            return person;

        } finally {
            em.close();
        }

    }

    /**
     *
     * @param firstName takes in first name
     * @param lastName takes in last name
     * @param dob takes in date of birth
     * @return Person returns person
     * @throws Exception throws an exception
     */
    public Person getWithFields(String firstName, String lastName, String dob) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            Person person = em.createNamedQuery("Person.findByFields", Person.class).setParameter("firstName", firstName).setParameter("lastName", lastName).setParameter("dateOfBirth", dob).getSingleResult();
            return person;
        } finally {
            em.close();
        }
    }

    /**
     *
     * @param person_ID takes in person id
     * @return Person returns person
     * @throws Exception throws an exception
     */
    public Person get(int person_ID) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            Person person = em.find(Person.class, person_ID);
            return person;
        } finally {
            em.close();
        }
    }

    /**
     *
     * @param comp takes in company person
     * @throws Exception throws an exception
     */
    public void update(Person comp) throws Exception {
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
     * @param add takes in a person
     * @return Person returns a person
     * @throws Exception throws an exception
     */
    public Person insert(Person add) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try {
            Emergencycontact contact = add.getEmergencyContactID();
            contact.getPersonList().add(add);
            trans.begin();
            em.persist(add);
            em.merge(contact);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
            return add;
        }
    }

}
