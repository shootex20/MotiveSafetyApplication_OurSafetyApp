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

/**
 *
 * @author Chels
 */
@Entity
@Table(name = "item")
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i")})
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "item_ID")
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
    @Column(name = "itemClass_ID")
    private Integer itemClassID;
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

    public Item() {
    }

    public Item(Integer itemID) {
        this.itemID = itemID;
    }
    
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

    public Integer getItemID() {
        return itemID;
    }

    public void setItemID(Integer itemID) {
        this.itemID = itemID;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Date getDateRemoved() {
        return dateRemoved;
    }

    public void setDateRemoved(Date dateRemoved) {
        this.dateRemoved = dateRemoved;
    }

    public Integer getUserAdded() {
        return userAdded;
    }

    public void setUserAdded(Integer userAdded) {
        this.userAdded = userAdded;
    }

    public Integer getUserRemoved() {
        return userRemoved;
    }

    public void setUserRemoved(Integer userRemoved) {
        this.userRemoved = userRemoved;
    }

    public Integer getItemClassID() {
        return itemClassID;
    }

    public void setItemClassID(Integer itemClassID) {
        this.itemClassID = itemClassID;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Boolean getIsChargeableType() {
        return isChargeableType;
    }

    public void setIsChargeableType(Boolean isChargeableType) {
        this.isChargeableType = isChargeableType;
    }

    public Boolean getIsDepletingType() {
        return isDepletingType;
    }

    public void setIsDepletingType(Boolean isDepletingType) {
        this.isDepletingType = isDepletingType;
    }

    public Boolean getIsDepreactiationType() {
        return isDepreactiationType;
    }

    public void setIsDepreactiationType(Boolean isDepreactiationType) {
        this.isDepreactiationType = isDepreactiationType;
    }

    public String getItemClassInformation() {
        return itemClassInformation;
    }

    public void setItemClassInformation(String itemClassInformation) {
        this.itemClassInformation = itemClassInformation;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Company getCompanyID() {
        return companyID;
    }

    public void setCompanyID(Company companyID) {
        this.companyID = companyID;
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
