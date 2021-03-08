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

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "manual_ID")
    private Integer manualID;
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
    @Column(name = "parent")
    private Integer parent;
    @Column(name = "title")
    private String title;
    @Column(name = "intention")
    private String intention;
    @Column(name = "overview")
    private String overview;
    @Column(name = "content")
    private String content;
    @JoinColumn(name = "typeLibrary_ID", referencedColumnName = "typeLibrary_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Typelibrary typeLibraryID;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true, mappedBy = "manualID", fetch = FetchType.EAGER)
    private List<Manualuse> manualuseList;

    public Manual() {
    }

    public Manual(Integer manualID) {
        this.manualID = manualID;
    }

    public Integer getManualID() {
        return manualID;
    }

    public void setManualID(Integer manualID) {
        this.manualID = manualID;
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

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntention() {
        return intention;
    }

    public void setIntention(String intention) {
        this.intention = intention;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Typelibrary getTypeLibraryID() {
        return typeLibraryID;
    }

    public void setTypeLibraryID(Typelibrary typeLibraryID) {
        this.typeLibraryID = typeLibraryID;
    }

    @XmlTransient
    public List<Manualuse> getManualuseList() {
        return manualuseList;
    }

    public void setManualuseList(List<Manualuse> manualuseList) {
        this.manualuseList = manualuseList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (manualID != null ? manualID.hashCode() : 0);
        return hash;
    }

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

    @Override
    public String toString() {
        return "domain.Manual[ manualID=" + manualID + " ]";
    }
    
}
