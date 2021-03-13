/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.AddressDB;
import dataaccess.CompanyPersonAddressDB;
import domain.Address;
import domain.Companyperson;
import domain.Companypersonaddress;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Chels
 */
public class AddressService {
    
        public void update(int addressID, String addressLine1, String addressLine2, String addressCity, String addressProvince,String addressPostal, String addressCountry) throws Exception {
//        CompanyPersonAddressDB compAddDB = new CompanyPersonAddressDB();
//        /*Test*/
//        Companypersonaddress cpAddList = null;
//        cpAddList = compAddDB.get(personID);
        
        AddressDB addDB = new AddressDB();
        Address addEdit = addDB.get(addressID);
        //Address addEdit = new Address(addressID);

        addEdit.setAddressLine1(addressLine1);
        addEdit.setAddressLine2(addressLine2);
        addEdit.setCity(addressCity);
        addEdit.setProvince(addressProvince);
        addEdit.setPostalCode(addressPostal);
        addEdit.setCountry(addressCountry);
        addDB.update(addEdit);
    }
}


/*
       CompanyPersonPhoneDB compPhoneDB = new CompanyPersonPhoneDB();
        List<Companypersonphone> listPhone = new ArrayList<Companypersonphone>();
        listPhone = compPhoneDB.getAll(personID);
        
        PhoneDB addDB = new PhoneDB();
        Phone phoneToChange = addDB.get(phoneID);
        Phone phone = null;
        
        for(int i = 0; i < listPhone.size(); i++)
        {
            if (phoneToChange == listPhone.get(i).getPhoneID())
            {
                phone = listPhone.get(i).getPhoneID();
            }
        }
*/