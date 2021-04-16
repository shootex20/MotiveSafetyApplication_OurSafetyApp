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
@Table(name = "companypersonphone")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Companypersonphone.findAll", query = "SELECT c FROM Companypersonphone c")
    , @NamedQuery(name = "Companypersonphone.findByCompanyPersonPhoneID", query = "SELECT c FROM Companypersonphone c WHERE c.companyPersonPhoneID = :companyPersonPhoneID")
    , @NamedQuery(name = "Companypersonphone.findByDateAdded", query = "SELECT c FROM Companypersonphone c WHERE c.dateAdded = :dateAdded")
    , @NamedQuery(name = "Companypersonphone.findByDateRemoved", query = "SELECT c FROM Companypersonphone c WHERE c.dateRemoved = :dateRemoved")
    , @NamedQuery(name = "Companypersonphone.findByUserAdded", query = "SELECT c FROM Companypersonphone c WHERE c.userAdded = :userAdded")
    , @NamedQuery(name = "Companypersonphone.findByUserRemoved", query = "SELECT c FROM Companypersonphone c WHERE c.userRemoved = :userRemoved")})
public class Companypersonphone implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "companyPersonPhone_ID", insertable = false)
    private Integer companyPersonPhoneID;
    @Column(name = "dateAdded")
    @Temporal(TemporalType.DATE)
    private Date dateAdded;
    @Column(name = "dateRemoved", insertable = false)
    @Temporal(TemporalType.DATE)
    private Date dateRemoved;
    @Column(name = "userAdded")
    private Integer userAdded;
    @Column(name = "userRemoved", insertable = false)
    private Integer userRemoved;
    @JoinColumn(name = "phone_ID", referencedColumnName = "phone_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Phone phoneID;
    @JoinColumn(name = "companyPerson_ID", referencedColumnName = "companyPerson_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Companyperson companyPersonID;

    /**
     *
     */
    public Companypersonphone() {
    }

    /**
     *
     * @param companyPersonPhoneID
     */
    public Companypersonphone(Integer companyPersonPhoneID) {
        this.companyPersonPhoneID = companyPersonPhoneID;
    }
    
    /**
     *
     * @param dateAdded
     * @param userAdded
     * @param companyPersonID
     * @param phoneID
     */
    public Companypersonphone(Date dateAdded, Integer userAdded, Companyperson companyPersonID, Phone phoneID) {
        this.dateAdded = dateAdded;
        this.userAdded = userAdded;
        this.companyPersonID = companyPersonID;
        this.phoneID = phoneID;
    }
    
    /**
     *
     * @return
     */
    public Integer getCompanyPersonPhoneID() {
        return companyPersonPhoneID;
    }

    /**
     *
     * @param companyPersonPhoneID
     */
    public void setCompanyPersonPhoneID(Integer companyPersonPhoneID) {
        this.companyPersonPhoneID = companyPersonPhoneID;
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
    public Companyperson getCompanyPersonID() {
        return companyPersonID;
    }

    /**
     *
     * @param companyPersonID
     */
    public void setCompanyPersonID(Companyperson companyPersonID) {
        this.companyPersonID = companyPersonID;
    }

    /**
     *
     * @return
     */
    public Phone getPhoneID() {
        return phoneID;
    }

    /**
     *
     * @param phoneID
     */
    public void setPhoneID(Phone phoneID) {
        this.phoneID = phoneID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (companyPersonPhoneID != null ? companyPersonPhoneID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Companypersonphone)) {
            return false;
        }
        Companypersonphone other = (Companypersonphone) object;
        if ((this.companyPersonPhoneID == null && other.companyPersonPhoneID != null) || (this.companyPersonPhoneID != null && !this.companyPersonPhoneID.equals(other.companyPersonPhoneID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Companypersonphone[ companyPersonPhoneID=" + companyPersonPhoneID + " ]";
    }
    
}
