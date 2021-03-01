/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.List;
import javax.persistence.EntityManager;
import domain.Companyperson;
import domain.Companypersonphone;


/**
 *
 * @author Chelsey Coughlin
 */
public class CompanyPersonPhoneDB {

        public List<Companypersonphone> getAll(Companyperson companyper_ID) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            Companyperson companyPer = em.find(Companyperson.class, companyper_ID.getCompanyPersonID());
            return companyPer.getCompanypersonphoneList();
        } finally {
            em.close();
        }
    }
        
}
