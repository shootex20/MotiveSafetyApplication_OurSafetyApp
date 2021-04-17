/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.EmergencyContactDB;
import domain.Emergencycontact;
import domain.Person;
import java.text.SimpleDateFormat;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class EmergencyContactService.
 *
 * @author Chelsey Coughlin
 */
public class EmergencyContactService {
    
    /**
     * Update.
     *
     * @param personID the person ID
     * @param firstName the first name
     * @param lastName the last name
     * @param phoneNum the phone num
     * @param relation the relation
     * @throws Exception the exception
     */
    public void update(Person personID, String firstName, String lastName, String phoneNum, String relation) throws Exception {
        EmergencyContactDB compPerDB = new EmergencyContactDB();
        Emergencycontact compPos = compPerDB.get(personID.getEmergencyContactID().getEmergencyContactID());
        compPos.setEmergencyContactFirstName(firstName);
        compPos.setEmergencyContactLastName(lastName);
        compPos.setEmergencyContactNumber(phoneNum);
        compPos.setEmergencyContactRelationship(relation);
        compPerDB.update(compPos);
    }
        
    /**
     * Insert.
     *
     * @param userAdded the user added
     * @param emergencyContactFirstName the emergency contact first name
     * @param emergencyContactLastName the emergency contact last name
     * @param emergencyContactNumber the emergency contact number
     * @param emergencyContactRelationship the emergency contact relationship
     * @return the emergencycontact
     * @throws Exception the exception
     */
    public Emergencycontact insert(Integer userAdded, String emergencyContactFirstName, String emergencyContactLastName, 
            String emergencyContactNumber, String emergencyContactRelationship) throws Exception {
        EmergencyContactDB addDB = new EmergencyContactDB();
        
        Date dateAdded = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String tempDate = formatter.format(dateAdded);
        /*Formats the created date*/
        dateAdded = new SimpleDateFormat("yyyy-MM-dd").parse(tempDate);

        Emergencycontact add = new Emergencycontact(dateAdded, userAdded, emergencyContactFirstName, emergencyContactLastName, emergencyContactNumber, emergencyContactRelationship);
        addDB.insert(add);
        return add;
    }
        /*
        public void link(int emergID, String email) throws Exception {
        EmergencyContactDB compPerDB = new EmergencyContactDB();
        Emergencycontact compPersEdit = compPerDB.get(emergID);
        compPersEdit.setEmail(email);
        compPerDB.update(compPersEdit);
    }
*/
}
