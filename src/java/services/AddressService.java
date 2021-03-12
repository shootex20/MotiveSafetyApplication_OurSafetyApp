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
    
        public void update(Companyperson personID, String addressLine1, String addressLine2, String addressCity, String addressProvince,String addressPostal, String addressCountry) throws Exception {
        CompanyPersonAddressDB compAddDB = new CompanyPersonAddressDB();
        /*Test*/
        //List<Companypersonaddress> cpAddList = new ArrayList<Companypersonaddress>();
        //cpAddList = compAddDB.getAll(personID);
        Companypersonaddress cpAddEdit = compAddDB.get(personID);
        AddressDB addDB = new AddressDB();
        Address addEdit = cpAddEdit.getAddressID();
        addEdit.setAddressLine1(addressLine1);
        addEdit.setAddressLine2(addressLine2);
        addEdit.setCity(addressCity);
        addEdit.setProvince(addressProvince);
        addEdit.setPostalCode(addressPostal);
        addEdit.setCountry(addressCountry);
        addDB.update(addEdit);
    }
}
