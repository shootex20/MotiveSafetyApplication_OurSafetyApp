package services;

import dataaccess.UserDB;
import domain.Logins;

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
            /*
            if (ps.verifyPassword(password, user.getPassword())) {
                return user;
            }
             */
            if (password.equals(user.getPassword())) {
                return user;
            }

        } catch (Exception e) {
        }

        return null;
    }

}
