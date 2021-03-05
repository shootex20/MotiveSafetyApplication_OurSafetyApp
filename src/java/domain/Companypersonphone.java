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
@Table(name = "companypersonphone")
@NamedQueries({
    @NamedQuery(name = "Companypersonphone.findAll", query = "SELECT c FROM Companypersonphone c")})
public class Companypersonphone implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "companyPersonPhone_ID", insertable=false)
    private Integer companyPersonPhoneID;
    @Column(name = "dateAdded")
    @Temporal(TemporalType.DATE)
    private Date dateAdded;
    @Column(name = "dateRemoved", insertable=false)
    @Temporal(TemporalType.DATE)
    private Date dateRemoved;
    @Column(name = "userAdded")
    private Integer userAdded;
    @Column(name = "userRemoved", insertable=false)
    private Integer userRemoved;
    @JoinColumn(name = "companyPerson_ID", referencedColumnName = "companyPerson_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Companyperson companyPersonID;
    @JoinColumn(name = "phone_ID", referencedColumnName = "phone_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Phone phoneID;

    public Companypersonphone() {
    }

    public Companypersonphone(Integer companyPersonPhoneID) {
        this.companyPersonPhoneID = companyPersonPhoneID;
    }

    public Integer getCompanyPersonPhoneID() {
        return companyPersonPhoneID;
    }

    public void setCompanyPersonPhoneID(Integer companyPersonPhoneID) {
        this.companyPersonPhoneID = companyPersonPhoneID;
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

    public Companyperson getCompanyPersonID() {
        return companyPersonID;
    }

    public void setCompanyPersonID(Companyperson companyPersonID) {
        this.companyPersonID = companyPersonID;
    }

    public Phone getPhoneID() {
        return phoneID;
    }

    public void setPhoneID(Phone phoneID) {
        this.phoneID = phoneID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (companyPersonPhoneID != null ? companyPersonPhoneID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Companypersonphone)) {
            return false;
        }
        Companypersonphone other = (Companypersonphone) object;
        if ((this.companyPersonPhoneID == null && other.companyPersonPhoneID != null) || (this.companyPersonPhoneID != null && !this.companyPersonPhoneID.equals(other.companyPersonPhoneID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Companypersonphone[ companyPersonPhoneID=" + companyPersonPhoneID + " ]";
    }
    
}
