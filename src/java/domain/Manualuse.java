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
 * The Class Manualuse.
 *
 * @author Chels
 */
@Entity
@Table(name = "manualuse")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Manualuse.findAll", query = "SELECT m FROM Manualuse m")
    , @NamedQuery(name = "Manualuse.findByManualUseID", query = "SELECT m FROM Manualuse m WHERE m.manualUseID = :manualUseID")
    , @NamedQuery(name = "Manualuse.findByDateAdded", query = "SELECT m FROM Manualuse m WHERE m.dateAdded = :dateAdded")
    , @NamedQuery(name = "Manualuse.findByDateRemoved", query = "SELECT m FROM Manualuse m WHERE m.dateRemoved = :dateRemoved")
    , @NamedQuery(name = "Manualuse.findByUserAdded", query = "SELECT m FROM Manualuse m WHERE m.userAdded = :userAdded")
    , @NamedQuery(name = "Manualuse.findByUserRemoved", query = "SELECT m FROM Manualuse m WHERE m.userRemoved = :userRemoved")
    , @NamedQuery(name = "Manualuse.findByCompanyID", query = "SELECT m FROM Manualuse m WHERE m.companyID = :companyID")
    , @NamedQuery(name = "Manualuse.findByCompanyRole", query = "SELECT m FROM Manualuse m WHERE m.companyRole = :companyRole")
    , @NamedQuery(name = "Manualuse.findByJob", query = "SELECT m FROM Manualuse m WHERE m.job = :job")})
public class Manualuse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    /** The manual use ID. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "manualUse_ID")
    private Integer manualUseID;
    
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
    @Column(name = "company_ID")
    private Integer companyID;
    
    /** The company role. */
    @Column(name = "companyRole")
    private Integer companyRole;
    
    /** The job. */
    @Column(name = "job")
    private Integer job;
    
    /** The manual ID. */
    @JoinColumn(name = "manual_ID", referencedColumnName = "manual_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Manual manualID;

    /**
     * Instantiates a new manualuse.
     */
    public Manualuse() {
    }

    /**
     * Instantiates a new manualuse.
     *
     * @param manualUseID the manual use ID
     */
    public Manualuse(Integer manualUseID) {
        this.manualUseID = manualUseID;
    }

    /**
     * Gets the manual use ID.
     *
     * @return the manual use ID
     */
    public Integer getManualUseID() {
        return manualUseID;
    }

    /**
     * Sets the manual use ID.
     *
     * @param manualUseID the new manual use ID
     */
    public void setManualUseID(Integer manualUseID) {
        this.manualUseID = manualUseID;
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
    public Integer getCompanyID() {
        return companyID;
    }

    /**
     * Sets the company ID.
     *
     * @param companyID the new company ID
     */
    public void setCompanyID(Integer companyID) {
        this.companyID = companyID;
    }

    /**
     * Gets the company role.
     *
     * @return the company role
     */
    public Integer getCompanyRole() {
        return companyRole;
    }

    /**
     * Sets the company role.
     *
     * @param companyRole the new company role
     */
    public void setCompanyRole(Integer companyRole) {
        this.companyRole = companyRole;
    }

    /**
     * Gets the job.
     *
     * @return the job
     */
    public Integer getJob() {
        return job;
    }

    /**
     * Sets the job.
     *
     * @param job the new job
     */
    public void setJob(Integer job) {
        this.job = job;
    }

    /**
     * Gets the manual ID.
     *
     * @return the manual ID
     */
    public Manual getManualID() {
        return manualID;
    }

    /**
     * Sets the manual ID.
     *
     * @param manualID the new manual ID
     */
    public void setManualID(Manual manualID) {
        this.manualID = manualID;
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (manualUseID != null ? manualUseID.hashCode() : 0);
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
        if (!(object instanceof Manualuse)) {
            return false;
        }
        Manualuse other = (Manualuse) object;
        if ((this.manualUseID == null && other.manualUseID != null) || (this.manualUseID != null && !this.manualUseID.equals(other.manualUseID))) {
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
        return "domain.Manualuse[ manualUseID=" + manualUseID + " ]";
    }
    
}
