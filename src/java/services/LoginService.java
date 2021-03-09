/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.LoginDB;
import domain.Logins;
import java.util.List;

/**
 *
 * @author 844817
 */
public class LoginService {
      
    
       private LoginDB loginDB;
    
    public LoginService() {
        loginDB = new LoginDB();
    }
    
    
    
    public Logins get(Integer userID) throws Exception  {
    return loginDB.get(userID);
    }
    
    
     public List<Logins> getAll() throws Exception {
        return loginDB.getAll();
    }
     
}
