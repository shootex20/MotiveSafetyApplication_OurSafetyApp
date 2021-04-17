/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

// TODO: Auto-generated Javadoc
/**
 * The Class City.
 *
 * @author Chels
 */
@Entity
@Table(name = "city")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "City.findAll", query = "SELECT c FROM City c")
    , @NamedQuery(name = "City.findByCityID", query = "SELECT c FROM City c WHERE c.cityID = :cityID")
    , @NamedQuery(name = "City.findByCityName", query = "SELECT c FROM City c WHERE c.cityName = :cityName")})
public class City implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    /** The city ID. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "city_ID")
    private Integer cityID;
    
    /** The city name. */
    @Column(name = "cityName")
    private String cityName;
    
    /** The province ID. */
    @JoinColumn(name = "province_ID", referencedColumnName = "province_ID")
    @ManyToOne
    private Province provinceID;

    /**
     * Instantiates a new city.
     */
    public City() {
    }

    /**
     * Instantiates a new city.
     *
     * @param cityID the city ID
     */
    public City(Integer cityID) {
        this.cityID = cityID;
    }

    /**
     * Gets the city ID.
     *
     * @return the city ID
     */
    public Integer getCityID() {
        return cityID;
    }

    /**
     * Sets the city ID.
     *
     * @param cityID the new city ID
     */
    public void setCityID(Integer cityID) {
        this.cityID = cityID;
    }

    /**
     * Gets the city name.
     *
     * @return the city name
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * Sets the city name.
     *
     * @param cityName the new city name
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     * Gets the province ID.
     *
     * @return the province ID
     */
    public Province getProvinceID() {
        return provinceID;
    }

    /**
     * Sets the province ID.
     *
     * @param provinceID the new province ID
     */
    public void setProvinceID(Province provinceID) {
        this.provinceID = provinceID;
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cityID != null ? cityID.hashCode() : 0);
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
        if (!(object instanceof City)) {
            return false;
        }
        City other = (City) object;
        if ((this.cityID == null && other.cityID != null) || (this.cityID != null && !this.cityID.equals(other.cityID))) {
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
        return "domain.City[ cityID=" + cityID + " ]";
    }
    
}
