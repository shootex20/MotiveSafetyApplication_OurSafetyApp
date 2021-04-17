package services;

import dataaccess.UserDB;
import domain.Logins;
import java.util.logging.Level;
import java.util.logging.Logger;

// TODO: Auto-generated Javadoc
/**
 * The service class that interacts with the database for the login process.
 *
 * @author Dan Quach
 */
public class AccountService {

    /** The user DB. */
    UserDB userDB = new UserDB();
    
    /** The ps. */
    PasswordStorage ps = new PasswordStorage();

    /**
     * Validates some inputs then compares the stored and input credentials.
     *
     * @param username the username input by the user
     * @param password the password input by the user
     * @return either a Logins user object or null
     */
    public Logins login(String username, String password) {

        try {
            Logins user = userDB.getUser(username);

            if ((password.equals(user.getPassword()) && user.getUsername().equals("admin")) || (password.equals(user.getPassword()) && user.getUsername().equals("manager2")) || (password.equals(user.getPassword()) && user.getUsername().equals("oursafetyapplication@gmail.com"))) {
                Logger.getLogger(AccountService.class.getName()).log(Level.INFO, "Successful login by {0}", username);
                return user;

            } else if (ps.verifyPassword(password, user.getPassword()) == true) {
                Logger.getLogger(AccountService.class.getName()).log(Level.INFO, "Successful login by {0}", username);
                return user;
            }
        } catch (Exception e) {
        }
        return null;
    }

}
