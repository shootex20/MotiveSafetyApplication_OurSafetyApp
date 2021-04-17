/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

// TODO: Auto-generated Javadoc
/**
 * The Class Country.
 *
 * @author Chels
 */
@Entity
@Table(name = "country")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Country.findAll", query = "SELECT c FROM Country c")
    , @NamedQuery(name = "Country.findByCountryID", query = "SELECT c FROM Country c WHERE c.countryID = :countryID")
    , @NamedQuery(name = "Country.findByCountryName", query = "SELECT c FROM Country c WHERE c.countryName = :countryName")})
public class Country implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    /** The country ID. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "country_ID")
    private Integer countryID;
    
    /** The country name. */
    @Column(name = "countryName")
    private String countryName;
    
    /** The province list. */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true, mappedBy = "countryID")
    private List<Province> provinceList;

    /**
     * Instantiates a new country.
     */
    public Country() {
    }

    /**
     * Instantiates a new country.
     *
     * @param countryID the country ID
     */
    public Country(Integer countryID) {
        this.countryID = countryID;
    }

    /**
     * Gets the country ID.
     *
     * @return the country ID
     */
    public Integer getCountryID() {
        return countryID;
    }

    /**
     * Sets the country ID.
     *
     * @param countryID the new country ID
     */
    public void setCountryID(Integer countryID) {
        this.countryID = countryID;
    }

    /**
     * Gets the country name.
     *
     * @return the country name
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * Sets the country name.
     *
     * @param countryName the new country name
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    /**
     * Gets the province list.
     *
     * @return the province list
     */
    @XmlTransient
    public List<Province> getProvinceList() {
        return provinceList;
    }

    /**
     * Sets the province list.
     *
     * @param provinceList the new province list
     */
    public void setProvinceList(List<Province> provinceList) {
        this.provinceList = provinceList;
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (countryID != null ? countryID.hashCode() : 0);
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
        if (!(object instanceof Country)) {
            return false;
        }
        Country other = (Country) object;
        if ((this.countryID == null && other.countryID != null) || (this.countryID != null && !this.countryID.equals(other.countryID))) {
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
        return "domain.Country[ countryID=" + countryID + " ]";
    }
    
}
