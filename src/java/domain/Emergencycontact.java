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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    @Column(name = "emergencyContact")
    private Integer emergencyContact;
    @JoinColumn(name = "person_ID", referencedColumnName = "person_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Person personID;
    @JoinColumn(name = "typeLibrary_ID", referencedColumnName = "typeLibrary_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Typelibrary typeLibraryID;

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

    public Integer getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(Integer emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public Person getPersonID() {
        return personID;
    }

    public void setPersonID(Person personID) {
        this.personID = personID;
    }

    public Typelibrary getTypeLibraryID() {
        return typeLibraryID;
    }

    public void setTypeLibraryID(Typelibrary typeLibraryID) {
        this.typeLibraryID = typeLibraryID;
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
