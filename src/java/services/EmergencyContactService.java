/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.EmergencyContactDB;
import domain.Emergencycontact;
import domain.Person;

/**
 *
 * @author Chels
 */
public class EmergencyContactService {
    
        public void update(Person personID, String firstName, String lastName, String phoneNum, String relation) throws Exception {
        EmergencyContactDB compPerDB = new EmergencyContactDB();
        Emergencycontact compPos = compPerDB.get(personID.getEmergencyContactID().getEmergencyContactID());
        compPos.setEmergencyContactFirstName(firstName);
        compPos.setEmergencyContactLastName(lastName);
        compPos.setEmergencyContactNumber(phoneNum);
        compPos.setEmergencyContactRelationship(relation);
        compPerDB.update(compPos);
    }
}
