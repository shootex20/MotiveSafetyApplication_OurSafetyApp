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

/**
 *
 * @author Chels
 */
@Entity
@Table(name = "url")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Url.findAll", query = "SELECT u FROM Url u")
    , @NamedQuery(name = "Url.findByUrlID", query = "SELECT u FROM Url u WHERE u.urlID = :urlID")
    , @NamedQuery(name = "Url.findByDateAdded", query = "SELECT u FROM Url u WHERE u.dateAdded = :dateAdded")
    , @NamedQuery(name = "Url.findByDateRemoved", query = "SELECT u FROM Url u WHERE u.dateRemoved = :dateRemoved")
    , @NamedQuery(name = "Url.findByUserAdded", query = "SELECT u FROM Url u WHERE u.userAdded = :userAdded")
    , @NamedQuery(name = "Url.findByUserRemoved", query = "SELECT u FROM Url u WHERE u.userRemoved = :userRemoved")
    , @NamedQuery(name = "Url.findByUrl", query = "SELECT u FROM Url u WHERE u.url = :url")})
public class Url implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "url_ID")
    private Integer urlID;
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
    @Column(name = "URL")
    private String url;
    @JoinColumn(name = "company_ID", referencedColumnName = "company_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Company companyID;
    @JoinColumn(name = "typeLibrary_ID", referencedColumnName = "typeLibrary_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Typelibrary typeLibraryID;

    /**
     *
     */
    public Url() {
    }

    /**
     *
     * @param urlID
     */
    public Url(Integer urlID) {
        this.urlID = urlID;
    }

    /**
     *
     * @return
     */
    public Integer getUrlID() {
        return urlID;
    }

    /**
     *
     * @param urlID
     */
    public void setUrlID(Integer urlID) {
        this.urlID = urlID;
    }

    /**
     *
     * @return
     */
    public Date getDateAdded() {
        return dateAdded;
    }

    /**
     *
     * @param dateAdded
     */
    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    /**
     *
     * @return
     */
    public Date getDateRemoved() {
        return dateRemoved;
    }

    /**
     *
     * @param dateRemoved
     */
    public void setDateRemoved(Date dateRemoved) {
        this.dateRemoved = dateRemoved;
    }

    /**
     *
     * @return
     */
    public Integer getUserAdded() {
        return userAdded;
    }

    /**
     *
     * @param userAdded
     */
    public void setUserAdded(Integer userAdded) {
        this.userAdded = userAdded;
    }

    /**
     *
     * @return
     */
    public Integer getUserRemoved() {
        return userRemoved;
    }

    /**
     *
     * @param userRemoved
     */
    public void setUserRemoved(Integer userRemoved) {
        this.userRemoved = userRemoved;
    }

    /**
     *
     * @return
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     *
     * @return
     */
    public Company getCompanyID() {
        return companyID;
    }

    /**
     *
     * @param companyID
     */
    public void setCompanyID(Company companyID) {
        this.companyID = companyID;
    }

    /**
     *
     * @return
     */
    public Typelibrary getTypeLibraryID() {
        return typeLibraryID;
    }

    /**
     *
     * @param typeLibraryID
     */
    public void setTypeLibraryID(Typelibrary typeLibraryID) {
        this.typeLibraryID = typeLibraryID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (urlID != null ? urlID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Url)) {
            return false;
        }
        Url other = (Url) object;
        if ((this.urlID == null && other.urlID != null) || (this.urlID != null && !this.urlID.equals(other.urlID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Url[ urlID=" + urlID + " ]";
    }
    
}
