/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.UserDB;
import domain.Logins;

/**
 *
 * @author 844817
 */
public class AccountService {
    
    public Logins login(String email, String password) {
        UserDB userDB = new UserDB();
        
        try {
            Logins user = userDB.get(email);
            if (password.equals(user.getPassword())) {
                return user;
            }
        } catch (Exception e) {
        }
        
        return null;
    }
    
}
