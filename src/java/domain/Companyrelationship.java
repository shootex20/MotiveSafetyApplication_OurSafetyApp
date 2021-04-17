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
 * The Class Companyrelationship.
 *
 * @author Chels
 */
@Entity
@Table(name = "companyrelationship")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Companyrelationship.findAll", query = "SELECT c FROM Companyrelationship c")
    , @NamedQuery(name = "Companyrelationship.findByCompanyRelationshipID", query = "SELECT c FROM Companyrelationship c WHERE c.companyRelationshipID = :companyRelationshipID")
    , @NamedQuery(name = "Companyrelationship.findByDateAdded", query = "SELECT c FROM Companyrelationship c WHERE c.dateAdded = :dateAdded")
    , @NamedQuery(name = "Companyrelationship.findByDateRemoved", query = "SELECT c FROM Companyrelationship c WHERE c.dateRemoved = :dateRemoved")
    , @NamedQuery(name = "Companyrelationship.findByUserAdded", query = "SELECT c FROM Companyrelationship c WHERE c.userAdded = :userAdded")
    , @NamedQuery(name = "Companyrelationship.findByUserRemoved", query = "SELECT c FROM Companyrelationship c WHERE c.userRemoved = :userRemoved")
    , @NamedQuery(name = "Companyrelationship.findByParent", query = "SELECT c FROM Companyrelationship c WHERE c.parent = :parent")
    , @NamedQuery(name = "Companyrelationship.findByChild", query = "SELECT c FROM Companyrelationship c WHERE c.child = :child")})
public class Companyrelationship implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    /** The company relationship ID. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "companyRelationship_ID")
    private Integer companyRelationshipID;
    
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
    
    /** The parent. */
    @Column(name = "parent")
    private Integer parent;
    
    /** The child. */
    @Column(name = "child")
    private Integer child;
    
    /** The company ID. */
    @JoinColumn(name = "company_ID", referencedColumnName = "company_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Company companyID;
    
    /** The type library ID. */
    @JoinColumn(name = "typeLibrary_ID", referencedColumnName = "typeLibrary_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Typelibrary typeLibraryID;

    /**
     * Instantiates a new companyrelationship.
     */
    public Companyrelationship() {
    }

    /**
     * Instantiates a new companyrelationship.
     *
     * @param companyRelationshipID the company relationship ID
     */
    public Companyrelationship(Integer companyRelationshipID) {
        this.companyRelationshipID = companyRelationshipID;
    }

    /**
     * Gets the company relationship ID.
     *
     * @return the company relationship ID
     */
    public Integer getCompanyRelationshipID() {
        return companyRelationshipID;
    }

    /**
     * Sets the company relationship ID.
     *
     * @param companyRelationshipID the new company relationship ID
     */
    public void setCompanyRelationshipID(Integer companyRelationshipID) {
        this.companyRelationshipID = companyRelationshipID;
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
     * Gets the parent.
     *
     * @return the parent
     */
    public Integer getParent() {
        return parent;
    }

    /**
     * Sets the parent.
     *
     * @param parent the new parent
     */
    public void setParent(Integer parent) {
        this.parent = parent;
    }

    /**
     * Gets the child.
     *
     * @return the child
     */
    public Integer getChild() {
        return child;
    }

    /**
     * Sets the child.
     *
     * @param child the new child
     */
    public void setChild(Integer child) {
        this.child = child;
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
        hash += (companyRelationshipID != null ? companyRelationshipID.hashCode() : 0);
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
        if (!(object instanceof Companyrelationship)) {
            return false;
        }
        Companyrelationship other = (Companyrelationship) object;
        if ((this.companyRelationshipID == null && other.companyRelationshipID != null) || (this.companyRelationshipID != null && !this.companyRelationshipID.equals(other.companyRelationshipID))) {
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
        return "domain.Companyrelationship[ companyRelationshipID=" + companyRelationshipID + " ]";
    }
    
}
