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


/**
 *
 * @author 813017
 */
public class ItemClassDB {
    
    /** NOT FINISHED NEEDS WORK **/
    /*
    public List<Item> getAll(String itemID) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        List<Item> itemList = null;
        try {
            Item items = em.find(Item.class, itemID);
            itemList.add(items);
            return items.;
        } finally {
            em.close();
        }
    }
    */

 
    public Item get(int id) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            Item item = em.find(Item.class, id);
            return item;
        } finally { 
            em.close();
        }
    }
}
