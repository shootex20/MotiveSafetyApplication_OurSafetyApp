/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.PersonDB;
import domain.Person;

/**
 *
 * @author Chels
 */
public class PersonService {
    
    public void update(Integer personID, String firstName, String lastName, char gender) throws Exception {
        PersonDB personDB = new PersonDB();
        Person user = personDB.get(personID);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setGender(gender);
        personDB.update(user);
    }
    
}
