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

    EntityManager em = DBUtil.getEmFactory().createEntityManager();

    public Logins getUser(String username) {

        try {
            Logins user = em.createNamedQuery("Logins.getUser", Logins.class).setParameter("username", username).getSingleResult();
            return user;
        } finally {
            em.close();
        }
    }

    public Logins get(int companyID) {

        try {
            Logins user = em.find(Logins.class, companyID);
            return user;
        } finally {
            em.close();
        }
    }

}
