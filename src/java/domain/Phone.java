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

// TODO: Auto-generated Javadoc
/**
 * The Class Phone.
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

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    /** The phone ID. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "phone_ID", insertable=false)
    private Integer phoneID;
    
    /** The date added. */
    @Column(name = "dateAdded")
    @Temporal(TemporalType.DATE)
    private Date dateAdded;
    
    /** The date removed. */
    @Column(name = "dateRemoved", insertable=false)
    @Temporal(TemporalType.DATE)
    private Date dateRemoved;
    
    /** The user added. */
    @Column(name = "userAdded")
    private Integer userAdded;
    
    /** The user removed. */
    @Column(name = "userRemoved", insertable=false)
    private Integer userRemoved;
    
    /** The country code. */
    @Column(name = "countryCode")
    private String countryCode;
    
    /** The area code. */
    @Column(name = "areaCode")
    private String areaCode;
    
    /** The local number. */
    @Column(name = "localNumber")
    private String localNumber;
    
    /** The extension. */
    @Column(name = "extension")
    private String extension;
    
    /** The type library ID. */
    @JoinColumn(name = "typeLibrary_ID", referencedColumnName = "typeLibrary_ID", insertable=false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Typelibrary typeLibraryID;
    
    /** The companypersonphone list. */
    @OneToMany(orphanRemoval=true, mappedBy = "phoneID", fetch = FetchType.EAGER)
    private List<Companypersonphone> companypersonphoneList;

    /**
     * Instantiates a new phone.
     */
    public Phone() {
    }
    
    /**
     * Instantiates a new phone.
     *
     * @param dateAdded the date added
     * @param userAdded the user added
     * @param countryCode the country code
     * @param areaCode the area code
     * @param localNumber the local number
     * @param extension the extension
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
     * Instantiates a new phone.
     *
     * @param phoneID the phone ID
     */
    public Phone(Integer phoneID) {
        this.phoneID = phoneID;
    }

    /**
     * Gets the phone ID.
     *
     * @return the phone ID
     */
    public Integer getPhoneID() {
        return phoneID;
    }

    /**
     * Sets the phone ID.
     *
     * @param phoneID the new phone ID
     */
    public void setPhoneID(Integer phoneID) {
        this.phoneID = phoneID;
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
     * Gets the country code.
     *
     * @return the country code
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Sets the country code.
     *
     * @param countryCode the new country code
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * Gets the area code.
     *
     * @return the area code
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * Sets the area code.
     *
     * @param areaCode the new area code
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    /**
     * Gets the local number.
     *
     * @return the local number
     */
    public String getLocalNumber() {
        return localNumber;
    }

    /**
     * Sets the local number.
     *
     * @param localNumber the new local number
     */
    public void setLocalNumber(String localNumber) {
        this.localNumber = localNumber;
    }

    /**
     * Gets the extension.
     *
     * @return the extension
     */
    public String getExtension() {
        return extension;
    }

    /**
     * Sets the extension.
     *
     * @param extension the new extension
     */
    public void setExtension(String extension) {
        this.extension = extension;
    }

    /**
     * Gets the type library ID.
     *
     * @return the type library ID
     */
    public Typelibrary getTypeLibraryID() {
        return typeLibraryID;
    }

    /**
     * Sets the type library ID.
     *
     * @param typeLibraryID the new type library ID
     */
    public void setTypeLibraryID(Typelibrary typeLibraryID) {
        this.typeLibraryID = typeLibraryID;
    }

    /**
     * Gets the companypersonphone list.
     *
     * @return the companypersonphone list
     */
    @XmlTransient
    public List<Companypersonphone> getCompanypersonphoneList() {
        return companypersonphoneList;
    }

    /**
     * Sets the companypersonphone list.
     *
     * @param companypersonphoneList the new companypersonphone list
     */
    public void setCompanypersonphoneList(List<Companypersonphone> companypersonphoneList) {
        this.companypersonphoneList = companypersonphoneList;
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (phoneID != null ? phoneID.hashCode() : 0);
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
        if (!(object instanceof Phone)) {
            return false;
        }
        Phone other = (Phone) object;
        if ((this.phoneID == null && other.phoneID != null) || (this.phoneID != null && !this.phoneID.equals(other.phoneID))) {
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
        return "domain.Phone[ phoneID=" + phoneID + " ]";
    }
    
}
