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

/**
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

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "manualUse_ID")
    private Integer manualUseID;
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
    @Column(name = "company_ID")
    private Integer companyID;
    @Column(name = "companyRole")
    private Integer companyRole;
    @Column(name = "job")
    private Integer job;
    @JoinColumn(name = "manual_ID", referencedColumnName = "manual_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Manual manualID;

    public Manualuse() {
    }

    public Manualuse(Integer manualUseID) {
        this.manualUseID = manualUseID;
    }

    public Integer getManualUseID() {
        return manualUseID;
    }

    public void setManualUseID(Integer manualUseID) {
        this.manualUseID = manualUseID;
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

    public Integer getCompanyID() {
        return companyID;
    }

    public void setCompanyID(Integer companyID) {
        this.companyID = companyID;
    }

    public Integer getCompanyRole() {
        return companyRole;
    }

    public void setCompanyRole(Integer companyRole) {
        this.companyRole = companyRole;
    }

    public Integer getJob() {
        return job;
    }

    public void setJob(Integer job) {
        this.job = job;
    }

    public Manual getManualID() {
        return manualID;
    }

    public void setManualID(Manual manualID) {
        this.manualID = manualID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (manualUseID != null ? manualUseID.hashCode() : 0);
        return hash;
    }

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

    @Override
    public String toString() {
        return "domain.Manualuse[ manualUseID=" + manualUseID + " ]";
    }
    
}
