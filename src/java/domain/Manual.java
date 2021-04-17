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
 * The Class Manual.
 *
 * @author Chels
 */
@Entity
@Table(name = "manual")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Manual.findAll", query = "SELECT m FROM Manual m")
    , @NamedQuery(name = "Manual.findByManualID", query = "SELECT m FROM Manual m WHERE m.manualID = :manualID")
    , @NamedQuery(name = "Manual.findByDateAdded", query = "SELECT m FROM Manual m WHERE m.dateAdded = :dateAdded")
    , @NamedQuery(name = "Manual.findByDateRemoved", query = "SELECT m FROM Manual m WHERE m.dateRemoved = :dateRemoved")
    , @NamedQuery(name = "Manual.findByUserAdded", query = "SELECT m FROM Manual m WHERE m.userAdded = :userAdded")
    , @NamedQuery(name = "Manual.findByUserRemoved", query = "SELECT m FROM Manual m WHERE m.userRemoved = :userRemoved")
    , @NamedQuery(name = "Manual.findByParent", query = "SELECT m FROM Manual m WHERE m.parent = :parent")
    , @NamedQuery(name = "Manual.findByTitle", query = "SELECT m FROM Manual m WHERE m.title = :title")
    , @NamedQuery(name = "Manual.findByIntention", query = "SELECT m FROM Manual m WHERE m.intention = :intention")
    , @NamedQuery(name = "Manual.findByOverview", query = "SELECT m FROM Manual m WHERE m.overview = :overview")
    , @NamedQuery(name = "Manual.findByContent", query = "SELECT m FROM Manual m WHERE m.content = :content")})
public class Manual implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    /** The manual ID. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "manual_ID")
    private Integer manualID;
    
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
    
    /** The parent. */
    @Column(name = "parent")
    private Integer parent;
    
    /** The title. */
    @Column(name = "title")
    private String title;
    
    /** The intention. */
    @Column(name = "intention")
    private String intention;
    
    /** The overview. */
    @Column(name = "overview")
    private String overview;
    
    /** The content. */
    @Column(name = "content")
    private String content;
    
    /** The type library ID. */
    @JoinColumn(name = "typeLibrary_ID", referencedColumnName = "typeLibrary_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Typelibrary typeLibraryID;
    
    /** The manualuse list. */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true, mappedBy = "manualID", fetch = FetchType.EAGER)
    private List<Manualuse> manualuseList;

    /**
     * Instantiates a new manual.
     */
    public Manual() {
    }

    /**
     * Instantiates a new manual.
     *
     * @param dateAdded the date added
     * @param userAdded the user added
     * @param typeLibraryID the type library ID
     * @param title the title
     * @param intention the intention
     * @param content the content
     */
    public Manual(Date dateAdded, int userAdded,Typelibrary typeLibraryID, String title, String intention, String content ){
        this.dateAdded = dateAdded;
        this.userAdded = userAdded;
        this.typeLibraryID = typeLibraryID;
        this.title = title;
        this.intention = intention;
        this.content = content;
    }
    
    /**
     * Instantiates a new manual.
     *
     * @param manualID the manual ID
     */
    public Manual(Integer manualID) {
        this.manualID = manualID;
    }

    /**
     * Gets the manual ID.
     *
     * @return the manual ID
     */
    public Integer getManualID() {
        return manualID;
    }

    /**
     * Sets the manual ID.
     *
     * @param manualID the new manual ID
     */
    public void setManualID(Integer manualID) {
        this.manualID = manualID;
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
     * Gets the parent.
     *
     * @return the parent
     */
    public Integer getParent() {
        return parent;
    }

    /**
     * Sets the parent.
     *
     * @param parent the new parent
     */
    public void setParent(Integer parent) {
        this.parent = parent;
    }

    /**
     * Gets the title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title.
     *
     * @param title the new title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the intention.
     *
     * @return the intention
     */
    public String getIntention() {
        return intention;
    }

    /**
     * Sets the intention.
     *
     * @param intention the new intention
     */
    public void setIntention(String intention) {
        this.intention = intention;
    }

    /**
     * Gets the overview.
     *
     * @return the overview
     */
    public String getOverview() {
        return overview;
    }

    /**
     * Sets the overview.
     *
     * @param overview the new overview
     */
    public void setOverview(String overview) {
        this.overview = overview;
    }

    /**
     * Gets the content.
     *
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the content.
     *
     * @param content the new content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Gets the type library ID.
     *
     * @return the type library ID
     */
    public Typelibrary getTypeLibraryID() {
        return typeLibraryID;
    }

    /**
     * Sets the type library ID.
     *
     * @param typeLibraryID the new type library ID
     */
    public void setTypeLibraryID(Typelibrary typeLibraryID) {
        this.typeLibraryID = typeLibraryID;
    }

    /**
     * Gets the manualuse list.
     *
     * @return the manualuse list
     */
    @XmlTransient
    public List<Manualuse> getManualuseList() {
        return manualuseList;
    }

    /**
     * Sets the manualuse list.
     *
     * @param manualuseList the new manualuse list
     */
    public void setManualuseList(List<Manualuse> manualuseList) {
        this.manualuseList = manualuseList;
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (manualID != null ? manualID.hashCode() : 0);
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
        if (!(object instanceof Manual)) {
            return false;
        }
        Manual other = (Manual) object;
        if ((this.manualID == null && other.manualID != null) || (this.manualID != null && !this.manualID.equals(other.manualID))) {
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
        return "domain.Manual[ manualID=" + manualID + " ]";
    }
    
}
