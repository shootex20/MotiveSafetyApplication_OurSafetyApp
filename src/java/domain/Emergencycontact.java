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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "emergencycontact")
@NamedQueries({
    @NamedQuery(name = "Emergencycontact.findAll", query = "SELECT e FROM Emergencycontact e")})
public class Emergencycontact implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "emergencyContact_ID")
    private Integer emergencyContactID;
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
    @Column(name = "emergencyContactFirstName")
    private String emergencyContactFirstName;
    @Column(name = "emergencyContactLastName")
    private String emergencyContactLastName;
    @Column(name = "emergencyContactNumber")
    private String emergencyContactNumber;
    @Column(name = "emergencyContactRelationship")
    private String emergencyContactRelationship;
    @OneToMany(mappedBy = "emergencyContactID", fetch = FetchType.EAGER)
    private List<Person> personList;

    public Emergencycontact() {
    }

    public Emergencycontact(Integer emergencyContactID) {
        this.emergencyContactID = emergencyContactID;
    }

    public Integer getEmergencyContactID() {
        return emergencyContactID;
    }

    public void setEmergencyContactID(Integer emergencyContactID) {
        this.emergencyContactID = emergencyContactID;
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

    public String getEmergencyContactFirstName() {
        return emergencyContactFirstName;
    }

    public void setEmergencyContactFirstName(String emergencyContactFirstName) {
        this.emergencyContactFirstName = emergencyContactFirstName;
    }

    public String getEmergencyContactLastName() {
        return emergencyContactLastName;
    }

    public void setEmergencyContactLastName(String emergencyContactLastName) {
        this.emergencyContactLastName = emergencyContactLastName;
    }

    public String getEmergencyContactNumber() {
        return emergencyContactNumber;
    }

    public void setEmergencyContactNumber(String emergencyContactNumber) {
        this.emergencyContactNumber = emergencyContactNumber;
    }

    public String getEmergencyContactRelationship() {
        return emergencyContactRelationship;
    }

    public void setEmergencyContactRelationship(String emergencyContactRelationship) {
        this.emergencyContactRelationship = emergencyContactRelationship;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emergencyContactID != null ? emergencyContactID.hashCode() : 0);
        return hash;
    }

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

    @Override
    public String toString() {
        return "domain.Emergencycontact[ emergencyContactID=" + emergencyContactID + " ]";
    }
    
}
