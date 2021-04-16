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

/**
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

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "item_ID", insertable=false)
    private Integer itemID;
    @Column(name = "dateAdded")
    @Temporal(TemporalType.DATE)
    private Date dateAdded;
    @Column(name = "DateRemoved", insertable=false)
    @Temporal(TemporalType.DATE)
    private Date dateRemoved;
    @Column(name = "userAdded")
    private Integer userAdded;
    @Column(name = "userRemoved", insertable=false)
    private Integer userRemoved;
    @Column(name = "model")
    private String model;
    @Column(name = "isChargeableType")
    private Boolean isChargeableType;
    @Column(name = "isDepletingType")
    private Boolean isDepletingType;
    @Column(name = "isDepreactiationType")
    private Boolean isDepreactiationType;
    @Column(name = "itemClassInformation")
    private String itemClassInformation;
    @Column(name = "serialNumber")
    private String serialNumber;
    @Column(name = "purchaseDate")
    @Temporal(TemporalType.DATE)
    private Date purchaseDate;
    @JoinColumn(name = "company_ID", referencedColumnName = "company_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Company companyID;
    @JoinColumn(name = "itemClass_ID", referencedColumnName = "itemClass_ID", insertable=false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Itemclass itemClassID;

    /**
     *
     */
    public Item() {
    }

    /**
     *
     * @param itemID
     */
    public Item(Integer itemID) {
        this.itemID = itemID;
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
     * @param purchaseDate
     * @param companyID
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
     *
     * @param itemID
     * @param dateAdded
     * @param model
     * @param isChargeableType
     * @param isDepletingType
     * @param isDepreactiationType
     * @param itemClassInformation
     * @param serialNumber
     * @param purchaseDate
     * @param companyID
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
     *
     * @return
     */
    public Integer getItemID() {
        return itemID;
    }

    /**
     *
     * @param itemID
     */
    public void setItemID(Integer itemID) {
        this.itemID = itemID;
    }

    /**
     *
     * @return
     */
    public Date getDateAdded() {
        return dateAdded;
    }

    /**
     *
     * @param dateAdded
     */
    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    /**
     *
     * @return
     */
    public Date getDateRemoved() {
        return dateRemoved;
    }

    /**
     *
     * @param dateRemoved
     */
    public void setDateRemoved(Date dateRemoved) {
        this.dateRemoved = dateRemoved;
    }

    /**
     *
     * @return
     */
    public Integer getUserAdded() {
        return userAdded;
    }

    /**
     *
     * @param userAdded
     */
    public void setUserAdded(Integer userAdded) {
        this.userAdded = userAdded;
    }

    /**
     *
     * @return
     */
    public Integer getUserRemoved() {
        return userRemoved;
    }

    /**
     *
     * @param userRemoved
     */
    public void setUserRemoved(Integer userRemoved) {
        this.userRemoved = userRemoved;
    }

    /**
     *
     * @return
     */
    public String getModel() {
        return model;
    }

    /**
     *
     * @param model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     *
     * @return
     */
    public Boolean getIsChargeableType() {
        return isChargeableType;
    }

    /**
     *
     * @param isChargeableType
     */
    public void setIsChargeableType(Boolean isChargeableType) {
        this.isChargeableType = isChargeableType;
    }

    /**
     *
     * @return
     */
    public Boolean getIsDepletingType() {
        return isDepletingType;
    }

    /**
     *
     * @param isDepletingType
     */
    public void setIsDepletingType(Boolean isDepletingType) {
        this.isDepletingType = isDepletingType;
    }

    /**
     *
     * @return
     */
    public Boolean getIsDepreactiationType() {
        return isDepreactiationType;
    }

    /**
     *
     * @param isDepreactiationType
     */
    public void setIsDepreactiationType(Boolean isDepreactiationType) {
        this.isDepreactiationType = isDepreactiationType;
    }

    /**
     *
     * @return
     */
    public String getItemClassInformation() {
        return itemClassInformation;
    }

    /**
     *
     * @param itemClassInformation
     */
    public void setItemClassInformation(String itemClassInformation) {
        this.itemClassInformation = itemClassInformation;
    }

    /**
     *
     * @return
     */
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     *
     * @param serialNumber
     */
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    /**
     *
     * @return
     */
    public Date getPurchaseDate() {
        return purchaseDate;
    }

    /**
     *
     * @param purchaseDate
     */
    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    /**
     *
     * @return
     */
    public Company getCompanyID() {
        return companyID;
    }

    /**
     *
     * @param companyID
     */
    public void setCompanyID(Company companyID) {
        this.companyID = companyID;
    }

    /**
     *
     * @return
     */
    public Itemclass getItemClassID() {
        return itemClassID;
    }

    /**
     *
     * @param itemClassID
     */
    public void setItemClassID(Itemclass itemClassID) {
        this.itemClassID = itemClassID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemID != null ? itemID.hashCode() : 0);
        return hash;
    }

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

    @Override
    public String toString() {
        return "domain.Item[ itemID=" + itemID + " ]";
    }
    
}
