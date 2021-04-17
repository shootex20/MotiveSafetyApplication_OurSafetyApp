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
 * The Class Company.
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

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    /** The company ID. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "company_ID")
    private Integer companyID;
    
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
    
    /** The shortname. */
    @Column(name = "shortname")
    private String shortname;
    
    /** The name. */
    @Column(name = "name")
    private String name;
    
    /** The description. */
    @Column(name = "description")
    private String description;
    
    /** The salt hash. */
    @Column(name = "saltHash")
    private String saltHash;
    
    /** The account. */
    @Column(name = "account")
    private String account;
    
    /** The industry. */
    @Column(name = "industry")
    private String industry;
    
    /** The item list. */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true, mappedBy = "companyID", fetch = FetchType.EAGER)
    private List<Item> itemList;
    
    /** The companyperson list. */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true, mappedBy = "companyID", fetch = FetchType.EAGER)
    private List<Companyperson> companypersonList;
    
    /** The url list. */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true, mappedBy = "companyID", fetch = FetchType.EAGER)
    private List<Url> urlList;
    
    /** The companypositions list. */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true, mappedBy = "companyID", fetch = FetchType.EAGER)
    private List<Companypositions> companypositionsList;
    
    /** The companytype list. */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true, mappedBy = "companyID", fetch = FetchType.EAGER)
    private List<Companytype> companytypeList;
    
    /** The logins list. */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true, mappedBy = "companyID", fetch = FetchType.EAGER)
    private List<Logins> loginsList;
    
    /** The companyrelationship list. */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true, mappedBy = "companyID", fetch = FetchType.EAGER)
    private List<Companyrelationship> companyrelationshipList;

    /**
     * Instantiates a new company.
     */
    public Company() {
    }

    /**
     * Instantiates a new company.
     *
     * @param companyID the company ID
     */
    public Company(Integer companyID) {
        this.companyID = companyID;
    }

    /**
     * Instantiates a new company.
     *
     * @param dateAdded the date added
     * @param name the name
     * @param shortname the shortname
     * @param description the description
     * @param account the account
     * @param industry the industry
     */
    public Company(Date dateAdded, String name, String shortname, String description, String account, String industry) {
        this.dateAdded = dateAdded;
        this.name = name;
        this.shortname = shortname;
        this.description = description;
        this.account = account;
        this.industry = industry;
               
    }

    /**
     * Gets the company ID.
     *
     * @return the company ID
     */
    public Integer getCompanyID() {
        return companyID;
    }

    /**
     * Sets the company ID.
     *
     * @param companyID the new company ID
     */
    public void setCompanyID(Integer companyID) {
        this.companyID = companyID;
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
     * Gets the shortname.
     *
     * @return the shortname
     */
    public String getShortname() {
        return shortname;
    }

    /**
     * Sets the shortname.
     *
     * @param shortname the new shortname
     */
    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description.
     *
     * @param description the new description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the salt hash.
     *
     * @return the salt hash
     */
    public String getSaltHash() {
        return saltHash;
    }

    /**
     * Sets the salt hash.
     *
     * @param saltHash the new salt hash
     */
    public void setSaltHash(String saltHash) {
        this.saltHash = saltHash;
    }

    /**
     * Gets the account.
     *
     * @return the account
     */
    public String getAccount() {
        return account;
    }

    /**
     * Sets the account.
     *
     * @param account the new account
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * Gets the industry.
     *
     * @return the industry
     */
    public String getIndustry() {
        return industry;
    }

    /**
     * Sets the industry.
     *
     * @param industry the new industry
     */
    public void setIndustry(String industry) {
        this.industry = industry;
    }

    /**
     * Gets the item list.
     *
     * @return the item list
     */
    @XmlTransient
    public List<Item> getItemList() {
        return itemList;
    }

    /**
     * Sets the item list.
     *
     * @param itemList the new item list
     */
    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    /**
     * Gets the companyperson list.
     *
     * @return the companyperson list
     */
    @XmlTransient
    public List<Companyperson> getCompanypersonList() {
        return companypersonList;
    }

    /**
     * Sets the companyperson list.
     *
     * @param companypersonList the new companyperson list
     */
    public void setCompanypersonList(List<Companyperson> companypersonList) {
        this.companypersonList = companypersonList;
    }

    /**
     * Gets the url list.
     *
     * @return the url list
     */
    @XmlTransient
    public List<Url> getUrlList() {
        return urlList;
    }

    /**
     * Sets the url list.
     *
     * @param urlList the new url list
     */
    public void setUrlList(List<Url> urlList) {
        this.urlList = urlList;
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
     * Gets the companytype list.
     *
     * @return the companytype list
     */
    @XmlTransient
    public List<Companytype> getCompanytypeList() {
        return companytypeList;
    }

    /**
     * Sets the companytype list.
     *
     * @param companytypeList the new companytype list
     */
    public void setCompanytypeList(List<Companytype> companytypeList) {
        this.companytypeList = companytypeList;
    }

    /**
     * Gets the logins list.
     *
     * @return the logins list
     */
    @XmlTransient
    public List<Logins> getLoginsList() {
        return loginsList;
    }

    /**
     * Sets the logins list.
     *
     * @param loginsList the new logins list
     */
    public void setLoginsList(List<Logins> loginsList) {
        this.loginsList = loginsList;
    }

    /**
     * Gets the companyrelationship list.
     *
     * @return the companyrelationship list
     */
    @XmlTransient
    public List<Companyrelationship> getCompanyrelationshipList() {
        return companyrelationshipList;
    }

    /**
     * Sets the companyrelationship list.
     *
     * @param companyrelationshipList the new companyrelationship list
     */
    public void setCompanyrelationshipList(List<Companyrelationship> companyrelationshipList) {
        this.companyrelationshipList = companyrelationshipList;
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (companyID != null ? companyID.hashCode() : 0);
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
        if (!(object instanceof Company)) {
            return false;
        }
        Company other = (Company) object;
        if ((this.companyID == null && other.companyID != null) || (this.companyID != null && !this.companyID.equals(other.companyID))) {
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
        return "domain.Company[ companyID=" + companyID + " ]";
    }
    
}
