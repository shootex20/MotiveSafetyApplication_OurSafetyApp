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
import javax.xml.bind.annotation.XmlRootElement;

// TODO: Auto-generated Javadoc
/**
 * The Class Companynotes.
 *
 * @author Chels
 */
@Entity
@Table(name = "companynotes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Companynotes.findAll", query = "SELECT c FROM Companynotes c")
    , @NamedQuery(name = "Companynotes.findByCompanyNotesID", query = "SELECT c FROM Companynotes c WHERE c.companyNotesID = :companyNotesID")
    , @NamedQuery(name = "Companynotes.findByDateAdded", query = "SELECT c FROM Companynotes c WHERE c.dateAdded = :dateAdded")
    , @NamedQuery(name = "Companynotes.findByDateRemoved", query = "SELECT c FROM Companynotes c WHERE c.dateRemoved = :dateRemoved")
    , @NamedQuery(name = "Companynotes.findByUserAdded", query = "SELECT c FROM Companynotes c WHERE c.userAdded = :userAdded")
    , @NamedQuery(name = "Companynotes.findByUserRemoved", query = "SELECT c FROM Companynotes c WHERE c.userRemoved = :userRemoved")
    , @NamedQuery(name = "Companynotes.findByNoteDate", query = "SELECT c FROM Companynotes c WHERE c.noteDate = :noteDate")
    , @NamedQuery(name = "Companynotes.findByNoteIndex", query = "SELECT c FROM Companynotes c WHERE c.noteIndex = :noteIndex")
    , @NamedQuery(name = "Companynotes.findByNote", query = "SELECT c FROM Companynotes c WHERE c.note = :note")})
public class Companynotes implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    /** The company notes ID. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "companyNotes_ID")
    private Integer companyNotesID;
    
    /** The date added. */
    @Column(name = "dateAdded")
    @Temporal(TemporalType.DATE)
    private Date dateAdded;
    
    /** The date removed. */
    @Column(name = "dateRemoved")
    @Temporal(TemporalType.DATE)
    private Date dateRemoved;
    
    /** The user added. */
    @Column(name = "userAdded")
    private Integer userAdded;
    
    /** The user removed. */
    @Column(name = "userRemoved")
    private Integer userRemoved;
    
    /** The note date. */
    @Column(name = "noteDate")
    @Temporal(TemporalType.DATE)
    private Date noteDate;
    
    /** The note index. */
    @Column(name = "noteIndex")
    private Integer noteIndex;
    
    /** The note. */
    @Column(name = "note")
    private String note;
    
    /** The company person ID. */
    @JoinColumn(name = "companyPerson_ID", referencedColumnName = "companyPerson_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Companyperson companyPersonID;

    /**
     * Instantiates a new companynotes.
     */
    public Companynotes() {
    }

    /**
     * Instantiates a new companynotes.
     *
     * @param companyNotesID the company notes ID
     */
    public Companynotes(Integer companyNotesID) {
        this.companyNotesID = companyNotesID;
    }

    /**
     * Gets the company notes ID.
     *
     * @return the company notes ID
     */
    public Integer getCompanyNotesID() {
        return companyNotesID;
    }

    /**
     * Sets the company notes ID.
     *
     * @param companyNotesID the new company notes ID
     */
    public void setCompanyNotesID(Integer companyNotesID) {
        this.companyNotesID = companyNotesID;
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
     * Gets the note date.
     *
     * @return the note date
     */
    public Date getNoteDate() {
        return noteDate;
    }

    /**
     * Sets the note date.
     *
     * @param noteDate the new note date
     */
    public void setNoteDate(Date noteDate) {
        this.noteDate = noteDate;
    }

    /**
     * Gets the note index.
     *
     * @return the note index
     */
    public Integer getNoteIndex() {
        return noteIndex;
    }

    /**
     * Sets the note index.
     *
     * @param noteIndex the new note index
     */
    public void setNoteIndex(Integer noteIndex) {
        this.noteIndex = noteIndex;
    }

    /**
     * Gets the note.
     *
     * @return the note
     */
    public String getNote() {
        return note;
    }

    /**
     * Sets the note.
     *
     * @param note the new note
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * Gets the company person ID.
     *
     * @return the company person ID
     */
    public Companyperson getCompanyPersonID() {
        return companyPersonID;
    }

    /**
     * Sets the company person ID.
     *
     * @param companyPersonID the new company person ID
     */
    public void setCompanyPersonID(Companyperson companyPersonID) {
        this.companyPersonID = companyPersonID;
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (companyNotesID != null ? companyNotesID.hashCode() : 0);
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
        if (!(object instanceof Companynotes)) {
            return false;
        }
        Companynotes other = (Companynotes) object;
        if ((this.companyNotesID == null && other.companyNotesID != null) || (this.companyNotesID != null && !this.companyNotesID.equals(other.companyNotesID))) {
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
        return "domain.Companynotes[ companyNotesID=" + companyNotesID + " ]";
    }
    
}
