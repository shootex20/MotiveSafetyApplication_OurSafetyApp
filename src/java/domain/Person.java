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
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Chels
 */
@Entity
@Table(name = "person")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p")
    , @NamedQuery(name = "Person.findByPersonID", query = "SELECT p FROM Person p WHERE p.personID = :personID")
    , @NamedQuery(name = "Person.findByDateAdded", query = "SELECT p FROM Person p WHERE p.dateAdded = :dateAdded")
    , @NamedQuery(name = "Person.findByDateRemoved", query = "SELECT p FROM Person p WHERE p.dateRemoved = :dateRemoved")
    , @NamedQuery(name = "Person.findByUserAdded", query = "SELECT p FROM Person p WHERE p.userAdded = :userAdded")
    , @NamedQuery(name = "Person.findByUserRemoved", query = "SELECT p FROM Person p WHERE p.userRemoved = :userRemoved")
    , @NamedQuery(name = "Person.findByFirstName", query = "SELECT p FROM Person p WHERE p.firstName = :firstName")
    , @NamedQuery(name = "Person.findByLastName", query = "SELECT p FROM Person p WHERE p.lastName = :lastName")
    , @NamedQuery(name = "Person.findByDateOfBirth", query = "SELECT p FROM Person p WHERE p.dateOfBirth = :dateOfBirth")
    , @NamedQuery(name = "Person.findByGender", query = "SELECT p FROM Person p WHERE p.gender = :gender")
    , @NamedQuery(name = "Person.findByFields", query = "SELECT p FROM Person p WHERE p.firstName = :firstName AND p.lastName = :lastName AND p.dateOfBirth = :dateOfBirth")})
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "person_ID", insertable = false)
    private Integer personID;
    @Column(name = "dateAdded")
    @Temporal(TemporalType.DATE)
    private Date dateAdded;
    @Column(name = "dateRemoved", insertable = false)
    @Temporal(TemporalType.DATE)
    private Date dateRemoved;
    @Column(name = "userAdded")
    private Integer userAdded;
    @Column(name = "userRemoved", insertable = false)
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
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "personID", fetch = FetchType.EAGER)
    private List<Companyperson> companypersonList;
    @JoinColumn(name = "emergencyContact_ID", referencedColumnName = "emergencyContact_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Emergencycontact emergencyContactID;

    public Person() {
    }

    public Person(Date dateAdded, Integer userAdded, String firstName, String lastName, Date dateOfBirth, Character gender, Emergencycontact emergencyContactID) {
        this.dateAdded = dateAdded;
        this.userAdded = userAdded;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.emergencyContactID = emergencyContactID;
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

    @XmlTransient
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
