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

// TODO: Auto-generated Javadoc
/**
 * The Class Itemclass.
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

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    /** The item class ID. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "itemClass_ID")
    private Integer itemClassID;
    
    /** The date added. */
    @Column(name = "DateAdded")
    @Temporal(TemporalType.DATE)
    private Date dateAdded;
    
    /** The date removed. */
    @Column(name = "dateRemoved", insertable=false)
    @Temporal(TemporalType.DATE)
    private Date dateRemoved;
    
    /** The user added. */
    @Column(name = "userAdded")
    private Integer userAdded;
    
    /** The user removed. */
    @Column(name = "userRemoved", insertable=false)
    private Integer userRemoved;
    
    /** The item type. */
    @Column(name = "itemType")
    private String itemType;
    
    /** The item class information. */
    @Column(name = "itemClassInformation")
    private String itemClassInformation;
    
    /** The item list. */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true, mappedBy = "itemClassID", fetch = FetchType.EAGER)
    private List<Item> itemList;
    
    /** The item class fields ID. */
    @JoinColumn(name = "itemClassFields_ID", referencedColumnName = "itemClassFields_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Itemclassfields itemClassFieldsID;

    /**
     * Instantiates a new itemclass.
     */
    public Itemclass() {
    }

    /**
     * Instantiates a new itemclass.
     *
     * @param itemClassID the item class ID
     */
    public Itemclass(Integer itemClassID) {
        this.itemClassID = itemClassID;
    }
    
    /**
     * Instantiates a new itemclass.
     *
     * @param itemClassID the item class ID
     * @param dateAdded the date added
     * @param userAdded the user added
     * @param itemType the item type
     * @param itemClassInformation the item class information
     * @param itemClassFieldsID the item class fields ID
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
     * Gets the item class ID.
     *
     * @return the item class ID
     */
    public Integer getItemClassID() {
        return itemClassID;
    }

    /**
     * Sets the item class ID.
     *
     * @param itemClassID the new item class ID
     */
    public void setItemClassID(Integer itemClassID) {
        this.itemClassID = itemClassID;
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
     * Gets the item type.
     *
     * @return the item type
     */
    public String getItemType() {
        return itemType;
    }

    /**
     * Sets the item type.
     *
     * @param itemType the new item type
     */
    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    /**
     * Gets the item class information.
     *
     * @return the item class information
     */
    public String getItemClassInformation() {
        return itemClassInformation;
    }

    /**
     * Sets the item class information.
     *
     * @param itemClassInformation the new item class information
     */
    public void setItemClassInformation(String itemClassInformation) {
        this.itemClassInformation = itemClassInformation;
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
     * Gets the item class fields ID.
     *
     * @return the item class fields ID
     */
    public Itemclassfields getItemClassFieldsID() {
        return itemClassFieldsID;
    }

    /**
     * Sets the item class fields ID.
     *
     * @param itemClassFieldsID the new item class fields ID
     */
    public void setItemClassFieldsID(Itemclassfields itemClassFieldsID) {
        this.itemClassFieldsID = itemClassFieldsID;
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemClassID != null ? itemClassID.hashCode() : 0);
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
        if (!(object instanceof Itemclass)) {
            return false;
        }
        Itemclass other = (Itemclass) object;
        if ((this.itemClassID == null && other.itemClassID != null) || (this.itemClassID != null && !this.itemClassID.equals(other.itemClassID))) {
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
        return "domain.Itemclass[ itemClassID=" + itemClassID + " ]";
    }
    
}
