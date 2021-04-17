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
 * @author 813017
 */
public class ItemClassFieldsDB {
    
    /**
     *
     * @param id takes in id
     * @return Itemclassfields an item class field 
     * @throws Exception throws an exception
     */
    public Itemclassfields get(int id) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            Itemclassfields item = em.find(Itemclassfields.class, id);
            return item;
        } finally { 
            em.close();
        }
    }
    
    /**
     *
     * @return Itemclassfields list
     * @throws Exception throws an exception
     */
    public List<Itemclassfields> getAll() throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            List<Itemclassfields> item = em.createNamedQuery("Itemclassfields.findAll", Itemclassfields.class).getResultList();
             return item;
    
        } finally {
            em.close();
        }
    }
   
}
