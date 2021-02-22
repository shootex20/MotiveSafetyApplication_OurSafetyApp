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
     
     
     public int insert(int companyID, Date dateadded, String name, String shortname, String description, String account,  String industry) throws Exception {
         Company comp = new Company (companyID,dateadded, name, shortname, description, account, industry);
         return companyDB.insert(comp);
    }
     
     
    
    public int update(int companyID, Date dateadded, String name, String shortname, String description, String account,  String industry) throws Exception {
        Company comp = get(companyID);
        comp.setDateAdded(dateadded);
        comp.setName(name);
        comp.setShortname(shortname);
        comp.setDescription(description);
        comp.setAccount(account);
       comp.setIndustry(industry);
        return companyDB.update(comp);
    } 
    
     public int delete(Integer id) throws Exception {
        Company comp = companyDB.get(id);
        companyDB.delete(comp);  
        return companyDB.delete(comp);
    }
    
    
    /**
     public Company get(int id) throws Exception {
        CompanyDB companyDB = new CompanyDB();
        Company comp = companyDB.get(id);
        return comp;
    }
     
     
      public List<Company> getAll(String name) throws Exception {
        CompanyDB companyDB = new CompanyDB();
        List<Company> comps = companyDB.getAll(name);
        return comps;
    }
     
     

     public void insert(int companyID, Date dateadded, String name, String shortname, String description, String account,  String industry ) throws Exception {
        Company comp = new Company(0, dateadded, name, shortname, description, account, industry);
        //UserDB userDB = new UserDB();
        //Logins user = userDB.get(companyID);
       // comp.setCompanyID(user);
        CompanyDB companyDB = new CompanyDB();
        companyDB.insert(comp);
    }
     
      public void update(int companyID, Date dateadded, String name, String shortname, String description, String account,  String industry ) throws Exception {
        CompanyDB companyDB = new CompanyDB();
        Company comp = companyDB.get(companyID);
        comp.setName(name);
        comp.setShortname(shortname);
        comp.setDescription(description);
        comp.setAccount(account);
        comp.setIndustry(industry);
       
        companyDB.update(comp);
       
    }
    
    public void delete(int companyID, Date dateadded, String name, String shortname, String description, String account,  String industry ) throws Exception {
         CompanyDB companyDB = new CompanyDB();
         Company comp = companyDB.get(companyID);
         companyDB.delete(comp);
    }
     **/
     
}
