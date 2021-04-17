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
 * The Class Companypositions.
 *
 * @author Chels
 */
@Entity
@Table(name = "companypositions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Companypositions.findAll", query = "SELECT c FROM Companypositions c")
    , @NamedQuery(name = "Companypositions.findByCompanyPositionsID", query = "SELECT c FROM Companypositions c WHERE c.companyPositionsID = :companyPositionsID")
    , @NamedQuery(name = "Companypositions.findByDateAdded", query = "SELECT c FROM Companypositions c WHERE c.dateAdded = :dateAdded")
    , @NamedQuery(name = "Companypositions.findByDateRemoved", query = "SELECT c FROM Companypositions c WHERE c.dateRemoved = :dateRemoved")
    , @NamedQuery(name = "Companypositions.findByUserAdded", query = "SELECT c FROM Companypositions c WHERE c.userAdded = :userAdded")
    , @NamedQuery(name = "Companypositions.findByUserRemoved", query = "SELECT c FROM Companypositions c WHERE c.userRemoved = :userRemoved")
    , @NamedQuery(name = "Companypositions.findByPositionTitle", query = "SELECT c FROM Companypositions c WHERE c.positionTitle = :positionTitle")})
public class Companypositions implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    /** The company positions ID. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "companyPositions_ID", insertable = false)
    private Integer companyPositionsID;
    
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
    
    /** The position title. */
    @Column(name = "positionTitle")
    private String positionTitle;
    
    /** The company person ID. */
    @JoinColumn(name = "companyPerson_ID", referencedColumnName = "companyPerson_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Companyperson companyPersonID;
    
    /** The company ID. */
    @JoinColumn(name = "company_ID", referencedColumnName = "company_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Company companyID;

    /**
     * Instantiates a new companypositions.
     */
    public Companypositions() {
    }

    /**
     * Instantiates a new companypositions.
     *
     * @param companyPositionsID the company positions ID
     */
    public Companypositions(Integer companyPositionsID) {
        this.companyPositionsID = companyPositionsID;
    }
    
    /**
     * Instantiates a new companypositions.
     *
     * @param dateAdded the date added
     * @param userAdded the user added
     * @param positionTitle the position title
     * @param companyPersonID the company person ID
     * @param companyID the company ID
     */
    public Companypositions(Date dateAdded, Integer userAdded, String positionTitle, Companyperson companyPersonID, Company companyID) {
        
        this.dateAdded = dateAdded;
        this.userAdded = userAdded;
        this.positionTitle = positionTitle;
        this.companyPersonID = companyPersonID;
        this.companyID = companyID; 
    }
    
    /**
     * Gets the company positions ID.
     *
     * @return the company positions ID
     */
    public Integer getCompanyPositionsID() {
        return companyPositionsID;
    }

    /**
     * Sets the company positions ID.
     *
     * @param companyPositionsID the new company positions ID
     */
    public void setCompanyPositionsID(Integer companyPositionsID) {
        this.companyPositionsID = companyPositionsID;
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
     * Gets the position title.
     *
     * @return the position title
     */
    public String getPositionTitle() {
        return positionTitle;
    }

    /**
     * Sets the position title.
     *
     * @param positionTitle the new position title
     */
    public void setPositionTitle(String positionTitle) {
        this.positionTitle = positionTitle;
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
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (companyPositionsID != null ? companyPositionsID.hashCode() : 0);
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
        if (!(object instanceof Companypositions)) {
            return false;
        }
        Companypositions other = (Companypositions) object;
        if ((this.companyPositionsID == null && other.companyPositionsID != null) || (this.companyPositionsID != null && !this.companyPositionsID.equals(other.companyPositionsID))) {
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
        return "domain.Companypositions[ companyPositionsID=" + companyPositionsID + " ]";
    }
    
}
