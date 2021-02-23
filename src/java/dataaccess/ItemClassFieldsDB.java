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
    
    public Itemclassfields get(int id) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            Itemclassfields item = em.find(Itemclassfields.class, id);
            return item;
        } finally { 
            em.close();
        }
    }
    
        
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
