/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.CompanyPositionsDB;
import domain.Companyperson;
import domain.Companypositions;

/**
 *
 * @author Chels
 */
public class CompanypositionsService {
    
        public void update(int posID, String posTitle) throws Exception {
        CompanyPositionsDB compPerDB = new CompanyPositionsDB();
        Companypositions compPos = compPerDB.get(posID);
        compPos.setPositionTitle(posTitle);
        compPerDB.update(compPos);
    }
}
