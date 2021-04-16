/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.EmergencyContactDB;
import dataaccess.PersonDB;
import domain.Emergencycontact;
import domain.Person;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Chels
 */
public class PersonService {
    
    /**
     *
     * @param personID
     * @param firstName
     * @param lastName
     * @param gender
     * @throws Exception
     */
    public void update(Integer personID, String firstName, String lastName, char gender) throws Exception {
        PersonDB personDB = new PersonDB();
        Person user = personDB.get(personID);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setGender(gender);
        personDB.update(user);
    }
    
    /**
     *
     * @param userAdded
     * @param firstName
     * @param lastName
     * @param dateOfBirth
     * @param gender
     * @param emergencyContactID
     * @return
     * @throws Exception
     */
    public Person insert(Integer userAdded, String firstName, String lastName, String dateOfBirth, Character gender, Emergencycontact emergencyContactID) throws Exception {
        PersonDB addDB = new PersonDB();
        
        Date dateAdded = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String tempDate = formatter.format(dateAdded);
        /*Formats the created date*/
        dateAdded = new SimpleDateFormat("yyyy-MM-dd").parse(tempDate);
        /*Converts String birthday to birthdate*/
        Date dateOfBirthDate = null;
        dateOfBirthDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateOfBirth);

        Person add = new Person(dateAdded, userAdded, firstName, lastName, dateOfBirthDate, gender, emergencyContactID);
        addDB.insert(add);
        return add;
    }
        
    /**
     *
     * @param personID
     * @param emergencyContactID
     * @throws Exception
     */
    public void link(int personID, Emergencycontact emergencyContactID) throws Exception {
        PersonDB compPerDB = new PersonDB();
        Person compPersEdit = compPerDB.get(personID);
        compPersEdit.setEmergencyContactID(emergencyContactID);
        compPerDB.update(compPersEdit);
    }
    
}
