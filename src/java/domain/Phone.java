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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Chels
 */
@Entity
@Table(name = "phone")
@NamedQueries({
    @NamedQuery(name = "Phone.findAll", query = "SELECT p FROM Phone p")})
public class Phone implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "phone_ID")
    private Integer phoneID;
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
    @Column(name = "countryCode")
    private String countryCode;
    @Column(name = "areaCode")
    private String areaCode;
    @Column(name = "localNumber")
    private String localNumber;
    @Column(name = "extension")
    private String extension;
    @JoinColumn(name = "typeLibrary_ID", referencedColumnName = "typeLibrary_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Typelibrary typeLibraryID;
    @OneToMany(mappedBy = "phoneID", fetch = FetchType.EAGER)
    private List<Companypersonphone> companypersonphoneList;

    public Phone() {
    }

    public Phone(Integer phoneID) {
        this.phoneID = phoneID;
    }

    public Integer getPhoneID() {
        return phoneID;
    }

    public void setPhoneID(Integer phoneID) {
        this.phoneID = phoneID;
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

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getLocalNumber() {
        return localNumber;
    }

    public void setLocalNumber(String localNumber) {
        this.localNumber = localNumber;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Typelibrary getTypeLibraryID() {
        return typeLibraryID;
    }

    public void setTypeLibraryID(Typelibrary typeLibraryID) {
        this.typeLibraryID = typeLibraryID;
    }

    public List<Companypersonphone> getCompanypersonphoneList() {
        return companypersonphoneList;
    }

    public void setCompanypersonphoneList(List<Companypersonphone> companypersonphoneList) {
        this.companypersonphoneList = companypersonphoneList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (phoneID != null ? phoneID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Phone)) {
            return false;
        }
        Phone other = (Phone) object;
        if ((this.phoneID == null && other.phoneID != null) || (this.phoneID != null && !this.phoneID.equals(other.phoneID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Phone[ phoneID=" + phoneID + " ]";
    }
    
}
