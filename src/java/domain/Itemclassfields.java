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
@Table(name = "itemclassfields")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Itemclassfields.findAll", query = "SELECT i FROM Itemclassfields i")
    , @NamedQuery(name = "Itemclassfields.findByItemClassFieldsID", query = "SELECT i FROM Itemclassfields i WHERE i.itemClassFieldsID = :itemClassFieldsID")
    , @NamedQuery(name = "Itemclassfields.findByDateAdded", query = "SELECT i FROM Itemclassfields i WHERE i.dateAdded = :dateAdded")
    , @NamedQuery(name = "Itemclassfields.findByDateRemoved", query = "SELECT i FROM Itemclassfields i WHERE i.dateRemoved = :dateRemoved")
    , @NamedQuery(name = "Itemclassfields.findByUserAdded", query = "SELECT i FROM Itemclassfields i WHERE i.userAdded = :userAdded")
    , @NamedQuery(name = "Itemclassfields.findByUserRemoved", query = "SELECT i FROM Itemclassfields i WHERE i.userRemoved = :userRemoved")
    , @NamedQuery(name = "Itemclassfields.findByFieldDescr", query = "SELECT i FROM Itemclassfields i WHERE i.fieldDescr = :fieldDescr")
    , @NamedQuery(name = "Itemclassfields.findByFieldDescrType", query = "SELECT i FROM Itemclassfields i WHERE i.fieldDescrType = :fieldDescrType")})
public class Itemclassfields implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "itemClassFields_ID")
    private Integer itemClassFieldsID;
    @Column(name = "dateAdded")
    @Temporal(TemporalType.DATE)
    private Date dateAdded;
    @Column(name = "dateRemoved", insertable=false)
    @Temporal(TemporalType.DATE)
    private Date dateRemoved;
    @Column(name = "userAdded")
    private Integer userAdded;
    @Column(name = "userRemoved", insertable=false)
    private Integer userRemoved;
    @Column(name = "fieldDescr")
    private String fieldDescr;
    @Column(name = "fieldDescrType")
    private String fieldDescrType;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true, mappedBy = "itemClassFieldsID", fetch = FetchType.EAGER)
    private List<Itemclass> itemclassList;
    @JoinColumn(name = "typeLibrary_ID", referencedColumnName = "typeLibrary_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Typelibrary typeLibraryID;

    /**
     *
     */
    public Itemclassfields() {
    }

    /**
     *
     * @param itemClassFieldsID
     */
    public Itemclassfields(Integer itemClassFieldsID) {
        this.itemClassFieldsID = itemClassFieldsID;
    }
    
    /**
     *
     * @param itemClassFieldsID
     * @param dateAdded
     * @param userAdded
     * @param fieldDescr
     * @param fieldDescrType
     * @param typeLibraryID
     */
    public Itemclassfields(Integer itemClassFieldsID, Date dateAdded, Integer userAdded, 
            String fieldDescr, String fieldDescrType, Typelibrary typeLibraryID) {
      
        this.itemClassFieldsID = itemClassFieldsID;
        this.dateAdded = dateAdded;
        this.userAdded = userAdded;
        this.fieldDescr = fieldDescr;
        this.fieldDescrType = fieldDescrType;
        this.typeLibraryID = typeLibraryID;
       
    }

    /**
     *
     * @return
     */
    public Integer getItemClassFieldsID() {
        return itemClassFieldsID;
    }

    /**
     *
     * @param itemClassFieldsID
     */
    public void setItemClassFieldsID(Integer itemClassFieldsID) {
        this.itemClassFieldsID = itemClassFieldsID;
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
    public String getFieldDescr() {
        return fieldDescr;
    }

    /**
     *
     * @param fieldDescr
     */
    public void setFieldDescr(String fieldDescr) {
        this.fieldDescr = fieldDescr;
    }

    /**
     *
     * @return
     */
    public String getFieldDescrType() {
        return fieldDescrType;
    }

    /**
     *
     * @param fieldDescrType
     */
    public void setFieldDescrType(String fieldDescrType) {
        this.fieldDescrType = fieldDescrType;
    }

    /**
     *
     * @return
     */
    @XmlTransient
    public List<Itemclass> getItemclassList() {
        return itemclassList;
    }

    /**
     *
     * @param itemclassList
     */
    public void setItemclassList(List<Itemclass> itemclassList) {
        this.itemclassList = itemclassList;
    }

    /**
     *
     * @return
     */
    public Typelibrary getTypeLibraryID() {
        return typeLibraryID;
    }

    /**
     *
     * @param typeLibraryID
     */
    public void setTypeLibraryID(Typelibrary typeLibraryID) {
        this.typeLibraryID = typeLibraryID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemClassFieldsID != null ? itemClassFieldsID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Itemclassfields)) {
            return false;
        }
        Itemclassfields other = (Itemclassfields) object;
        if ((this.itemClassFieldsID == null && other.itemClassFieldsID != null) || (this.itemClassFieldsID != null && !this.itemClassFieldsID.equals(other.itemClassFieldsID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Itemclassfields[ itemClassFieldsID=" + itemClassFieldsID + " ]";
    }
    
}
