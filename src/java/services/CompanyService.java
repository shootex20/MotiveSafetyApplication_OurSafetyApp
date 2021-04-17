/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import dataaccess.CompanyDB;
import dataaccess.UserDB;
import domain.Company;
import domain.Logins;
import java.util.Date;
import java.util.List;

import javax.persistence.metamodel.SingularAttribute;

// TODO: Auto-generated Javadoc
/**
 * The Class CompanyService.
 *
 * @author 844817
 */
public class CompanyService {
    
    
    
    /** The company DB. */
    private CompanyDB companyDB;
    
    /**
     * Instantiates a new company service.
     */
    public CompanyService() {
        companyDB = new CompanyDB();
    }
    
    /**
     * Gets the.
     *
     * @param id the id
     * @return the company
     * @throws Exception the exception
     */
    public Company get(Integer id) throws Exception  {
    return companyDB.get(id);
    }
    
    /**
     * Gets the all.
     *
     * @return the all
     * @throws Exception the exception
     */
    public List<Company> getAll() throws Exception {
        return companyDB.getAll();
    }
     
    /**
     * Insert.
     *
     * @param dateAdded the date added
     * @param name the name
     * @param shortname the shortname
     * @param description the description
     * @param account the account
     * @param industry the industry
     * @return the int
     * @throws Exception the exception
     */
    public int insert(Date dateAdded, String name, String shortname, String description, String account,  String industry) throws Exception {
         Company comp = new Company ( dateAdded, name, shortname, description, account, industry);
         return companyDB.insert(comp);
    }
     
    /**
     * Delete.
     *
     * @param id the id
     * @return the int
     * @throws Exception the exception
     */
    public int delete(Integer id) throws Exception {
        Company comp = companyDB.get(id);
        companyDB.delete(comp);  
        return companyDB.delete(comp);
    }
     
    /**
     * Update 2.
     *
     * @param dateAdded the date added
     * @param name the name
     * @param shortname the shortname
     * @param description the description
     * @param account the account
     * @param industry the industry
     * @return the int
     * @throws Exception the exception
     */
    public int update2( Date dateAdded, String name, String shortname, String description, String account,  String industry) throws Exception {
       // Company comp = getCompanyID(Id);
       Integer id = null;
        Company comp = getCompanyID(id);
        comp.getDateAdded();
       // comp.setDateAdded(dateAdded);
        comp.setName(name);
        comp.setShortname(shortname);
        comp.setDescription(description);
        comp.setAccount(account);
        comp.setIndustry(industry);
        return companyDB.update(comp);
       
    }

    /**
     * Update.
     *
     * @param id the id
     * @param name the name
     * @param shortname the shortname
     * @param description the description
     * @param account the account
     * @param industry the industry
     * @return the int
     * @throws Exception the exception
     */
    public int update( Integer id, String name, String shortname, String description, String account,  String industry) throws Exception {
        Company comp = getCompanyID(id);
       
        comp.setName(name);
        comp.setShortname(shortname);
        comp.setDescription(description);
        comp.setAccount(account);
        comp.setIndustry(industry);
        return companyDB.update(comp);
       
    }

    /**
     * Gets the.
     *
     * @param companyID the company ID
     * @return the company
     */
    private Company get(SingularAttribute<Company, Integer> companyID) {
        return companyDB.get(companyID);
    }

    /**
     * Gets the company ID.
     *
     * @param id the id
     * @return the company ID
     * @throws Exception the exception
     */
    private Company getCompanyID(Integer id) throws Exception {
        return companyDB.get(id);
    }

   
}
