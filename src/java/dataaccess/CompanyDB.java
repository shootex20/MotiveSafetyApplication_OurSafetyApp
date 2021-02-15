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


/**
 *
 * @author 813017
 */
public class CompanyDB {


 
    public Company get(int id) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            Company comp = em.find(Company.class, id);
            return comp;
        } finally { 
            em.close();
        }
    }
}
