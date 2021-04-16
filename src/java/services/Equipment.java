package services;

import dataaccess.CompanyDB;
import dataaccess.ItemDB;
import domain.Company;
import domain.Item;
import domain.Itemclass;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 813017
 */
public class Equipment {
    
    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Item get(int id) throws Exception {
        ItemDB itemDB = new ItemDB();
        Item item = itemDB.get(id);
        return item;
    }
    
    /**
     *
     * @param comp
     * @return
     * @throws Exception
     */
    public List<Item> getAll(Company comp) throws Exception {
        ItemDB itemDB = new ItemDB();
        List<Item> items = itemDB.getAll(comp);
        return items;
    }
    
    /**
     *
     * @param dateAdded
     * @param userAdded
     * @param model
     * @param isChargeableType
     * @param isDepletingType
     * @param isDepreactiationType
     * @param itemClassInformation
     * @param serialNumber
     * @param purchase
     * @param compID
     * @throws Exception
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
     *
     * @param id
     * @throws Exception
     */
    public void delete(int id) throws Exception {
        ItemDB itemDB = new ItemDB();
        Item hi = (Item) itemDB.get(id);
        itemDB.delete(hi);
    }
    
}
