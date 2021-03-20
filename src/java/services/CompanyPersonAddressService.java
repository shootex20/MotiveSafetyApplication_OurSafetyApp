/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.CompanyPersonAddressDB;
import domain.Address;
import domain.Companyperson;
import domain.Companypersonaddress;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Chels
 */
public class CompanyPersonAddressService {
    
        public Companypersonaddress insert(Integer userAdded, Address addressID, Companyperson companyPersonID) throws Exception {
        CompanyPersonAddressDB addDB = new CompanyPersonAddressDB();
        
        Date dateAdded = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String tempDate = formatter.format(dateAdded);
        /*Formats the created date*/
        dateAdded = new SimpleDateFormat("yyyy-MM-dd").parse(tempDate);

        Companypersonaddress add = new Companypersonaddress(dateAdded, userAdded, addressID, companyPersonID);
        addDB.insert(add);
        return add;
    }
        public void link (int compAddressID, Address addressID, Companyperson companyPersonID) throws Exception {
        CompanyPersonAddressDB addDB = new CompanyPersonAddressDB();
        Companypersonaddress addEdit = addDB.getID(compAddressID);
        addEdit.setCompanyPersonID(companyPersonID);
        addEdit.setAddressID(addressID);

        addDB.update(addEdit);
    }
}
