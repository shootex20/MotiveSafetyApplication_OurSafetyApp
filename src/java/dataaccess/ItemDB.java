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
public class ItemDB {
    
    /*WORK IN PROGRESS*/
        public List<Item> getAll(Company companyID) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            Company company = em.find(Company.class, companyID.getCompanyID());
            return company.getItemList();
        } finally {
            em.close();
        }
    }
   
    public Item get(int item_ID) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            Item item = em.find(Item.class, item_ID);
            return item;
        } finally { 
            em.close();
        }
    }
}
