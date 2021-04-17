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
 * The Class Companyperson.
 *
 * @author Chels
 */
@Entity
@Table(name = "companyperson")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Companyperson.findAll", query = "SELECT c FROM Companyperson c")
    , @NamedQuery(name = "Companyperson.findByCompanyPersonID", query = "SELECT c FROM Companyperson c WHERE c.companyPersonID = :companyPersonID")
    , @NamedQuery(name = "Companyperson.findByDateAdded", query = "SELECT c FROM Companyperson c WHERE c.dateAdded = :dateAdded")
    , @NamedQuery(name = "Companyperson.findByDateRemoved", query = "SELECT c FROM Companyperson c WHERE c.dateRemoved = :dateRemoved")
    , @NamedQuery(name = "Companyperson.findByUserAdded", query = "SELECT c FROM Companyperson c WHERE c.userAdded = :userAdded")
    , @NamedQuery(name = "Companyperson.findByUserRemoved", query = "SELECT c FROM Companyperson c WHERE c.userRemoved = :userRemoved")
    , @NamedQuery(name = "Companyperson.findByEmail", query = "SELECT c FROM Companyperson c WHERE c.email = :email")})
public class Companyperson implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    /** The company person ID. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "companyPerson_ID", insertable = false)
    private Integer companyPersonID;
    
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
    
    /** The email. */
    @Column(name = "email")
    private String email;
    
    /** The is employee active. */
    @Basic(optional = false)
    @Column(name = "isEmployeeActive")
    private boolean isEmployeeActive;
    
    /** The companynotes list. */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "companyPersonID", fetch = FetchType.EAGER)
    private List<Companynotes> companynotesList;
    
    /** The company ID. */
    @JoinColumn(name = "company_ID", referencedColumnName = "company_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Company companyID;
    
    /** The person ID. */
    @JoinColumn(name = "person_ID", referencedColumnName = "person_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Person personID;
    
    /** The companypersonaddress list. */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "companyPersonID", fetch = FetchType.EAGER)
    private List<Companypersonaddress> companypersonaddressList;
    
    /** The companypositions list. */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "companyPersonID", fetch = FetchType.EAGER)
    private List<Companypositions> companypositionsList;
    
    /** The companypersonphone list. */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "companyPersonID", fetch = FetchType.EAGER)
    private List<Companypersonphone> companypersonphoneList;

    /**
     * Instantiates a new companyperson.
     */
    public Companyperson() {
    }

    /**
     * Instantiates a new companyperson.
     *
     * @param companyPersonID the company person ID
     */
    public Companyperson(Integer companyPersonID) {
        this.companyPersonID = companyPersonID;
    }

    /**
     * Instantiates a new companyperson.
     *
     * @param email the email
     * @param isEmployeeActive the is employee active
     * @param companyID the company ID
     * @param personID the person ID
     */
    public Companyperson(String email, boolean isEmployeeActive, Company companyID, Person personID) {
        this.dateAdded = dateAdded;
        this.email = email;
        this.isEmployeeActive = isEmployeeActive;
        this.companyID = companyID;
        this.personID = personID;
    }

    /**
     * Instantiates a new companyperson.
     *
     * @param dateAdded the date added
     * @param userAdded the user added
     * @param email the email
     * @param isEmployeeActive the is employee active
     * @param companyID the company ID
     * @param personID the person ID
     */
    public Companyperson(Date dateAdded, Integer userAdded, String email, boolean isEmployeeActive, Company companyID, Person personID) {
        this.dateAdded = dateAdded;
        this.userAdded = userAdded;
        this.email = email;
        this.isEmployeeActive = isEmployeeActive;
        this.companyID = companyID;
        this.personID = personID;
    }

    /**
     * Gets the company person ID.
     *
     * @return the company person ID
     */
    public Integer getCompanyPersonID() {
        return companyPersonID;
    }

    /**
     * Sets the company person ID.
     *
     * @param companyPersonID the new company person ID
     */
    public void setCompanyPersonID(Integer companyPersonID) {
        this.companyPersonID = companyPersonID;
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
     * Gets the email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email.
     *
     * @param email the new email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the checks if is employee active.
     *
     * @return the checks if is employee active
     */
    public boolean getIsEmployeeActive() {
        return isEmployeeActive;
    }

    /**
     * Sets the checks if is employee active.
     *
     * @param isEmployeeActive the new checks if is employee active
     */
    public void setIsEmployeeActive(boolean isEmployeeActive) {
        this.isEmployeeActive = isEmployeeActive;
    }

    /**
     * Gets the companynotes list.
     *
     * @return the companynotes list
     */
    @XmlTransient
    public List<Companynotes> getCompanynotesList() {
        return companynotesList;
    }

    /**
     * Sets the companynotes list.
     *
     * @param companynotesList the new companynotes list
     */
    public void setCompanynotesList(List<Companynotes> companynotesList) {
        this.companynotesList = companynotesList;
    }

    /**
     * Gets the company ID.
     *
     * @return the company ID
     */
    public Company getCompanyID() {
        return companyID;
    }

    /**
     * Sets the company ID.
     *
     * @param companyID the new company ID
     */
    public void setCompanyID(Company companyID) {
        this.companyID = companyID;
    }

    /**
     * Gets the person ID.
     *
     * @return the person ID
     */
    public Person getPersonID() {
        return personID;
    }

    /**
     * Sets the person ID.
     *
     * @param personID the new person ID
     */
    public void setPersonID(Person personID) {
        this.personID = personID;
    }

    /**
     * Gets the companypersonaddress list.
     *
     * @return the companypersonaddress list
     */
    @XmlTransient
    public List<Companypersonaddress> getCompanypersonaddressList() {
        return companypersonaddressList;
    }

    /**
     * Sets the companypersonaddress list.
     *
     * @param companypersonaddressList the new companypersonaddress list
     */
    public void setCompanypersonaddressList(List<Companypersonaddress> companypersonaddressList) {
        this.companypersonaddressList = companypersonaddressList;
    }

    /**
     * Gets the companypositions list.
     *
     * @return the companypositions list
     */
    @XmlTransient
    public List<Companypositions> getCompanypositionsList() {
        return companypositionsList;
    }

    /**
     * Sets the companypositions list.
     *
     * @param companypositionsList the new companypositions list
     */
    public void setCompanypositionsList(List<Companypositions> companypositionsList) {
        this.companypositionsList = companypositionsList;
    }

    /**
     * Gets the companypersonphone list.
     *
     * @return the companypersonphone list
     */
    @XmlTransient
    public List<Companypersonphone> getCompanypersonphoneList() {
        return companypersonphoneList;
    }

    /**
     * Sets the companypersonphone list.
     *
     * @param companypersonphoneList the new companypersonphone list
     */
    public void setCompanypersonphoneList(List<Companypersonphone> companypersonphoneList) {
        this.companypersonphoneList = companypersonphoneList;
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (companyPersonID != null ? companyPersonID.hashCode() : 0);
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
        if (!(object instanceof Companyperson)) {
            return false;
        }
        Companyperson other = (Companyperson) object;
        if ((this.companyPersonID == null && other.companyPersonID != null) || (this.companyPersonID != null && !this.companyPersonID.equals(other.companyPersonID))) {
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
        return "domain.Companyperson[ companyPersonID=" + companyPersonID + " ]";
    }

}
