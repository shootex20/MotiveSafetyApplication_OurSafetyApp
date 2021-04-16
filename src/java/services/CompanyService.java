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

/**
 *
 * @author 844817
 */
public class CompanyService {
    
    
    
    private CompanyDB companyDB;
    
    /**
     *
     */
    public CompanyService() {
        companyDB = new CompanyDB();
    }
    
    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Company get(Integer id) throws Exception  {
    return companyDB.get(id);
    }
    
    /**
     *
     * @return
     * @throws Exception
     */
    public List<Company> getAll() throws Exception {
        return companyDB.getAll();
    }
     
    /**
     *
     * @param dateAdded
     * @param name
     * @param shortname
     * @param description
     * @param account
     * @param industry
     * @return
     * @throws Exception
     */
    public int insert(Date dateAdded, String name, String shortname, String description, String account,  String industry) throws Exception {
         Company comp = new Company ( dateAdded, name, shortname, description, account, industry);
         return companyDB.insert(comp);
    }
     
    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    public int delete(Integer id) throws Exception {
        Company comp = companyDB.get(id);
        companyDB.delete(comp);  
        return companyDB.delete(comp);
    }
     
    /**
     *
     * @param dateAdded
     * @param name
     * @param shortname
     * @param description
     * @param account
     * @param industry
     * @return
     * @throws Exception
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
     *
     * @param id
     * @param name
     * @param shortname
     * @param description
     * @param account
     * @param industry
     * @return
     * @throws Exception
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

    private Company get(SingularAttribute<Company, Integer> companyID) {
        return companyDB.get(companyID);
    }

    private Company getCompanyID(Integer id) throws Exception {
        return companyDB.get(id);
    }

   
}
