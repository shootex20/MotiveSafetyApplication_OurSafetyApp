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
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Chels
 */
@Entity
@Table(name = "phone")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Phone.findAll", query = "SELECT p FROM Phone p")
    , @NamedQuery(name = "Phone.findByPhoneID", query = "SELECT p FROM Phone p WHERE p.phoneID = :phoneID")
    , @NamedQuery(name = "Phone.findByDateAdded", query = "SELECT p FROM Phone p WHERE p.dateAdded = :dateAdded")
    , @NamedQuery(name = "Phone.findByDateRemoved", query = "SELECT p FROM Phone p WHERE p.dateRemoved = :dateRemoved")
    , @NamedQuery(name = "Phone.findByUserAdded", query = "SELECT p FROM Phone p WHERE p.userAdded = :userAdded")
    , @NamedQuery(name = "Phone.findByUserRemoved", query = "SELECT p FROM Phone p WHERE p.userRemoved = :userRemoved")
    , @NamedQuery(name = "Phone.findByCountryCode", query = "SELECT p FROM Phone p WHERE p.countryCode = :countryCode")
    , @NamedQuery(name = "Phone.findByAreaCode", query = "SELECT p FROM Phone p WHERE p.areaCode = :areaCode")
    , @NamedQuery(name = "Phone.findByLocalNumber", query = "SELECT p FROM Phone p WHERE p.localNumber = :localNumber")
    , @NamedQuery(name = "Phone.findByExtension", query = "SELECT p FROM Phone p WHERE p.extension = :extension")})
public class Phone implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "phone_ID", insertable=false)
    private Integer phoneID;
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
    @Column(name = "countryCode")
    private String countryCode;
    @Column(name = "areaCode")
    private String areaCode;
    @Column(name = "localNumber")
    private String localNumber;
    @Column(name = "extension")
    private String extension;
    @JoinColumn(name = "typeLibrary_ID", referencedColumnName = "typeLibrary_ID", insertable=false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Typelibrary typeLibraryID;
    @OneToMany(orphanRemoval=true, mappedBy = "phoneID", fetch = FetchType.EAGER)
    private List<Companypersonphone> companypersonphoneList;

    /**
     *
     */
    public Phone() {
    }
    
    /**
     *
     * @param dateAdded
     * @param userAdded
     * @param countryCode
     * @param areaCode
     * @param localNumber
     * @param extension
     */
    public Phone(Date dateAdded, Integer userAdded, String countryCode, String areaCode, String localNumber, String extension) {
        
        this.dateAdded = dateAdded;
        this.userAdded = userAdded;
        this.countryCode = countryCode;
        this.areaCode = areaCode;
        this.localNumber = localNumber;
        this.extension = extension;
        
    }

    /**
     *
     * @param phoneID
     */
    public Phone(Integer phoneID) {
        this.phoneID = phoneID;
    }

    /**
     *
     * @return
     */
    public Integer getPhoneID() {
        return phoneID;
    }

    /**
     *
     * @param phoneID
     */
    public void setPhoneID(Integer phoneID) {
        this.phoneID = phoneID;
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
    public String getCountryCode() {
        return countryCode;
    }

    /**
     *
     * @param countryCode
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     *
     * @return
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     *
     * @param areaCode
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    /**
     *
     * @return
     */
    public String getLocalNumber() {
        return localNumber;
    }

    /**
     *
     * @param localNumber
     */
    public void setLocalNumber(String localNumber) {
        this.localNumber = localNumber;
    }

    /**
     *
     * @return
     */
    public String getExtension() {
        return extension;
    }

    /**
     *
     * @param extension
     */
    public void setExtension(String extension) {
        this.extension = extension;
    }

    /**
     *
     * @return
     */
    public Typelibrary getTypeLibraryID() {
        return typeLibraryID;
    }

    /**
     *
     * @param typeLibraryID
     */
    public void setTypeLibraryID(Typelibrary typeLibraryID) {
        this.typeLibraryID = typeLibraryID;
    }

    /**
     *
     * @return
     */
    @XmlTransient
    public List<Companypersonphone> getCompanypersonphoneList() {
        return companypersonphoneList;
    }

    /**
     *
     * @param companypersonphoneList
     */
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
