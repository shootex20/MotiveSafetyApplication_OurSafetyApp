package services;

import dataaccess.LoginDB;
import dataaccess.UserDB;
import domain.Logins;
import java.util.HashMap;
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
            /*
            if (ps.verifyPassword(password, user.getPassword()) == true) {
            Logger.getLogger(AccountService.class.getName()).log(Level.INFO, "Successful login by {0}", username);
                return user;
            }
             */
            if (password.equals(user.getPassword())) {
                Logger.getLogger(AccountService.class.getName()).log(Level.INFO, "Successful login by {0}", username);
                
                String to = "oursafetyapplication@gmail.com";
                String subject = "TEST";
                
                EmailService.sendMail(to, subject, "testtesttest", false);
                
                return user;
            }
        } catch (Exception e) {
        }

        return null;
    }

    public String updatePassword(String userName) {
        LoginDB ldb = new LoginDB();
        Logins user = userDB.getUser(userName);
        String temp = ps.newRandomPassword();

        try {
            String hash = PasswordStorage.createHash(temp);
            user.setPassword(hash);
            ldb.update(user);
        } catch (PasswordStorage.CannotPerformOperationException ex) {
        } catch (Exception ex) {
        }
        return temp;
    }

}
