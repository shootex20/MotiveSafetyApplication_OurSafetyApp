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
@Table(name = "person")
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p")})
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "person_ID")
    private Integer personID;
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
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "dateOfBirth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Column(name = "gender")
    private Character gender;
    @OneToMany(mappedBy = "personID", fetch = FetchType.EAGER)
    private List<Companyperson> companypersonList;
    @JoinColumn(name = "emergencyContact_ID", referencedColumnName = "emergencyContact_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Emergencycontact emergencyContactID;
    @OneToMany(mappedBy = "personID", fetch = FetchType.EAGER)
    private List<Logins> loginsList;

    public Person() {
    }

    public Person(Integer personID) {
        this.personID = personID;
    }

    public Integer getPersonID() {
        return personID;
    }

    public void setPersonID(Integer personID) {
        this.personID = personID;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public List<Companyperson> getCompanypersonList() {
        return companypersonList;
    }

    public void setCompanypersonList(List<Companyperson> companypersonList) {
        this.companypersonList = companypersonList;
    }

    public Emergencycontact getEmergencyContactID() {
        return emergencyContactID;
    }

    public void setEmergencyContactID(Emergencycontact emergencyContactID) {
        this.emergencyContactID = emergencyContactID;
    }

    public List<Logins> getLoginsList() {
        return loginsList;
    }

    public void setLoginsList(List<Logins> loginsList) {
        this.loginsList = loginsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personID != null ? personID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.personID == null && other.personID != null) || (this.personID != null && !this.personID.equals(other.personID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Person[ personID=" + personID + " ]";
    }
    
}
