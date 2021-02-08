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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Daniel Quach
 */
@Entity
@Table(name = "positions")
@NamedQueries({
    @NamedQuery(name = "Positions.findAll", query = "SELECT p FROM Positions p")})
public class Positions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "positions_ID")
    private Integer positionsID;
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
    @Column(name = "positionTitle")
    private String positionTitle;
    @JoinColumn(name = "companyPersonRole_ID", referencedColumnName = "companyPersonRole_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Companypersonrole companyPersonRoleID;

    public Positions() {
    }

    public Positions(Integer positionsID) {
        this.positionsID = positionsID;
    }

    public Integer getPositionsID() {
        return positionsID;
    }

    public void setPositionsID(Integer positionsID) {
        this.positionsID = positionsID;
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

    public String getPositionTitle() {
        return positionTitle;
    }

    public void setPositionTitle(String positionTitle) {
        this.positionTitle = positionTitle;
    }

    public Companypersonrole getCompanyPersonRoleID() {
        return companyPersonRoleID;
    }

    public void setCompanyPersonRoleID(Companypersonrole companyPersonRoleID) {
        this.companyPersonRoleID = companyPersonRoleID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (positionsID != null ? positionsID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Positions)) {
            return false;
        }
        Positions other = (Positions) object;
        if ((this.positionsID == null && other.positionsID != null) || (this.positionsID != null && !this.positionsID.equals(other.positionsID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Positions[ positionsID=" + positionsID + " ]";
    }
    
}
