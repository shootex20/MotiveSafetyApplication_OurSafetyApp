/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

// TODO: Auto-generated Javadoc
/**
 * The Class Province.
 *
 * @author Chels
 */
@Entity
@Table(name = "province")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Province.findAll", query = "SELECT p FROM Province p")
    , @NamedQuery(name = "Province.findByProvinceID", query = "SELECT p FROM Province p WHERE p.provinceID = :provinceID")
    , @NamedQuery(name = "Province.findByProvinceName", query = "SELECT p FROM Province p WHERE p.provinceName = :provinceName")})
public class Province implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    /** The province ID. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "province_ID")
    private Integer provinceID;
    
    /** The province name. */
    @Column(name = "provinceName")
    private String provinceName;
    
    /** The city list. */
    @OneToMany(mappedBy = "provinceID")
    private List<City> cityList;
    
    /** The country ID. */
    @JoinColumn(name = "country_ID", referencedColumnName = "country_ID")
    @ManyToOne
    private Country countryID;

    /**
     * Instantiates a new province.
     */
    public Province() {
    }

    /**
     * Instantiates a new province.
     *
     * @param provinceID the province ID
     */
    public Province(Integer provinceID) {
        this.provinceID = provinceID;
    }

    /**
     * Gets the province ID.
     *
     * @return the province ID
     */
    public Integer getProvinceID() {
        return provinceID;
    }

    /**
     * Sets the province ID.
     *
     * @param provinceID the new province ID
     */
    public void setProvinceID(Integer provinceID) {
        this.provinceID = provinceID;
    }

    /**
     * Gets the province name.
     *
     * @return the province name
     */
    public String getProvinceName() {
        return provinceName;
    }

    /**
     * Sets the province name.
     *
     * @param provinceName the new province name
     */
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    /**
     * Gets the city list.
     *
     * @return the city list
     */
    @XmlTransient
    public List<City> getCityList() {
        return cityList;
    }

    /**
     * Sets the city list.
     *
     * @param cityList the new city list
     */
    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }

    /**
     * Gets the country ID.
     *
     * @return the country ID
     */
    public Country getCountryID() {
        return countryID;
    }

    /**
     * Sets the country ID.
     *
     * @param countryID the new country ID
     */
    public void setCountryID(Country countryID) {
        this.countryID = countryID;
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (provinceID != null ? provinceID.hashCode() : 0);
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
        if (!(object instanceof Province)) {
            return false;
        }
        Province other = (Province) object;
        if ((this.provinceID == null && other.provinceID != null) || (this.provinceID != null && !this.provinceID.equals(other.provinceID))) {
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
        return "domain.Province[ provinceID=" + provinceID + " ]";
    }
    
}
