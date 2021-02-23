/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import domain.Logins;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author 809968
 */
public class LoginDB {
       public List<Logins> getAll() throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            List<Logins> login = em.createNamedQuery("Logins.findAll", Logins.class).getResultList();
             return login;
    
        } finally {
            em.close();
        }
        
    }
}
