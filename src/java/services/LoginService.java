/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.CompanyDB;
import dataaccess.LoginDB;
import dataaccess.UserDB;
import domain.Company;
import domain.Logins;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 844817
 */
public class LoginService {

    private LoginDB loginDB;
    private CompanyDB companyDB;

    public LoginService() {
        loginDB = new LoginDB();
    }

    public Logins get(Integer userID) throws Exception {
        return loginDB.get(userID);
    }

    public List<Logins> getAll() throws Exception {
        return loginDB.getAll();
    }

    public int insert(Date dateAdded, String username, String password, Company companyID, Character isActive, Character isAdmin) throws Exception {
        Logins user = new Logins(dateAdded, username, password, companyID, isActive, isAdmin);
        return loginDB.insert(user);
    }

    public int delete(Integer userID) throws Exception {
        Logins user = loginDB.get(userID);
        loginDB.delete(user);
        return loginDB.delete(user);
    }

    public Company getCompanyID(int categoryID) throws Exception {
        return companyDB.get(categoryID);

    }

    public void updatePassword(String userName, String tempPassword) {

        UserDB udb = new UserDB();
        Logins user = udb.getUser(userName);

        try {
            String hash = PasswordStorage.createHash(tempPassword);
            user.setPassword(hash);
            loginDB.update(user);
        } catch (PasswordStorage.CannotPerformOperationException ex) {
        } catch (Exception ex) {
        }
    }

}
