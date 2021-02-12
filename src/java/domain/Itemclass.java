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
@Table(name = "itemclass")
@NamedQueries({
    @NamedQuery(name = "Itemclass.findAll", query = "SELECT i FROM Itemclass i")})
public class Itemclass implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "itemClass_ID")
    private Integer itemClassID;
    @Column(name = "DateAdded")
    @Temporal(TemporalType.DATE)
    private Date dateAdded;
    @Column(name = "dateRemoved")
    @Temporal(TemporalType.DATE)
    private Date dateRemoved;
    @Column(name = "userAdded")
    private Integer userAdded;
    @Column(name = "userRemoved")
    private Integer userRemoved;
    @Column(name = "itemType")
    private String itemType;
    @Column(name = "isChargeableType")
    private Boolean isChargeableType;
    @Column(name = "isDepletingType")
    private Boolean isDepletingType;
    @Column(name = "isDepreactiationType")
    private Boolean isDepreactiationType;
    @Column(name = "itemClassInformation")
    private String itemClassInformation;
    @JoinColumn(name = "itemClassFields_ID", referencedColumnName = "itemClassFields_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Itemclassfields itemClassFieldsID;

    public Itemclass() {
    }

    public Itemclass(Integer itemClassID) {
        this.itemClassID = itemClassID;
    }

    public Integer getItemClassID() {
        return itemClassID;
    }

    public void setItemClassID(Integer itemClassID) {
        this.itemClassID = itemClassID;
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

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
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

    public Itemclassfields getItemClassFieldsID() {
        return itemClassFieldsID;
    }

    public void setItemClassFieldsID(Itemclassfields itemClassFieldsID) {
        this.itemClassFieldsID = itemClassFieldsID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemClassID != null ? itemClassID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Itemclass)) {
            return false;
        }
        Itemclass other = (Itemclass) object;
        if ((this.itemClassID == null && other.itemClassID != null) || (this.itemClassID != null && !this.itemClassID.equals(other.itemClassID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Itemclass[ itemClassID=" + itemClassID + " ]";
    }
    
}
