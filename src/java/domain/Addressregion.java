/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Daniel Quach
 */
@Entity
@Table(name = "addressregion")
@NamedQueries({
    @NamedQuery(name = "Addressregion.findAll", query = "SELECT a FROM Addressregion a")})
public class Addressregion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "addressRegion_ID")
    private Integer addressRegionID;
    @Column(name = "dateAdded")
    @Temporal(TemporalType.DATE)
    private Date dateAdded;
    @Column(name = "dateRemoved")
    @Temporal(TemporalType.DATE)
    private Date dateRemoved;
    @Column(name = "userAdded")
    private Integer userAdded;
    @Column(name = "userRemoved")
    private Integer userRemoved;
    @Column(name = "parentType")
    private Integer parentType;
    @Column(name = "parentID")
    private Integer parentID;
    @Column(name = "spaceCode")
    private String spaceCode;
    @OneToMany(mappedBy = "addressRegionID", fetch = FetchType.EAGER)
    private List<Address> addressList;

    public Addressregion() {
    }

    public Addressregion(Integer addressRegionID) {
        this.addressRegionID = addressRegionID;
    }

    public Integer getAddressRegionID() {
        return addressRegionID;
    }

    public void setAddressRegionID(Integer addressRegionID) {
        this.addressRegionID = addressRegionID;
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

    public Integer getParentType() {
        return parentType;
    }

    public void setParentType(Integer parentType) {
        this.parentType = parentType;
    }

    public Integer getParentID() {
        return parentID;
    }

    public void setParentID(Integer parentID) {
        this.parentID = parentID;
    }

    public String getSpaceCode() {
        return spaceCode;
    }

    public void setSpaceCode(String spaceCode) {
        this.spaceCode = spaceCode;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (addressRegionID != null ? addressRegionID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Addressregion)) {
            return false;
        }
        Addressregion other = (Addressregion) object;
        if ((this.addressRegionID == null && other.addressRegionID != null) || (this.addressRegionID != null && !this.addressRegionID.equals(other.addressRegionID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Addressregion[ addressRegionID=" + addressRegionID + " ]";
    }
    
}
