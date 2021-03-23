/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.CompanyPersonPhoneDB;
import domain.Companyperson;
import domain.Companypersonphone;
import domain.Phone;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Chels
 */
public class CompanyPersonPhoneService {
    
        public Companypersonphone insert(Integer userAdded, Companyperson companyPersonID, Phone phoneID) throws Exception {
        CompanyPersonPhoneDB addDB = new CompanyPersonPhoneDB();
        
        Date dateAdded = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String tempDate = formatter.format(dateAdded);
        /*Formats the created date*/
        dateAdded = new SimpleDateFormat("yyyy-MM-dd").parse(tempDate);

        Companypersonphone add = new Companypersonphone(dateAdded, userAdded, companyPersonID, phoneID);
        addDB.insert(add);
        addDB.updatePerson(add);
//        addDB.updatePhone(add);
        return add;
    }
        
    
}
