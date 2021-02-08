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
 * @author Daniel Quach
 */
@Entity
@Table(name = "itemclass")
@NamedQueries({
    @NamedQuery(name = "Itemclass.findAll", query = "SELECT i FROM Itemclass i")})
public class Itemclass implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(name = "chargeableType")
    private String chargeableType;
    @Column(name = "depletingType")
    private String depletingType;
    @Column(name = "depreactiationType")
    private String depreactiationType;
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

    public String getChargeableType() {
        return chargeableType;
    }

    public void setChargeableType(String chargeableType) {
        this.chargeableType = chargeableType;
    }

    public String getDepletingType() {
        return depletingType;
    }

    public void setDepletingType(String depletingType) {
        this.depletingType = depletingType;
    }

    public String getDepreactiationType() {
        return depreactiationType;
    }

    public void setDepreactiationType(String depreactiationType) {
        this.depreactiationType = depreactiationType;
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
