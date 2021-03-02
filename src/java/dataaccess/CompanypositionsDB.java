/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import domain.Company;
import domain.Companyperson;
import domain.Companypositions;
import java.util.List;
import javax.persistence.EntityManager;


/**
 *
 * @author 813017, 844817
 */
public class CompanypositionsDB {

    
    
    
    /**
     * Get a single company by their id.
     *
     * @param companyID The unique username.
     * @return A Company object if found, null otherwise.
     * @throws Exception
    
     */
    
    
    public Companypositions getAllCompanyPos(Company companyID ) throws Exception {
     EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            Companypositions comp = em.find(Companypositions.class, companyID);
            return comp;
        } finally {
            em.close();

        }
    }
    
    public Companypositions get(Companyperson personID ) throws Exception {
     EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            Companypositions comp = em.find(Companypositions.class, personID);
            return comp;
        } finally {
            em.close();

        }
    }
    
    
     public List<Companypositions> getAll() throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            List<Companypositions> comp = em.createNamedQuery("Companypositions.findAll", Companypositions.class).getResultList();
             return comp;
    
        } finally {
            em.close();
        }
        
    }
  
}
