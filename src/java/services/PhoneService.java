/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.CompanyPersonPhoneDB;
import dataaccess.PhoneDB;
import domain.Companyperson;
import domain.Companypersonphone;
import domain.Phone;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Chels
 */
public class PhoneService {
    
    
        public void update(int phoneID,  String phoneNumber, String phoneExt) throws Exception {
        PhoneDB addDB = new PhoneDB();
        Phone phone = addDB.get(phoneID);

        String[] phoneParts = phoneNumber.split("-");
        String countryCode = phoneParts[0];
        String areaCode = phoneParts[1];
        String localNum = phoneParts[2];
        String local = phoneParts[3];
            
        String fullLocal = localNum + "-" + local;
            
        phone.setCountryCode(countryCode);
        phone.setAreaCode(areaCode);
        phone.setLocalNumber(fullLocal);
        phone.setExtension(phoneExt);
        addDB.update(phone);
    }
        
        public Phone insert(Integer userAdded, String countryCode, String areaCode, String localNumber, String extension) throws Exception {
        PhoneDB addDB = new PhoneDB();
        
        Date dateAdded = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String tempDate = formatter.format(dateAdded);
        /*Formats the created date*/
        dateAdded = new SimpleDateFormat("yyyy-MM-dd").parse(tempDate);

        Phone add = new Phone(dateAdded, userAdded, countryCode, areaCode, localNumber, extension);
        addDB.insert(add);
        return add;
    }
}
