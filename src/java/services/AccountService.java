package services;

import dataaccess.UserDB;
import domain.Logins;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 844817
 */
public class AccountService {

    UserDB userDB = new UserDB();
    PasswordStorage ps = new PasswordStorage();

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
