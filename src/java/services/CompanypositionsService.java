/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.CompanyPositionsDB;
import domain.Company;
import domain.Companyperson;
import domain.Companypositions;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        
        public Companypositions insert(Integer userAdded, String positionTitle, Companyperson companyPersonID, Company companyID) throws Exception {
        CompanyPositionsDB addDB = new CompanyPositionsDB();
        
        Date dateAdded = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String tempDate = formatter.format(dateAdded);
        /*Formats the created date*/
        dateAdded = new SimpleDateFormat("yyyy-MM-dd").parse(tempDate);

        Companypositions add = new Companypositions(dateAdded, userAdded, positionTitle, companyPersonID, companyID);
        addDB.insert(add);
        return add;
    }
}
