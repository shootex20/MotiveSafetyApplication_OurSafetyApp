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
import javax.persistence.Query;


/**
 *
 * @author Chelsey Coughlin
 */
public class ItemClassDB {

    /**
     *
     * @param id takes in id id
     * @return Itemclass return item class
     * @throws Exception throws an exception
     */
    public Itemclass get(int id) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            Itemclass item = em.find(Itemclass.class, id);
            return item;
        } finally { 
            em.close();
        }
    }
    
    /**
     *
     * @return Itemclass return item class list
     * @throws Exception throws an exception
     */
    public List<Itemclass> getAll() throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            List<Itemclass> item = em.createNamedQuery("Itemclass.findAll", Itemclass.class).getResultList();
             return item;
    
        } finally {
            em.close();
        }
         }
}
