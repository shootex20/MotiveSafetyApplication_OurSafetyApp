package dataaccess;

import domain.Logins;
import javax.persistence.EntityManager;

/**
 *
 * @author 844817
 */
public class UserDB {

    EntityManager em = DBUtil.getEmFactory().createEntityManager();

    /**
     * 
     * @param username
     * @return 
     */
    public Logins getUser(String username) {

        try {
            Logins user = em.createNamedQuery("Logins.getUser", Logins.class).setParameter("username", username).getSingleResult();
            return user;
        } finally {
            em.close();
        }
    }

    /**
     * 
     * @param companyID
     * @return 
     */
    public Logins get(int companyID) {

        try {
            Logins user = em.find(Logins.class, companyID);
            return user;
        } finally {
            em.close();
        }
    }

}
