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

/**
 *
 * @author Daniel Quach
 */
@Entity
@Table(name = "itemclassfields")
@NamedQueries({
    @NamedQuery(name = "Itemclassfields.findAll", query = "SELECT i FROM Itemclassfields i")})
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
    @Column(name = "dateRemoved")
    @Temporal(TemporalType.DATE)
    private Date dateRemoved;
    @Column(name = "userAdded")
    private Integer userAdded;
    @Column(name = "userRemoved")
    private Integer userRemoved;
    @Column(name = "fieldDescr")
    private String fieldDescr;
    @Column(name = "fieldDescrType")
    private String fieldDescrType;
    @OneToMany(mappedBy = "itemClassFieldsID", fetch = FetchType.EAGER)
    private List<Itemclass> itemclassList;
    @JoinColumn(name = "typeLibrary_ID", referencedColumnName = "typeLibrary_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Typelibrary typeLibraryID;

    public Itemclassfields() {
    }

    public Itemclassfields(Integer itemClassFieldsID) {
        this.itemClassFieldsID = itemClassFieldsID;
    }

    public Integer getItemClassFieldsID() {
        return itemClassFieldsID;
    }

    public void setItemClassFieldsID(Integer itemClassFieldsID) {
        this.itemClassFieldsID = itemClassFieldsID;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Date getDateRemoved() {
        return dateRemoved;
    }

    public void setDateRemoved(Date dateRemoved) {
        this.dateRemoved = dateRemoved;
    }

    public Integer getUserAdded() {
        return userAdded;
    }

    public void setUserAdded(Integer userAdded) {
        this.userAdded = userAdded;
    }

    public Integer getUserRemoved() {
        return userRemoved;
    }

    public void setUserRemoved(Integer userRemoved) {
        this.userRemoved = userRemoved;
    }

    public String getFieldDescr() {
        return fieldDescr;
    }

    public void setFieldDescr(String fieldDescr) {
        this.fieldDescr = fieldDescr;
    }

    public String getFieldDescrType() {
        return fieldDescrType;
    }

    public void setFieldDescrType(String fieldDescrType) {
        this.fieldDescrType = fieldDescrType;
    }

    public List<Itemclass> getItemclassList() {
        return itemclassList;
    }

    public void setItemclassList(List<Itemclass> itemclassList) {
        this.itemclassList = itemclassList;
    }

    public Typelibrary getTypeLibraryID() {
        return typeLibraryID;
    }

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
