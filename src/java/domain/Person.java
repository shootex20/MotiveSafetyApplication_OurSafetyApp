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

// TODO: Auto-generated Javadoc
/**
 * The Class Person.
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

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    /** The person ID. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "person_ID", insertable = false)
    private Integer personID;
    
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
    
    /** The first name. */
    @Column(name = "firstName")
    private String firstName;
    
    /** The last name. */
    @Column(name = "lastName")
    private String lastName;
    
    /** The date of birth. */
    @Column(name = "dateOfBirth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    
    /** The gender. */
    @Column(name = "gender")
    private Character gender;
    
    /** The companyperson list. */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "personID", fetch = FetchType.EAGER)
    private List<Companyperson> companypersonList;
    
    /** The emergency contact ID. */
    @JoinColumn(name = "emergencyContact_ID", referencedColumnName = "emergencyContact_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Emergencycontact emergencyContactID;

    /**
     * Instantiates a new person.
     */
    public Person() {
    }

    /**
     * Instantiates a new person.
     *
     * @param dateAdded the date added
     * @param userAdded the user added
     * @param firstName the first name
     * @param lastName the last name
     * @param dateOfBirth the date of birth
     * @param gender the gender
     * @param emergencyContactID the emergency contact ID
     */
    public Person(Date dateAdded, Integer userAdded, String firstName, String lastName, Date dateOfBirth, Character gender, Emergencycontact emergencyContactID) {
        this.dateAdded = dateAdded;
        this.userAdded = userAdded;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.emergencyContactID = emergencyContactID;
    }

    /**
     * Instantiates a new person.
     *
     * @param personID the person ID
     */
    public Person(Integer personID) {
        this.personID = personID;
    }

    /**
     * Gets the person ID.
     *
     * @return the person ID
     */
    public Integer getPersonID() {
        return personID;
    }

    /**
     * Sets the person ID.
     *
     * @param personID the new person ID
     */
    public void setPersonID(Integer personID) {
        this.personID = personID;
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
     * Gets the first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name.
     *
     * @param firstName the new first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name.
     *
     * @param lastName the new last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the date of birth.
     *
     * @return the date of birth
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the date of birth.
     *
     * @param dateOfBirth the new date of birth
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Gets the gender.
     *
     * @return the gender
     */
    public Character getGender() {
        return gender;
    }

    /**
     * Sets the gender.
     *
     * @param gender the new gender
     */
    public void setGender(Character gender) {
        this.gender = gender;
    }

    /**
     * Gets the companyperson list.
     *
     * @return the companyperson list
     */
    @XmlTransient
    public List<Companyperson> getCompanypersonList() {
        return companypersonList;
    }

    /**
     * Sets the companyperson list.
     *
     * @param companypersonList the new companyperson list
     */
    public void setCompanypersonList(List<Companyperson> companypersonList) {
        this.companypersonList = companypersonList;
    }

    /**
     * Gets the emergency contact ID.
     *
     * @return the emergency contact ID
     */
    public Emergencycontact getEmergencyContactID() {
        return emergencyContactID;
    }

    /**
     * Sets the emergency contact ID.
     *
     * @param emergencyContactID the new emergency contact ID
     */
    public void setEmergencyContactID(Emergencycontact emergencyContactID) {
        this.emergencyContactID = emergencyContactID;
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personID != null ? personID.hashCode() : 0);
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
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.personID == null && other.personID != null) || (this.personID != null && !this.personID.equals(other.personID))) {
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
        return "domain.Person[ personID=" + personID + " ]";
    }

}
