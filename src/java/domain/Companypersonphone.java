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
import javax.xml.bind.annotation.XmlRootElement;

// TODO: Auto-generated Javadoc
/**
 * The Class Companypersonphone.
 *
 * @author Chels
 */
@Entity
@Table(name = "companypersonphone")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Companypersonphone.findAll", query = "SELECT c FROM Companypersonphone c")
    , @NamedQuery(name = "Companypersonphone.findByCompanyPersonPhoneID", query = "SELECT c FROM Companypersonphone c WHERE c.companyPersonPhoneID = :companyPersonPhoneID")
    , @NamedQuery(name = "Companypersonphone.findByDateAdded", query = "SELECT c FROM Companypersonphone c WHERE c.dateAdded = :dateAdded")
    , @NamedQuery(name = "Companypersonphone.findByDateRemoved", query = "SELECT c FROM Companypersonphone c WHERE c.dateRemoved = :dateRemoved")
    , @NamedQuery(name = "Companypersonphone.findByUserAdded", query = "SELECT c FROM Companypersonphone c WHERE c.userAdded = :userAdded")
    , @NamedQuery(name = "Companypersonphone.findByUserRemoved", query = "SELECT c FROM Companypersonphone c WHERE c.userRemoved = :userRemoved")})
public class Companypersonphone implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    /** The company person phone ID. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "companyPersonPhone_ID", insertable = false)
    private Integer companyPersonPhoneID;
    
    /** The date added. */
    @Column(name = "dateAdded")
    @Temporal(TemporalType.DATE)
    private Date dateAdded;
    
    /** The date removed. */
    @Column(name = "dateRemoved", insertable = false)
    @Temporal(TemporalType.DATE)
    private Date dateRemoved;
    
    /** The user added. */
    @Column(name = "userAdded")
    private Integer userAdded;
    
    /** The user removed. */
    @Column(name = "userRemoved", insertable = false)
    private Integer userRemoved;
    
    /** The phone ID. */
    @JoinColumn(name = "phone_ID", referencedColumnName = "phone_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Phone phoneID;
    
    /** The company person ID. */
    @JoinColumn(name = "companyPerson_ID", referencedColumnName = "companyPerson_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Companyperson companyPersonID;

    /**
     * Instantiates a new companypersonphone.
     */
    public Companypersonphone() {
    }

    /**
     * Instantiates a new companypersonphone.
     *
     * @param companyPersonPhoneID the company person phone ID
     */
    public Companypersonphone(Integer companyPersonPhoneID) {
        this.companyPersonPhoneID = companyPersonPhoneID;
    }
    
    /**
     * Instantiates a new companypersonphone.
     *
     * @param dateAdded the date added
     * @param userAdded the user added
     * @param companyPersonID the company person ID
     * @param phoneID the phone ID
     */
    public Companypersonphone(Date dateAdded, Integer userAdded, Companyperson companyPersonID, Phone phoneID) {
        this.dateAdded = dateAdded;
        this.userAdded = userAdded;
        this.companyPersonID = companyPersonID;
        this.phoneID = phoneID;
    }
    
    /**
     * Gets the company person phone ID.
     *
     * @return the company person phone ID
     */
    public Integer getCompanyPersonPhoneID() {
        return companyPersonPhoneID;
    }

    /**
     * Sets the company person phone ID.
     *
     * @param companyPersonPhoneID the new company person phone ID
     */
    public void setCompanyPersonPhoneID(Integer companyPersonPhoneID) {
        this.companyPersonPhoneID = companyPersonPhoneID;
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
     * Gets the company person ID.
     *
     * @return the company person ID
     */
    public Companyperson getCompanyPersonID() {
        return companyPersonID;
    }

    /**
     * Sets the company person ID.
     *
     * @param companyPersonID the new company person ID
     */
    public void setCompanyPersonID(Companyperson companyPersonID) {
        this.companyPersonID = companyPersonID;
    }

    /**
     * Gets the phone ID.
     *
     * @return the phone ID
     */
    public Phone getPhoneID() {
        return phoneID;
    }

    /**
     * Sets the phone ID.
     *
     * @param phoneID the new phone ID
     */
    public void setPhoneID(Phone phoneID) {
        this.phoneID = phoneID;
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (companyPersonPhoneID != null ? companyPersonPhoneID.hashCode() : 0);
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
        if (!(object instanceof Companypersonphone)) {
            return false;
        }
        Companypersonphone other = (Companypersonphone) object;
        if ((this.companyPersonPhoneID == null && other.companyPersonPhoneID != null) || (this.companyPersonPhoneID != null && !this.companyPersonPhoneID.equals(other.companyPersonPhoneID))) {
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
        return "domain.Companypersonphone[ companyPersonPhoneID=" + companyPersonPhoneID + " ]";
    }
    
}
