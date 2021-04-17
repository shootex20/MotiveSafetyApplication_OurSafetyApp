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
 * The Class Emergencycontact.
 *
 * @author Chels
 */
@Entity
@Table(name = "emergencycontact")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Emergencycontact.findAll", query = "SELECT e FROM Emergencycontact e")
    , @NamedQuery(name = "Emergencycontact.findByEmergencyContactID", query = "SELECT e FROM Emergencycontact e WHERE e.emergencyContactID = :emergencyContactID")
    , @NamedQuery(name = "Emergencycontact.findByDateAdded", query = "SELECT e FROM Emergencycontact e WHERE e.dateAdded = :dateAdded")
    , @NamedQuery(name = "Emergencycontact.findByDateRemoved", query = "SELECT e FROM Emergencycontact e WHERE e.dateRemoved = :dateRemoved")
    , @NamedQuery(name = "Emergencycontact.findByUserAdded", query = "SELECT e FROM Emergencycontact e WHERE e.userAdded = :userAdded")
    , @NamedQuery(name = "Emergencycontact.findByUserRemoved", query = "SELECT e FROM Emergencycontact e WHERE e.userRemoved = :userRemoved")
    , @NamedQuery(name = "Emergencycontact.findByEmergencyContactFirstName", query = "SELECT e FROM Emergencycontact e WHERE e.emergencyContactFirstName = :emergencyContactFirstName")
    , @NamedQuery(name = "Emergencycontact.findByEmergencyContactLastName", query = "SELECT e FROM Emergencycontact e WHERE e.emergencyContactLastName = :emergencyContactLastName")
    , @NamedQuery(name = "Emergencycontact.findByEmergencyContactNumber", query = "SELECT e FROM Emergencycontact e WHERE e.emergencyContactNumber = :emergencyContactNumber")
    , @NamedQuery(name = "Emergencycontact.findByEmergencyContactRelationship", query = "SELECT e FROM Emergencycontact e WHERE e.emergencyContactRelationship = :emergencyContactRelationship")})
public class Emergencycontact implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    /** The emergency contact ID. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "emergencyContact_ID", insertable = false)
    private Integer emergencyContactID;
    
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
    
    /** The emergency contact first name. */
    @Column(name = "emergencyContactFirstName")
    private String emergencyContactFirstName;
    
    /** The emergency contact last name. */
    @Column(name = "emergencyContactLastName")
    private String emergencyContactLastName;
    
    /** The emergency contact number. */
    @Column(name = "emergencyContactNumber")
    private String emergencyContactNumber;
    
    /** The emergency contact relationship. */
    @Column(name = "emergencyContactRelationship")
    private String emergencyContactRelationship;
    
    /** The person list. */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true, mappedBy = "emergencyContactID", fetch = FetchType.EAGER)
    private List<Person> personList;

    /**
     * Instantiates a new emergencycontact.
     */
    public Emergencycontact() {
    }

    /**
     * Instantiates a new emergencycontact.
     *
     * @param dateAdded the date added
     * @param userAdded the user added
     * @param emergencyContactFirstName the emergency contact first name
     * @param emergencyContactLastName the emergency contact last name
     * @param emergencyContactNumber the emergency contact number
     * @param emergencyContactRelationship the emergency contact relationship
     */
    public Emergencycontact(Date dateAdded, Integer userAdded, String emergencyContactFirstName, String emergencyContactLastName, 
            String emergencyContactNumber, String emergencyContactRelationship)
    {
        
        this.dateAdded = dateAdded;
        this.userAdded = userAdded;
        this.emergencyContactFirstName = emergencyContactFirstName;
        this.emergencyContactLastName = emergencyContactLastName;
        this.emergencyContactNumber = emergencyContactNumber;
        this.emergencyContactRelationship = emergencyContactRelationship;  
        //this.personList = personList;
    }
    
    /**
     * Instantiates a new emergencycontact.
     *
     * @param emergencyContactID the emergency contact ID
     */
    public Emergencycontact(Integer emergencyContactID) {
        this.emergencyContactID = emergencyContactID;
    }

    /**
     * Gets the emergency contact ID.
     *
     * @return the emergency contact ID
     */
    public Integer getEmergencyContactID() {
        return emergencyContactID;
    }

    /**
     * Sets the emergency contact ID.
     *
     * @param emergencyContactID the new emergency contact ID
     */
    public void setEmergencyContactID(Integer emergencyContactID) {
        this.emergencyContactID = emergencyContactID;
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
     * Gets the emergency contact first name.
     *
     * @return the emergency contact first name
     */
    public String getEmergencyContactFirstName() {
        return emergencyContactFirstName;
    }

    /**
     * Sets the emergency contact first name.
     *
     * @param emergencyContactFirstName the new emergency contact first name
     */
    public void setEmergencyContactFirstName(String emergencyContactFirstName) {
        this.emergencyContactFirstName = emergencyContactFirstName;
    }

    /**
     * Gets the emergency contact last name.
     *
     * @return the emergency contact last name
     */
    public String getEmergencyContactLastName() {
        return emergencyContactLastName;
    }

    /**
     * Sets the emergency contact last name.
     *
     * @param emergencyContactLastName the new emergency contact last name
     */
    public void setEmergencyContactLastName(String emergencyContactLastName) {
        this.emergencyContactLastName = emergencyContactLastName;
    }

    /**
     * Gets the emergency contact number.
     *
     * @return the emergency contact number
     */
    public String getEmergencyContactNumber() {
        return emergencyContactNumber;
    }

    /**
     * Sets the emergency contact number.
     *
     * @param emergencyContactNumber the new emergency contact number
     */
    public void setEmergencyContactNumber(String emergencyContactNumber) {
        this.emergencyContactNumber = emergencyContactNumber;
    }

    /**
     * Gets the emergency contact relationship.
     *
     * @return the emergency contact relationship
     */
    public String getEmergencyContactRelationship() {
        return emergencyContactRelationship;
    }

    /**
     * Sets the emergency contact relationship.
     *
     * @param emergencyContactRelationship the new emergency contact relationship
     */
    public void setEmergencyContactRelationship(String emergencyContactRelationship) {
        this.emergencyContactRelationship = emergencyContactRelationship;
    }

    /**
     * Gets the person list.
     *
     * @return the person list
     */
    @XmlTransient
    public List<Person> getPersonList() {
        return personList;
    }

    /**
     * Sets the person list.
     *
     * @param personList the new person list
     */
    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emergencyContactID != null ? emergencyContactID.hashCode() : 0);
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
        if (!(object instanceof Emergencycontact)) {
            return false;
        }
        Emergencycontact other = (Emergencycontact) object;
        if ((this.emergencyContactID == null && other.emergencyContactID != null) || (this.emergencyContactID != null && !this.emergencyContactID.equals(other.emergencyContactID))) {
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
        return "domain.Emergencycontact[ emergencyContactID=" + emergencyContactID + " ]";
    }
    
}
