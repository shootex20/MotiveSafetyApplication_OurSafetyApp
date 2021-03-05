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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Chels
 */
@Entity
@Table(name = "companypositions")
@NamedQueries({
    @NamedQuery(name = "Companypositions.findAll", query = "SELECT c FROM Companypositions c")})
public class Companypositions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "companyPositions_ID", insertable=false)
    private Integer companyPositionsID;
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
    @Column(name = "company_ID")
    private Integer companyID;
    @Column(name = "companyPerson_ID")
    private Integer companyPersonID;
    @Column(name = "positionTitle")
    private String positionTitle;

    public Companypositions() {
    }

    public Companypositions(Integer companyPositionsID) {
        this.companyPositionsID = companyPositionsID;
    }

    public Integer getCompanyPositionsID() {
        return companyPositionsID;
    }

    public void setCompanyPositionsID(Integer companyPositionsID) {
        this.companyPositionsID = companyPositionsID;
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

    public Integer getCompanyPersonID() {
        return companyPersonID;
    }

    public void setCompanyPersonID(Integer companyPersonID) {
        this.companyPersonID = companyPersonID;
    }

    public String getPositionTitle() {
        return positionTitle;
    }

    public void setPositionTitle(String positionTitle) {
        this.positionTitle = positionTitle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (companyPositionsID != null ? companyPositionsID.hashCode() : 0);
        return hash;
    }

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

    @Override
    public String toString() {
        return "domain.Companypositions[ companyPositionsID=" + companyPositionsID + " ]";
    }
    
}
