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
import domain.Inventory;


/**
 *
 * @author 813017
 */
public class InventoryDB {
    
    
    public List<Inventory> getAll(Company companyID) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            Company company = em.find(Company.class, companyID.getCompanyID());
            return company.getInventoryList();
        } finally {
            em.close();
        }
    }
    /*CURRENTLY NOT IN USE*/
/* 
    public HomeItems get(int id) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            HomeItems note = em.find(HomeItems.class, id);
            // System.out.println("first name: " + note.getOwner().getFirstName());
            // get all notes of the same owner as that note
            // List<Note> notes = note.getOwner().getNoteList();
            return note;
        } finally { 
            em.close();
        }
    }

    public void insert(HomeItems hi) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            Users user = hi.getOwner();
            user.getHomeItemsList().add(hi);
            trans.begin();
            em.persist(hi);
            em.merge(user);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public void update(HomeItems hi) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.merge(hi);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public void delete(HomeItems hi) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            Users user = hi.getOwner();
            user.getHomeItemsList().remove(hi);
            trans.begin();
            em.remove(em.merge(hi));
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
