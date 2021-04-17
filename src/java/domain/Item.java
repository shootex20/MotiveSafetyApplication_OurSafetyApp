/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

// TODO: Auto-generated Javadoc
/**
 * The Class Item.
 *
 * @author Chels
 */
@Entity
@Table(name = "item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i")
    , @NamedQuery(name = "Item.findByItemID", query = "SELECT i FROM Item i WHERE i.itemID = :itemID")
    , @NamedQuery(name = "Item.findByDateAdded", query = "SELECT i FROM Item i WHERE i.dateAdded = :dateAdded")
    , @NamedQuery(name = "Item.findByDateRemoved", query = "SELECT i FROM Item i WHERE i.dateRemoved = :dateRemoved")
    , @NamedQuery(name = "Item.findByUserAdded", query = "SELECT i FROM Item i WHERE i.userAdded = :userAdded")
    , @NamedQuery(name = "Item.findByUserRemoved", query = "SELECT i FROM Item i WHERE i.userRemoved = :userRemoved")
    , @NamedQuery(name = "Item.findByModel", query = "SELECT i FROM Item i WHERE i.model = :model")
    , @NamedQuery(name = "Item.findByIsChargeableType", query = "SELECT i FROM Item i WHERE i.isChargeableType = :isChargeableType")
    , @NamedQuery(name = "Item.findByIsDepletingType", query = "SELECT i FROM Item i WHERE i.isDepletingType = :isDepletingType")
    , @NamedQuery(name = "Item.findByIsDepreactiationType", query = "SELECT i FROM Item i WHERE i.isDepreactiationType = :isDepreactiationType")
    , @NamedQuery(name = "Item.findByItemClassInformation", query = "SELECT i FROM Item i WHERE i.itemClassInformation = :itemClassInformation")
    , @NamedQuery(name = "Item.findBySerialNumber", query = "SELECT i FROM Item i WHERE i.serialNumber = :serialNumber")
    , @NamedQuery(name = "Item.findByPurchaseDate", query = "SELECT i FROM Item i WHERE i.purchaseDate = :purchaseDate")})
public class Item implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    /** The item ID. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "item_ID", insertable=false)
    private Integer itemID;
    
    /** The date added. */
    @Column(name = "dateAdded")
    @Temporal(TemporalType.DATE)
    private Date dateAdded;
    
    /** The date removed. */
    @Column(name = "DateRemoved", insertable=false)
    @Temporal(TemporalType.DATE)
    private Date dateRemoved;
    
    /** The user added. */
    @Column(name = "userAdded")
    private Integer userAdded;
    
    /** The user removed. */
    @Column(name = "userRemoved", insertable=false)
    private Integer userRemoved;
    
    /** The model. */
    @Column(name = "model")
    private String model;
    
    /** The is chargeable type. */
    @Column(name = "isChargeableType")
    private Boolean isChargeableType;
    
    /** The is depleting type. */
    @Column(name = "isDepletingType")
    private Boolean isDepletingType;
    
    /** The is depreactiation type. */
    @Column(name = "isDepreactiationType")
    private Boolean isDepreactiationType;
    
    /** The item class information. */
    @Column(name = "itemClassInformation")
    private String itemClassInformation;
    
    /** The serial number. */
    @Column(name = "serialNumber")
    private String serialNumber;
    
    /** The purchase date. */
    @Column(name = "purchaseDate")
    @Temporal(TemporalType.DATE)
    private Date purchaseDate;
    
    /** The company ID. */
    @JoinColumn(name = "company_ID", referencedColumnName = "company_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Company companyID;
    
    /** The item class ID. */
    @JoinColumn(name = "itemClass_ID", referencedColumnName = "itemClass_ID", insertable=false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Itemclass itemClassID;

    /**
     * Instantiates a new item.
     */
    public Item() {
    }

    /**
     * Instantiates a new item.
     *
     * @param itemID the item ID
     */
    public Item(Integer itemID) {
        this.itemID = itemID;
    }
    
    /**
     * Instantiates a new item.
     *
     * @param dateAdded the date added
     * @param userAdded the user added
     * @param model the model
     * @param isChargeableType the is chargeable type
     * @param isDepletingType the is depleting type
     * @param isDepreactiationType the is depreactiation type
     * @param itemClassInformation the item class information
     * @param serialNumber the serial number
     * @param purchaseDate the purchase date
     * @param companyID the company ID
     */
    public Item(Date dateAdded, int userAdded, String model, boolean isChargeableType, 
    boolean isDepletingType, boolean isDepreactiationType, 
    String itemClassInformation, String serialNumber, Date purchaseDate, Company companyID) {
        
        this.dateAdded = dateAdded;
        this.userAdded = userAdded;
        this.purchaseDate = purchaseDate;
        this.itemClassInformation = itemClassInformation;
        this.model = model;
        this.isChargeableType = isChargeableType;
        this.isDepletingType = isDepletingType;
        this.isDepreactiationType = isDepreactiationType;
        this.serialNumber = serialNumber;
        this.companyID = companyID;
    }
    
    /**
     * Instantiates a new item.
     *
     * @param itemID the item ID
     * @param dateAdded the date added
     * @param model the model
     * @param isChargeableType the is chargeable type
     * @param isDepletingType the is depleting type
     * @param isDepreactiationType the is depreactiation type
     * @param itemClassInformation the item class information
     * @param serialNumber the serial number
     * @param purchaseDate the purchase date
     * @param companyID the company ID
     */
    public Item(Integer itemID, Date dateAdded ,String model, boolean isChargeableType, 
    boolean isDepletingType, boolean isDepreactiationType, 
    String itemClassInformation, String serialNumber, Date purchaseDate, Company companyID) {
        
        this.itemID = itemID;
        this.dateAdded = dateAdded;
        this.purchaseDate = purchaseDate;
        this.itemClassInformation = itemClassInformation;
        this.model = model;
        this.isChargeableType = isChargeableType;
        this.isDepletingType = isDepletingType;
        this.isDepreactiationType = isDepreactiationType;
        this.serialNumber = serialNumber;
        this.companyID = companyID;
    }

    /**
     * Gets the item ID.
     *
     * @return the item ID
     */
    public Integer getItemID() {
        return itemID;
    }

    /**
     * Sets the item ID.
     *
     * @param itemID the new item ID
     */
    public void setItemID(Integer itemID) {
        this.itemID = itemID;
    }

    /**
     * Gets the date added.
     *
     * @return the date added
     */
    public Date getDateAdded() {
        return dateAdded;
    }

    /**
     * Sets the date added.
     *
     * @param dateAdded the new date added
     */
    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    /**
     * Gets the date removed.
     *
     * @return the date removed
     */
    public Date getDateRemoved() {
        return dateRemoved;
    }

    /**
     * Sets the date removed.
     *
     * @param dateRemoved the new date removed
     */
    public void setDateRemoved(Date dateRemoved) {
        this.dateRemoved = dateRemoved;
    }

    /**
     * Gets the user added.
     *
     * @return the user added
     */
    public Integer getUserAdded() {
        return userAdded;
    }

    /**
     * Sets the user added.
     *
     * @param userAdded the new user added
     */
    public void setUserAdded(Integer userAdded) {
        this.userAdded = userAdded;
    }

    /**
     * Gets the user removed.
     *
     * @return the user removed
     */
    public Integer getUserRemoved() {
        return userRemoved;
    }

    /**
     * Sets the user removed.
     *
     * @param userRemoved the new user removed
     */
    public void setUserRemoved(Integer userRemoved) {
        this.userRemoved = userRemoved;
    }

    /**
     * Gets the model.
     *
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets the model.
     *
     * @param model the new model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Gets the checks if is chargeable type.
     *
     * @return the checks if is chargeable type
     */
    public Boolean getIsChargeableType() {
        return isChargeableType;
    }

    /**
     * Sets the checks if is chargeable type.
     *
     * @param isChargeableType the new checks if is chargeable type
     */
    public void setIsChargeableType(Boolean isChargeableType) {
        this.isChargeableType = isChargeableType;
    }

    /**
     * Gets the checks if is depleting type.
     *
     * @return the checks if is depleting type
     */
    public Boolean getIsDepletingType() {
        return isDepletingType;
    }

    /**
     * Sets the checks if is depleting type.
     *
     * @param isDepletingType the new checks if is depleting type
     */
    public void setIsDepletingType(Boolean isDepletingType) {
        this.isDepletingType = isDepletingType;
    }

    /**
     * Gets the checks if is depreactiation type.
     *
     * @return the checks if is depreactiation type
     */
    public Boolean getIsDepreactiationType() {
        return isDepreactiationType;
    }

    /**
     * Sets the checks if is depreactiation type.
     *
     * @param isDepreactiationType the new checks if is depreactiation type
     */
    public void setIsDepreactiationType(Boolean isDepreactiationType) {
        this.isDepreactiationType = isDepreactiationType;
    }

    /**
     * Gets the item class information.
     *
     * @return the item class information
     */
    public String getItemClassInformation() {
        return itemClassInformation;
    }

    /**
     * Sets the item class information.
     *
     * @param itemClassInformation the new item class information
     */
    public void setItemClassInformation(String itemClassInformation) {
        this.itemClassInformation = itemClassInformation;
    }

    /**
     * Gets the serial number.
     *
     * @return the serial number
     */
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * Sets the serial number.
     *
     * @param serialNumber the new serial number
     */
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    /**
     * Gets the purchase date.
     *
     * @return the purchase date
     */
    public Date getPurchaseDate() {
        return purchaseDate;
    }

    /**
     * Sets the purchase date.
     *
     * @param purchaseDate the new purchase date
     */
    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    /**
     * Gets the company ID.
     *
     * @return the company ID
     */
    public Company getCompanyID() {
        return companyID;
    }

    /**
     * Sets the company ID.
     *
     * @param companyID the new company ID
     */
    public void setCompanyID(Company companyID) {
        this.companyID = companyID;
    }

    /**
     * Gets the item class ID.
     *
     * @return the item class ID
     */
    public Itemclass getItemClassID() {
        return itemClassID;
    }

    /**
     * Sets the item class ID.
     *
     * @param itemClassID the new item class ID
     */
    public void setItemClassID(Itemclass itemClassID) {
        this.itemClassID = itemClassID;
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemID != null ? itemID.hashCode() : 0);
        return hash;
    }

    /**
     * Equals.
     *
     * @param object the object
     * @return true, if successful
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.itemID == null && other.itemID != null) || (this.itemID != null && !this.itemID.equals(other.itemID))) {
            return false;
        }
        return true;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "domain.Item[ itemID=" + itemID + " ]";
    }
    
}
