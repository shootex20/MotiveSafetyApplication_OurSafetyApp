/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import domain.Logins;
import javax.persistence.EntityManager;

/**
 *
 * @author 844817
 */
public class UserDB {
     public Logins get(String email) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            Logins user = em.find(Logins.class, email);
            return user;
        } finally {
            em.close();
        }
    }
}
