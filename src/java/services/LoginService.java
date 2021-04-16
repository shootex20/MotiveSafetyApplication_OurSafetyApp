package services;

import dataaccess.CompanyDB;
import dataaccess.LoginDB;
import dataaccess.UserDB;
import domain.Company;
import domain.Logins;
import java.util.Date;
import java.util.List;

/**
 * The service class to interact with the database for the Login user accounts 
 *
 * @author Dan Quach
 */
public class LoginService {

    private LoginDB loginDB;
    private CompanyDB companyDB;

    /**
     * No argument constructor
     */
    public LoginService() {
        loginDB = new LoginDB();
    }

    /**
     * Gets a user's account by the userID
     *
     * @param userID an integer that represents the unique id of an account
     * @return a Logins object representing a user account
     * @throws Exception if an error occurs when fetching data
     */
    public Logins get(Integer userID) throws Exception {
        return loginDB.get(userID);
    }

    /**
     * Gets every record of logins in the database
     *
     * @return a list of all Logins accounts
     * @throws Exception if an error occurs when fetching data
     */
    public List<Logins> getAll() throws Exception {
        return loginDB.getAll();
    }

    /**
     * Inserts a new Login account into the database
     *
     * @param dateAdded the day the account was created
     * @param username the new username
     * @param password the new password
     * @param companyID the companyID this account belongs to
     * @param isActive whether or not the account is active
     * @param isAdmin whether or not the account is an admin
     * @return a call to the loginDB to insert a User into the database
     * @throws Exception if an error occurs during the insert
     */
    public int insert(Date dateAdded, String username, String password, Company companyID, Character isActive, Character isAdmin) throws Exception {
        Logins user = new Logins(dateAdded, username, password, companyID, isActive, isAdmin);
        return loginDB.insert(user);
    }

    /**
     * Deletes a Login account
     *
     * @param userID the user's ID to identify the account
     * @param username the string username to remove
     * @throws Exception if an error occurs during deletion
     */
    public void delete(Logins userID, String username) throws Exception {
        Logins person = userID;
        person.setUsername(username);
        loginDB.delete(person);

    }

    /**
     * Gets a Company object by the categoryID
     *
     * @param categoryID the category of object
     * @return the retrieved Company object
     * @throws Exception if there was an error retrieving the result
     */
    public Company getCompanyID(int categoryID) throws Exception {
        return companyDB.get(categoryID);

    }

    /**
     * Updates a password in the database
     *
     * @param userName the account to edit
     * @param tempPassword the new string password to set as
     */
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
