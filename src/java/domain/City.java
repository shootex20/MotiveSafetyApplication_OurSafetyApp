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

/**
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

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "city_ID")
    private Integer cityID;
    @Column(name = "cityName")
    private String cityName;
    @JoinColumn(name = "province_ID", referencedColumnName = "province_ID")
    @ManyToOne
    private Province provinceID;

    /**
     *
     */
    public City() {
    }

    /**
     *
     * @param cityID
     */
    public City(Integer cityID) {
        this.cityID = cityID;
    }

    /**
     *
     * @return
     */
    public Integer getCityID() {
        return cityID;
    }

    /**
     *
     * @param cityID
     */
    public void setCityID(Integer cityID) {
        this.cityID = cityID;
    }

    /**
     *
     * @return
     */
    public String getCityName() {
        return cityName;
    }

    /**
     *
     * @param cityName
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     *
     * @return
     */
    public Province getProvinceID() {
        return provinceID;
    }

    /**
     *
     * @param provinceID
     */
    public void setProvinceID(Province provinceID) {
        this.provinceID = provinceID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cityID != null ? cityID.hashCode() : 0);
        return hash;
    }

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

    @Override
    public String toString() {
        return "domain.City[ cityID=" + cityID + " ]";
    }
    
}
