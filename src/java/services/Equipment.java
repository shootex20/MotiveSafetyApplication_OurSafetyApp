package services;

import dataaccess.CompanyDB;
import dataaccess.ItemDB;
import domain.Company;
import domain.Item;
import domain.Itemclass;
import java.util.Date;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class Equipment.
 *
 * @author Chelsey Coughlin
 */
public class Equipment {
    
    /**
     * Gets the.
     *
     * @param id the id
     * @return the item
     * @throws Exception the exception
     */
    public Item get(int id) throws Exception {
        ItemDB itemDB = new ItemDB();
        Item item = itemDB.get(id);
        return item;
    }
    
    /**
     * Gets the all.
     *
     * @param comp the comp
     * @return the all
     * @throws Exception the exception
     */
    public List<Item> getAll(Company comp) throws Exception {
        ItemDB itemDB = new ItemDB();
        List<Item> items = itemDB.getAll(comp);
        return items;
    }
    
    /**
     * Insert.
     *
     * @param dateAdded the date added
     * @param userAdded the user added
     * @param model the model
     * @param isChargeableType the is chargeable type
     * @param isDepletingType the is depleting type
     * @param isDepreactiationType the is depreactiation type
     * @param itemClassInformation the item class information
     * @param serialNumber the serial number
     * @param purchase the purchase
     * @param compID the comp ID
     * @throws Exception the exception
     */
    public void insert(Date dateAdded, int userAdded, String model, boolean isChargeableType, 
            boolean isDepletingType, boolean isDepreactiationType, 
            String itemClassInformation, String serialNumber, Date purchase, Company compID) 
            throws Exception {
        Item items = new Item(dateAdded, userAdded, model, isChargeableType, isDepletingType, isDepreactiationType, itemClassInformation, serialNumber, purchase, compID);
        CompanyDB userDB = new CompanyDB();
        Company comp = userDB.get(compID.getCompanyID());
        items.setCompanyID(comp);
        ItemDB itemDB = new ItemDB();
        itemDB.insert(items);
    }
    
    /**
     * Delete.
     *
     * @param id the id
     * @throws Exception the exception
     */
    public void delete(int id) throws Exception {
        ItemDB itemDB = new ItemDB();
        Item hi = (Item) itemDB.get(id);
        itemDB.delete(hi);
    }
    
}
