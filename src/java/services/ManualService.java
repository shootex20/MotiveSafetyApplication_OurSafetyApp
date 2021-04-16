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
 * Data management
 * @version 1.0
 * @author 809968
 */
public class ManualService {
    ManualDB manualDB;
 
    /**
     *
     */
    public ManualService(){
        manualDB = new ManualDB();
    }

/**
 * get Manual by id
 * @param manualID id of the manual
 * @return return manual object
 * @throws Exception Exception
 */    
    public Manual get(int manualID) throws Exception{
        return manualDB.get(manualID);
    }

/**
 * get all the manual in the database return as a list
 * @return manual list
 * @throws Exception Exception
 */    
    public List<Manual> getAll() throws Exception {
        return manualDB.getAll();
    }

/**
 * update manual information
 * @param manualID manual id
 * @param dateAdded manual dateAdded
 * @param userAdded manual userAdded
 * @param typeLibraryID manual typeLibraryID
 * @param title manual title
 * @param intention manual
 * @param content manual content
 * @throws Exception Exception
 */    
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

/**
 * delete manual by id
 * @param manualID manual id
 * @throws Exception  Exception
 */    
    public void delete(int manualID) throws Exception {
        Manual deleteManual = manualDB.get(manualID);
        manualDB.delete(deleteManual);
    }

/**
 * insert new manual
 * @param dateAdded manual dateAdded
 * @param userAdded manual userAdded
 * @param typeLibraryID manual typeLibraryID
 * @param title manual title
 * @param intention manual
 * @param content manual content
 * @throws Exception Exception
 */
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
