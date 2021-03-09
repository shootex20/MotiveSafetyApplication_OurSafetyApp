/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.CompanyDB;
import dataaccess.UserDB;
import domain.Company;
import domain.Logins;
import java.util.Date;
import java.util.List;

import javax.persistence.metamodel.SingularAttribute;

/**
 *
 * @author 844817
 */
public class CompanyService {
    
    
    
    private CompanyDB companyDB;
    
    
    public CompanyService() {
        companyDB = new CompanyDB();
    }
    
    
    
    public Company get(Integer id) throws Exception  {
    return companyDB.get(id);
    }
    
    
     public List<Company> getAll() throws Exception {
        return companyDB.getAll();
    }
     
       
     public int insert(Date dateAdded, String name, String shortname, String description, String account,  String industry) throws Exception {
         Company comp = new Company ( dateAdded, name, shortname, description, account, industry);
         return companyDB.insert(comp);
    }
     
     
    
    
     public int delete(Integer id) throws Exception {
        Company comp = companyDB.get(id);
        companyDB.delete(comp);  
        return companyDB.delete(comp);
    }

    private Company get(SingularAttribute<Company, Integer> companyID) {
        return companyDB.get(companyID);
    }
    
    
}
