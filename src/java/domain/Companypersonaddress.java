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
@Table(name = "companypersonaddress")
@NamedQueries({
    @NamedQuery(name = "Companypersonaddress.findAll", query = "SELECT c FROM Companypersonaddress c")})
public class Companypersonaddress implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "companyPersonAddress_ID")
    private Integer companyPersonAddressID;
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
    @JoinColumn(name = "address_ID", referencedColumnName = "address_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Address addressID;
    @JoinColumn(name = "companyPerson_ID", referencedColumnName = "companyPerson_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Companyperson companyPersonID;

    public Companypersonaddress() {
    }

    public Companypersonaddress(Integer companyPersonAddressID) {
        this.companyPersonAddressID = companyPersonAddressID;
    }

    public Integer getCompanyPersonAddressID() {
        return companyPersonAddressID;
    }

    public void setCompanyPersonAddressID(Integer companyPersonAddressID) {
        this.companyPersonAddressID = companyPersonAddressID;
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

    public Address getAddressID() {
        return addressID;
    }

    public void setAddressID(Address addressID) {
        this.addressID = addressID;
    }

    public Companyperson getCompanyPersonID() {
        return companyPersonID;
    }

    public void setCompanyPersonID(Companyperson companyPersonID) {
        this.companyPersonID = companyPersonID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (companyPersonAddressID != null ? companyPersonAddressID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Companypersonaddress)) {
            return false;
        }
        Companypersonaddress other = (Companypersonaddress) object;
        if ((this.companyPersonAddressID == null && other.companyPersonAddressID != null) || (this.companyPersonAddressID != null && !this.companyPersonAddressID.equals(other.companyPersonAddressID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Companypersonaddress[ companyPersonAddressID=" + companyPersonAddressID + " ]";
    }
    
}