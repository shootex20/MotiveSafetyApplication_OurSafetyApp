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
 * The Class Address.
 *
 * @author Chels
 */
@Entity
@Table(name = "address")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a")
    , @NamedQuery(name = "Address.findByAddressID", query = "SELECT a FROM Address a WHERE a.addressID = :addressID")
    , @NamedQuery(name = "Address.findByDateAdded", query = "SELECT a FROM Address a WHERE a.dateAdded = :dateAdded")
    , @NamedQuery(name = "Address.findByDateRemoved", query = "SELECT a FROM Address a WHERE a.dateRemoved = :dateRemoved")
    , @NamedQuery(name = "Address.findByUserAdded", query = "SELECT a FROM Address a WHERE a.userAdded = :userAdded")
    , @NamedQuery(name = "Address.findByUserRemoved", query = "SELECT a FROM Address a WHERE a.userRemoved = :userRemoved")
    , @NamedQuery(name = "Address.findByAddressLine1", query = "SELECT a FROM Address a WHERE a.addressLine1 = :addressLine1")
    , @NamedQuery(name = "Address.findByAddressLine2", query = "SELECT a FROM Address a WHERE a.addressLine2 = :addressLine2")
    , @NamedQuery(name = "Address.findByCity", query = "SELECT a FROM Address a WHERE a.city = :city")
    , @NamedQuery(name = "Address.findByProvince", query = "SELECT a FROM Address a WHERE a.province = :province")
    , @NamedQuery(name = "Address.findByCountry", query = "SELECT a FROM Address a WHERE a.country = :country")
    , @NamedQuery(name = "Address.findByPostalCode", query = "SELECT a FROM Address a WHERE a.postalCode = :postalCode")})
public class Address implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    /** The address ID. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "address_ID", insertable=false)
    private Integer addressID;
    
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
    
    /** The address line 1. */
    @Column(name = "addressLine1")
    private String addressLine1;
    
    /** The address line 2. */
    @Column(name = "addressLine2")
    private String addressLine2;
    
    /** The city. */
    @Column(name = "city")
    private String city;
    
    /** The province. */
    @Column(name = "province")
    private String province;
    
    /** The country. */
    @Column(name = "country")
    private String country;
    
    /** The postal code. */
    @Column(name = "postalCode")
    private String postalCode;
    
    /** The type library ID. */
    @JoinColumn(name = "typeLibrary_ID", referencedColumnName = "typeLibrary_ID",  insertable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Typelibrary typeLibraryID;
    
    /** The companypersonaddress list. */
    @OneToMany(orphanRemoval=true, mappedBy = "addressID", fetch = FetchType.EAGER)
    private List<Companypersonaddress> companypersonaddressList;

    /**
     * Instantiates a new address.
     */
    public Address() {
    }

    /**
     * Instantiates a new address.
     *
     * @param addressID takes in address id
     */
    public Address(Integer addressID) {
        this.addressID = addressID;
    }
    
    /**
     * Instantiates a new address.
     *
     * @param dateAdded the date added
     * @param userAdded the user added
     * @param addressLine1 the address line 1
     * @param addressLine2 the address line 2
     * @param city the city
     * @param province the province
     * @param country the country
     * @param postalCode the postal code
     */
    public Address(Date dateAdded, Integer userAdded, String addressLine1, String addressLine2, String city, String province, String country, String postalCode) {
        this.dateAdded = dateAdded;
        this.userAdded = userAdded;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.province = province;
        this.country = country;
        this.postalCode = postalCode;
    }

    /**
     * Gets the address ID.
     *
     * @return integer returns integer
     */
    public Integer getAddressID() {
        return addressID;
    }

    /**
     * Sets the address ID.
     *
     * @param addressID takes in address id
     */
    public void setAddressID(Integer addressID) {
        this.addressID = addressID;
    }

    /**
     * Gets the date added.
     *
     * @return returns date
     */
    public Date getDateAdded() {
        return dateAdded;
    }

    /**
     * Sets the date added.
     *
     * @param dateAdded takes in date
     */
    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    /**
     * Gets the date removed.
     *
     * @return Date returns a date
     */
    public Date getDateRemoved() {
        return dateRemoved;
    }

    /**
     * Sets the date removed.
     *
     * @param dateRemoved takes in date removed
     */
    public void setDateRemoved(Date dateRemoved) {
        this.dateRemoved = dateRemoved;
    }

    /**
     * Gets the user added.
     *
     * @return Integer returns user integer
     */
    public Integer getUserAdded() {
        return userAdded;
    }

    /**
     * Sets the user added.
     *
     * @param userAdded takes in date added
     */
    public void setUserAdded(Integer userAdded) {
        this.userAdded = userAdded;
    }

    /**
     * Gets the user removed.
     *
     * @return Integer returns a integer
     */
    public Integer getUserRemoved() {
        return userRemoved;
    }

    /**
     * Sets the user removed.
     *
     * @param userRemoved takes in a integer
     */
    public void setUserRemoved(Integer userRemoved) {
        this.userRemoved = userRemoved;
    }

    
    //THIS ONE IN THE STARS AND SLASHES
    /**
     * Gets the address line 1.
     *
     * @return String returns a string
     */
    
     //not these
    public String getAddressLine1() {
        return addressLine1;
    }
 //THIS ONE IN THE STARS AND SLASHES
    /**
  * Sets the address line 1.
  *
  * @param addressLine1 returns a address line 1
  */
    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    /**
     * Gets the address line 2.
     *
     * @return the address line 2
     */
    public String getAddressLine2() {
        return addressLine2;
    }

    /**
     * Sets the address line 2.
     *
     * @param addressLine2 the new address line 2
     */
    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    /**
     * Gets the city.
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city.
     *
     * @param city the new city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the province.
     *
     * @return the province
     */
    public String getProvince() {
        return province;
    }

    /**
     * Sets the province.
     *
     * @param province the new province
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * Gets the country.
     *
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the country.
     *
     * @param country the new country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Gets the postal code.
     *
     * @return the postal code
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Sets the postal code.
     *
     * @param postalCode the new postal code
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
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
     * Gets the companypersonaddress list.
     *
     * @return the companypersonaddress list
     */
    @XmlTransient
    public List<Companypersonaddress> getCompanypersonaddressList() {
        return companypersonaddressList;
    }

    /**
     * Sets the companypersonaddress list.
     *
     * @param companypersonaddressList the new companypersonaddress list
     */
    public void setCompanypersonaddressList(List<Companypersonaddress> companypersonaddressList) {
        this.companypersonaddressList = companypersonaddressList;
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (addressID != null ? addressID.hashCode() : 0);
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
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.addressID == null && other.addressID != null) || (this.addressID != null && !this.addressID.equals(other.addressID))) {
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
        return "domain.Address[ addressID=" + addressID + " ]";
    }
    
}
