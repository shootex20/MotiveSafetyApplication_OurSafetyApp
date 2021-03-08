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

/**
 *
 * @author Chels
 */
@Entity
@Table(name = "typelibrary")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Typelibrary.findAll", query = "SELECT t FROM Typelibrary t")
    , @NamedQuery(name = "Typelibrary.findByTypeLibraryID", query = "SELECT t FROM Typelibrary t WHERE t.typeLibraryID = :typeLibraryID")
    , @NamedQuery(name = "Typelibrary.findByDateAdded", query = "SELECT t FROM Typelibrary t WHERE t.dateAdded = :dateAdded")
    , @NamedQuery(name = "Typelibrary.findByDateRemoved", query = "SELECT t FROM Typelibrary t WHERE t.dateRemoved = :dateRemoved")
    , @NamedQuery(name = "Typelibrary.findByUserAdded", query = "SELECT t FROM Typelibrary t WHERE t.userAdded = :userAdded")
    , @NamedQuery(name = "Typelibrary.findByUserRemoved", query = "SELECT t FROM Typelibrary t WHERE t.userRemoved = :userRemoved")
    , @NamedQuery(name = "Typelibrary.findByType", query = "SELECT t FROM Typelibrary t WHERE t.type = :type")
    , @NamedQuery(name = "Typelibrary.findByDescription", query = "SELECT t FROM Typelibrary t WHERE t.description = :description")
    , @NamedQuery(name = "Typelibrary.findByIsCategory", query = "SELECT t FROM Typelibrary t WHERE t.isCategory = :isCategory")})
public class Typelibrary implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "typeLibrary_ID")
    private Integer typeLibraryID;
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
    @Column(name = "type")
    private String type;
    @Column(name = "description")
    private String description;
    @Column(name = "isCategory")
    private Character isCategory;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true, mappedBy = "typeLibraryID", fetch = FetchType.EAGER)
    private List<Address> addressList;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true, mappedBy = "typeLibraryID", fetch = FetchType.EAGER)
    private List<Manual> manualList;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true, mappedBy = "typeLibraryID", fetch = FetchType.EAGER)
    private List<Url> urlList;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true, mappedBy = "typeLibraryID", fetch = FetchType.EAGER)
    private List<Phone> phoneList;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true, mappedBy = "typeLibraryID", fetch = FetchType.EAGER)
    private List<Companytype> companytypeList;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true, mappedBy = "typeLibraryID", fetch = FetchType.EAGER)
    private List<Itemclassfields> itemclassfieldsList;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true, mappedBy = "typeLibraryID", fetch = FetchType.EAGER)
    private List<Companyrelationship> companyrelationshipList;

    public Typelibrary() {
    }

    public Typelibrary(Integer typeLibraryID) {
        this.typeLibraryID = typeLibraryID;
    }

    public Integer getTypeLibraryID() {
        return typeLibraryID;
    }

    public void setTypeLibraryID(Integer typeLibraryID) {
        this.typeLibraryID = typeLibraryID;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Character getIsCategory() {
        return isCategory;
    }

    public void setIsCategory(Character isCategory) {
        this.isCategory = isCategory;
    }

    @XmlTransient
    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    @XmlTransient
    public List<Manual> getManualList() {
        return manualList;
    }

    public void setManualList(List<Manual> manualList) {
        this.manualList = manualList;
    }

    @XmlTransient
    public List<Url> getUrlList() {
        return urlList;
    }

    public void setUrlList(List<Url> urlList) {
        this.urlList = urlList;
    }

    @XmlTransient
    public List<Phone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }

    @XmlTransient
    public List<Companytype> getCompanytypeList() {
        return companytypeList;
    }

    public void setCompanytypeList(List<Companytype> companytypeList) {
        this.companytypeList = companytypeList;
    }

    @XmlTransient
    public List<Itemclassfields> getItemclassfieldsList() {
        return itemclassfieldsList;
    }

    public void setItemclassfieldsList(List<Itemclassfields> itemclassfieldsList) {
        this.itemclassfieldsList = itemclassfieldsList;
    }

    @XmlTransient
    public List<Companyrelationship> getCompanyrelationshipList() {
        return companyrelationshipList;
    }

    public void setCompanyrelationshipList(List<Companyrelationship> companyrelationshipList) {
        this.companyrelationshipList = companyrelationshipList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (typeLibraryID != null ? typeLibraryID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Typelibrary)) {
            return false;
        }
        Typelibrary other = (Typelibrary) object;
        if ((this.typeLibraryID == null && other.typeLibraryID != null) || (this.typeLibraryID != null && !this.typeLibraryID.equals(other.typeLibraryID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Typelibrary[ typeLibraryID=" + typeLibraryID + " ]";
    }
    
}
