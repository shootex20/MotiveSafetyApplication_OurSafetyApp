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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Daniel Quach
 */
@Entity
@Table(name = "companypersonrole")
@NamedQueries({
    @NamedQuery(name = "Companypersonrole.findAll", query = "SELECT c FROM Companypersonrole c")})
public class Companypersonrole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "companyPersonRole_ID")
    private Integer companyPersonRoleID;
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
    @Column(name = "role")
    private Integer role;
    @OneToMany(mappedBy = "companyPersonRoleID", fetch = FetchType.EAGER)
    private List<Positions> positionsList;
    @JoinColumn(name = "companyPerson_ID", referencedColumnName = "companyPerson_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Companyperson companyPersonID;

    public Companypersonrole() {
    }

    public Companypersonrole(Integer companyPersonRoleID) {
        this.companyPersonRoleID = companyPersonRoleID;
    }

    public Integer getCompanyPersonRoleID() {
        return companyPersonRoleID;
    }

    public void setCompanyPersonRoleID(Integer companyPersonRoleID) {
        this.companyPersonRoleID = companyPersonRoleID;
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

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public List<Positions> getPositionsList() {
        return positionsList;
    }

    public void setPositionsList(List<Positions> positionsList) {
        this.positionsList = positionsList;
    }

    public Companyperson getCompanyPersonID() {
        return companyPersonID;
    }

    public void setCompanyPersonID(Companyperson companyPersonID) {
        this.companyPersonID = companyPersonID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (companyPersonRoleID != null ? companyPersonRoleID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Companypersonrole)) {
            return false;
        }
        Companypersonrole other = (Companypersonrole) object;
        if ((this.companyPersonRoleID == null && other.companyPersonRoleID != null) || (this.companyPersonRoleID != null && !this.companyPersonRoleID.equals(other.companyPersonRoleID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Companypersonrole[ companyPersonRoleID=" + companyPersonRoleID + " ]";
    }
    
}
