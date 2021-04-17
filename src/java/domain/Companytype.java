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
 * The Class Companytype.
 *
 * @author Chels
 */
@Entity
@Table(name = "companytype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Companytype.findAll", query = "SELECT c FROM Companytype c")
    , @NamedQuery(name = "Companytype.findByCompanyTypeID", query = "SELECT c FROM Companytype c WHERE c.companyTypeID = :companyTypeID")
    , @NamedQuery(name = "Companytype.findByDateAdded", query = "SELECT c FROM Companytype c WHERE c.dateAdded = :dateAdded")
    , @NamedQuery(name = "Companytype.findByDateRemoved", query = "SELECT c FROM Companytype c WHERE c.dateRemoved = :dateRemoved")
    , @NamedQuery(name = "Companytype.findByUserAdded", query = "SELECT c FROM Companytype c WHERE c.userAdded = :userAdded")
    , @NamedQuery(name = "Companytype.findByUserRemoved", query = "SELECT c FROM Companytype c WHERE c.userRemoved = :userRemoved")})
public class Companytype implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    /** The company type ID. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "companyType_ID")
    private Integer companyTypeID;
    
    /** The date added. */
    @Column(name = "dateAdded")
    @Temporal(TemporalType.DATE)
    private Date dateAdded;
    
    /** The date removed. */
    @Column(name = "dateRemoved")
    @Temporal(TemporalType.DATE)
    private Date dateRemoved;
    
    /** The user added. */
    @Column(name = "userAdded")
    private Integer userAdded;
    
    /** The user removed. */
    @Column(name = "userRemoved")
    private Integer userRemoved;
    
    /** The company ID. */
    @JoinColumn(name = "company_ID", referencedColumnName = "company_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Company companyID;
    
    /** The type library ID. */
    @JoinColumn(name = "typeLibrary_ID", referencedColumnName = "typeLibrary_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Typelibrary typeLibraryID;

    /**
     * Instantiates a new companytype.
     */
    public Companytype() {
    }

    /**
     * Instantiates a new companytype.
     *
     * @param companyTypeID the company type ID
     */
    public Companytype(Integer companyTypeID) {
        this.companyTypeID = companyTypeID;
    }

    /**
     * Gets the company type ID.
     *
     * @return the company type ID
     */
    public Integer getCompanyTypeID() {
        return companyTypeID;
    }

    /**
     * Sets the company type ID.
     *
     * @param companyTypeID the new company type ID
     */
    public void setCompanyTypeID(Integer companyTypeID) {
        this.companyTypeID = companyTypeID;
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
     * Gets the company ID.
     *
     * @return the company ID
     */
    public Company getCompanyID() {
        return companyID;
    }

    /**
     * Sets the company ID.
     *
     * @param companyID the new company ID
     */
    public void setCompanyID(Company companyID) {
        this.companyID = companyID;
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
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (companyTypeID != null ? companyTypeID.hashCode() : 0);
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
        if (!(object instanceof Companytype)) {
            return false;
        }
        Companytype other = (Companytype) object;
        if ((this.companyTypeID == null && other.companyTypeID != null) || (this.companyTypeID != null && !this.companyTypeID.equals(other.companyTypeID))) {
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
        return "domain.Companytype[ companyTypeID=" + companyTypeID + " ]";
    }
    
}
