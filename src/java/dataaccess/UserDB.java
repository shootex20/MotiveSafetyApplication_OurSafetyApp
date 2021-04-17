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
     * @param username takes in username
     * @return Logins returns a login
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
     * @param companyID takes in company id
     * @return Logins returns a login
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
