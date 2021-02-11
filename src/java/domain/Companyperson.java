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
 * @author Chels
 */
@Entity
@Table(name = "companyperson")
@NamedQueries({
    @NamedQuery(name = "Companyperson.findAll", query = "SELECT c FROM Companyperson c")})
public class Companyperson implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "companyPerson_ID")
    private Integer companyPersonID;
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
    @Column(name = "email")
    private String email;
    @OneToMany(mappedBy = "companyPersonID", fetch = FetchType.EAGER)
    private List<Companynotes> companynotesList;
    @JoinColumn(name = "company_ID", referencedColumnName = "company_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Company companyID;
    @JoinColumn(name = "person_ID", referencedColumnName = "person_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Person personID;
    @OneToMany(mappedBy = "companyPersonID", fetch = FetchType.EAGER)
    private List<Companypersonaddress> companypersonaddressList;
    @OneToMany(mappedBy = "companyPersonID", fetch = FetchType.EAGER)
    private List<Companypersonrole> companypersonroleList;
    @OneToMany(mappedBy = "companyPersonID", fetch = FetchType.EAGER)
    private List<Companypersonphone> companypersonphoneList;

    public Companyperson() {
    }

    public Companyperson(Integer companyPersonID) {
        this.companyPersonID = companyPersonID;
    }

    public Integer getCompanyPersonID() {
        return companyPersonID;
    }

    public void setCompanyPersonID(Integer companyPersonID) {
        this.companyPersonID = companyPersonID;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Companynotes> getCompanynotesList() {
        return companynotesList;
    }

    public void setCompanynotesList(List<Companynotes> companynotesList) {
        this.companynotesList = companynotesList;
    }

    public Company getCompanyID() {
        return companyID;
    }

    public void setCompanyID(Company companyID) {
        this.companyID = companyID;
    }

    public Person getPersonID() {
        return personID;
    }

    public void setPersonID(Person personID) {
        this.personID = personID;
    }

    public List<Companypersonaddress> getCompanypersonaddressList() {
        return companypersonaddressList;
    }

    public void setCompanypersonaddressList(List<Companypersonaddress> companypersonaddressList) {
        this.companypersonaddressList = companypersonaddressList;
    }

    public List<Companypersonrole> getCompanypersonroleList() {
        return companypersonroleList;
    }

    public void setCompanypersonroleList(List<Companypersonrole> companypersonroleList) {
        this.companypersonroleList = companypersonroleList;
    }

    public List<Companypersonphone> getCompanypersonphoneList() {
        return companypersonphoneList;
    }

    public void setCompanypersonphoneList(List<Companypersonphone> companypersonphoneList) {
        this.companypersonphoneList = companypersonphoneList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (companyPersonID != null ? companyPersonID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Companyperson)) {
            return false;
        }
        Companyperson other = (Companyperson) object;
        if ((this.companyPersonID == null && other.companyPersonID != null) || (this.companyPersonID != null && !this.companyPersonID.equals(other.companyPersonID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Companyperson[ companyPersonID=" + companyPersonID + " ]";
    }
    
}