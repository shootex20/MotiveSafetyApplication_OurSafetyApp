/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.CompanypersonDB;
import domain.Companyperson;

/**
 *
 * @author Chels
 */
public class CompanypersonService {
    
        public void update(Companyperson personID, String email) throws Exception {
        CompanypersonDB compPerDB = new CompanypersonDB();
        Companyperson compPersEdit = compPerDB.get(personID.getCompanyPersonID());
        compPersEdit.setEmail(email);
        compPerDB.update(compPersEdit);
    }
}
