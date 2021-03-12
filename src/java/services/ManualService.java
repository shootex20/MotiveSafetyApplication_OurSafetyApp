/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.ManualDB;
import domain.Manual;
import domain.Typelibrary;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 809968
 */
public class ManualService {
    ManualDB manualDB;
    
    public ManualService(){
        manualDB = new ManualDB();
    }
    
    public Manual get(int manualID) throws Exception{
        return manualDB.get(manualID);
    }
    
    public List<Manual> getAll() throws Exception {
        return manualDB.getAll();
    }
      
    public void update(int manualID, Date dateAdded, int userAdded,Typelibrary typeLibraryID, String title, String intention, String content) throws Exception{
         Manual manual =  manualDB.get(manualID);
         manual.setDateAdded(dateAdded);
         manual.setUserAdded(userAdded);
         manual.setTypeLibraryID(typeLibraryID);
         manual.setTitle(title);
         manual.setContent(content);
         manual.setIntention(intention);   
         
         manualDB.update(manual);
      }
      
    public void delete(int manualID) throws Exception {
        Manual deleteManual = manualDB.get(manualID);
        manualDB.delete(deleteManual);
    }
      
    public void insert(Date dateAdded, int userAdded,Typelibrary typeLibraryID, String title, String intention, String content) throws Exception {  
        
        Manual manual = new Manual();
        manual.setDateAdded(dateAdded);
        manual.setUserAdded(userAdded);
        manual.setTypeLibraryID(typeLibraryID);
        manual.setTitle(title);
        manual.setContent(content);
        manual.setIntention(intention);   
        
        manualDB.insert(manual);
    }
}
