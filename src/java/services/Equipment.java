package services;

import dataaccess.CompanyDB;
import dataaccess.ItemDB;
import domain.Company;
import domain.Item;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 813017
 */
public class Equipment {
    
        public Item get(int id) throws Exception {
        ItemDB itemDB = new ItemDB();
        Item item = itemDB.get(id);
        return item;
    }
    
    public List<Item> getAll(Company comp) throws Exception {
        ItemDB itemDB = new ItemDB();
        List<Item> items = itemDB.getAll(comp);
        return items;
    }
    
    public void insert(Date dateAdded,String model, boolean isChargeableType, 
            boolean isDepletingType, boolean isDepreactiationType, 
            String itemClassInformation, String serialNumber, Date purchase, Company compID) 
            throws Exception {
        Item items = new Item(dateAdded, model, isChargeableType, isDepletingType, isDepreactiationType, itemClassInformation, serialNumber, purchase, compID);
        CompanyDB userDB = new CompanyDB();
        Company comp = userDB.get(compID.getCompanyID());
        items.setCompanyID(comp);
        ItemDB itemDB = new ItemDB();
        itemDB.insert(items);
    }
    
    public void delete(int id) throws Exception {
        ItemDB itemDB = new ItemDB();
        Item hi = (Item) itemDB.get(id);
        itemDB.delete(hi);
    }
    
}
