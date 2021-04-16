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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "itemclass")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Itemclass.findAll", query = "SELECT i FROM Itemclass i")
    , @NamedQuery(name = "Itemclass.findByItemClassID", query = "SELECT i FROM Itemclass i WHERE i.itemClassID = :itemClassID")
    , @NamedQuery(name = "Itemclass.findByDateAdded", query = "SELECT i FROM Itemclass i WHERE i.dateAdded = :dateAdded")
    , @NamedQuery(name = "Itemclass.findByDateRemoved", query = "SELECT i FROM Itemclass i WHERE i.dateRemoved = :dateRemoved")
    , @NamedQuery(name = "Itemclass.findByUserAdded", query = "SELECT i FROM Itemclass i WHERE i.userAdded = :userAdded")
    , @NamedQuery(name = "Itemclass.findByUserRemoved", query = "SELECT i FROM Itemclass i WHERE i.userRemoved = :userRemoved")
    , @NamedQuery(name = "Itemclass.findByItemType", query = "SELECT i FROM Itemclass i WHERE i.itemType = :itemType")
    , @NamedQuery(name = "Itemclass.findByItemClassInformation", query = "SELECT i FROM Itemclass i WHERE i.itemClassInformation = :itemClassInformation")})
public class Itemclass implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "itemClass_ID")
    private Integer itemClassID;
    @Column(name = "DateAdded")
    @Temporal(TemporalType.DATE)
    private Date dateAdded;
    @Column(name = "dateRemoved", insertable=false)
    @Temporal(TemporalType.DATE)
    private Date dateRemoved;
    @Column(name = "userAdded")
    private Integer userAdded;
    @Column(name = "userRemoved", insertable=false)
    private Integer userRemoved;
    @Column(name = "itemType")
    private String itemType;
    @Column(name = "itemClassInformation")
    private String itemClassInformation;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true, mappedBy = "itemClassID", fetch = FetchType.EAGER)
    private List<Item> itemList;
    @JoinColumn(name = "itemClassFields_ID", referencedColumnName = "itemClassFields_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Itemclassfields itemClassFieldsID;

    /**
     *
     */
    public Itemclass() {
    }

    /**
     *
     * @param itemClassID
     */
    public Itemclass(Integer itemClassID) {
        this.itemClassID = itemClassID;
    }
    
    /**
     *
     * @param itemClassID
     * @param dateAdded
     * @param userAdded
     * @param itemType
     * @param itemClassInformation
     * @param itemClassFieldsID
     */
    public Itemclass(Integer itemClassID, Date dateAdded, Integer userAdded, 
            String itemType, String itemClassInformation, Itemclassfields itemClassFieldsID) {
        this.itemClassID = itemClassID;
        this.dateAdded = dateAdded;
        this.userAdded = userAdded;
        this.itemType = itemType;
        this.itemClassInformation = itemClassInformation;
        this.itemClassFieldsID = itemClassFieldsID;
    }
    
    /**
     *
     * @return
     */
    public Integer getItemClassID() {
        return itemClassID;
    }

    /**
     *
     * @param itemClassID
     */
    public void setItemClassID(Integer itemClassID) {
        this.itemClassID = itemClassID;
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
    public String getItemType() {
        return itemType;
    }

    /**
     *
     * @param itemType
     */
    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    /**
     *
     * @return
     */
    public String getItemClassInformation() {
        return itemClassInformation;
    }

    /**
     *
     * @param itemClassInformation
     */
    public void setItemClassInformation(String itemClassInformation) {
        this.itemClassInformation = itemClassInformation;
    }

    /**
     *
     * @return
     */
    @XmlTransient
    public List<Item> getItemList() {
        return itemList;
    }

    /**
     *
     * @param itemList
     */
    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    /**
     *
     * @return
     */
    public Itemclassfields getItemClassFieldsID() {
        return itemClassFieldsID;
    }

    /**
     *
     * @param itemClassFieldsID
     */
    public void setItemClassFieldsID(Itemclassfields itemClassFieldsID) {
        this.itemClassFieldsID = itemClassFieldsID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemClassID != null ? itemClassID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Itemclass)) {
            return false;
        }
        Itemclass other = (Itemclass) object;
        if ((this.itemClassID == null && other.itemClassID != null) || (this.itemClassID != null && !this.itemClassID.equals(other.itemClassID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Itemclass[ itemClassID=" + itemClassID + " ]";
    }
    
}
