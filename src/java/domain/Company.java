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
@Table(name = "company")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Company.findAll", query = "SELECT c FROM Company c")
    , @NamedQuery(name = "Company.findByCompanyID", query = "SELECT c FROM Company c WHERE c.companyID = :companyID")
    , @NamedQuery(name = "Company.findByDateAdded", query = "SELECT c FROM Company c WHERE c.dateAdded = :dateAdded")
    , @NamedQuery(name = "Company.findByDateRemoved", query = "SELECT c FROM Company c WHERE c.dateRemoved = :dateRemoved")
    , @NamedQuery(name = "Company.findByUserAdded", query = "SELECT c FROM Company c WHERE c.userAdded = :userAdded")
    , @NamedQuery(name = "Company.findByUserRemoved", query = "SELECT c FROM Company c WHERE c.userRemoved = :userRemoved")
    , @NamedQuery(name = "Company.findByShortname", query = "SELECT c FROM Company c WHERE c.shortname = :shortname")
    , @NamedQuery(name = "Company.findByName", query = "SELECT c FROM Company c WHERE c.name = :name")
    , @NamedQuery(name = "Company.findByDescription", query = "SELECT c FROM Company c WHERE c.description = :description")
    , @NamedQuery(name = "Company.findBySaltHash", query = "SELECT c FROM Company c WHERE c.saltHash = :saltHash")
    , @NamedQuery(name = "Company.findByAccount", query = "SELECT c FROM Company c WHERE c.account = :account")
    , @NamedQuery(name = "Company.findByIndustry", query = "SELECT c FROM Company c WHERE c.industry = :industry")})
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "company_ID")
    private Integer companyID;
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
    @Column(name = "shortname")
    private String shortname;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "saltHash")
    private String saltHash;
    @Column(name = "account")
    private String account;
    @Column(name = "industry")
    private String industry;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true, mappedBy = "companyID", fetch = FetchType.EAGER)
    private List<Item> itemList;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true, mappedBy = "companyID", fetch = FetchType.EAGER)
    private List<Companyperson> companypersonList;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true, mappedBy = "companyID", fetch = FetchType.EAGER)
    private List<Url> urlList;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true, mappedBy = "companyID", fetch = FetchType.EAGER)
    private List<Companypositions> companypositionsList;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true, mappedBy = "companyID", fetch = FetchType.EAGER)
    private List<Companytype> companytypeList;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true, mappedBy = "companyID", fetch = FetchType.EAGER)
    private List<Logins> loginsList;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true, mappedBy = "companyID", fetch = FetchType.EAGER)
    private List<Companyrelationship> companyrelationshipList;

    public Company() {
    }

    public Company(Integer companyID) {
        this.companyID = companyID;
    }

    public Integer getCompanyID() {
        return companyID;
    }

    public void setCompanyID(Integer companyID) {
        this.companyID = companyID;
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

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSaltHash() {
        return saltHash;
    }

    public void setSaltHash(String saltHash) {
        this.saltHash = saltHash;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    @XmlTransient
    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    @XmlTransient
    public List<Companyperson> getCompanypersonList() {
        return companypersonList;
    }

    public void setCompanypersonList(List<Companyperson> companypersonList) {
        this.companypersonList = companypersonList;
    }

    @XmlTransient
    public List<Url> getUrlList() {
        return urlList;
    }

    public void setUrlList(List<Url> urlList) {
        this.urlList = urlList;
    }

    @XmlTransient
    public List<Companypositions> getCompanypositionsList() {
        return companypositionsList;
    }

    public void setCompanypositionsList(List<Companypositions> companypositionsList) {
        this.companypositionsList = companypositionsList;
    }

    @XmlTransient
    public List<Companytype> getCompanytypeList() {
        return companytypeList;
    }

    public void setCompanytypeList(List<Companytype> companytypeList) {
        this.companytypeList = companytypeList;
    }

    @XmlTransient
    public List<Logins> getLoginsList() {
        return loginsList;
    }

    public void setLoginsList(List<Logins> loginsList) {
        this.loginsList = loginsList;
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
        hash += (companyID != null ? companyID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Company)) {
            return false;
        }
        Company other = (Company) object;
        if ((this.companyID == null && other.companyID != null) || (this.companyID != null && !this.companyID.equals(other.companyID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Company[ companyID=" + companyID + " ]";
    }
    
}
