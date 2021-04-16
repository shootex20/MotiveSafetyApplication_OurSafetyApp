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
@Table(name = "companypositions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Companypositions.findAll", query = "SELECT c FROM Companypositions c")
    , @NamedQuery(name = "Companypositions.findByCompanyPositionsID", query = "SELECT c FROM Companypositions c WHERE c.companyPositionsID = :companyPositionsID")
    , @NamedQuery(name = "Companypositions.findByDateAdded", query = "SELECT c FROM Companypositions c WHERE c.dateAdded = :dateAdded")
    , @NamedQuery(name = "Companypositions.findByDateRemoved", query = "SELECT c FROM Companypositions c WHERE c.dateRemoved = :dateRemoved")
    , @NamedQuery(name = "Companypositions.findByUserAdded", query = "SELECT c FROM Companypositions c WHERE c.userAdded = :userAdded")
    , @NamedQuery(name = "Companypositions.findByUserRemoved", query = "SELECT c FROM Companypositions c WHERE c.userRemoved = :userRemoved")
    , @NamedQuery(name = "Companypositions.findByPositionTitle", query = "SELECT c FROM Companypositions c WHERE c.positionTitle = :positionTitle")})
public class Companypositions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "companyPositions_ID", insertable = false)
    private Integer companyPositionsID;
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
    @Column(name = "positionTitle")
    private String positionTitle;
    @JoinColumn(name = "companyPerson_ID", referencedColumnName = "companyPerson_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Companyperson companyPersonID;
    @JoinColumn(name = "company_ID", referencedColumnName = "company_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Company companyID;

    /**
     *
     */
    public Companypositions() {
    }

    /**
     *
     * @param companyPositionsID
     */
    public Companypositions(Integer companyPositionsID) {
        this.companyPositionsID = companyPositionsID;
    }
    
    /**
     *
     * @param dateAdded
     * @param userAdded
     * @param positionTitle
     * @param companyPersonID
     * @param companyID
     */
    public Companypositions(Date dateAdded, Integer userAdded, String positionTitle, Companyperson companyPersonID, Company companyID) {
        
        this.dateAdded = dateAdded;
        this.userAdded = userAdded;
        this.positionTitle = positionTitle;
        this.companyPersonID = companyPersonID;
        this.companyID = companyID; 
    }
    
    /**
     *
     * @return
     */
    public Integer getCompanyPositionsID() {
        return companyPositionsID;
    }

    /**
     *
     * @param companyPositionsID
     */
    public void setCompanyPositionsID(Integer companyPositionsID) {
        this.companyPositionsID = companyPositionsID;
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
    public String getPositionTitle() {
        return positionTitle;
    }

    /**
     *
     * @param positionTitle
     */
    public void setPositionTitle(String positionTitle) {
        this.positionTitle = positionTitle;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (companyPositionsID != null ? companyPositionsID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Companypositions)) {
            return false;
        }
        Companypositions other = (Companypositions) object;
        if ((this.companyPositionsID == null && other.companyPositionsID != null) || (this.companyPositionsID != null && !this.companyPositionsID.equals(other.companyPositionsID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Companypositions[ companyPositionsID=" + companyPositionsID + " ]";
    }
    
}
