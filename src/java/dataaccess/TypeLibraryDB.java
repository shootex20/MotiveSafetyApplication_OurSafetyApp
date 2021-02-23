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
import domain.Typelibrary;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


/**
 *
 * @author 813017
 */
public class TypeLibraryDB {
    
        public Typelibrary get(int type_ID) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            Typelibrary type = em.find(Typelibrary.class, type_ID);
            return type;
        } finally { 
            em.close();
        }
    }

     public List<Typelibrary> getAll() throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            List<Typelibrary> comp = em.createNamedQuery("Typelibrary.findAll", Typelibrary.class).getResultList();
             return comp;
    
        } finally {
            em.close();
        }
        
    }
}
