package domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Chels
 */
@Entity
@Table(name = "logins")
@NamedQueries({
    @NamedQuery(name = "Logins.findAll", query = "SELECT l FROM Logins l")
    , @NamedQuery(name = "Logins.getUser", query = "SELECT l FROM Logins l WHERE l.username = :username")})
public class Logins implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;
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
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "isActive")
    private Character isActive;
    @Column(name = "isAdmin")
    private Character isAdmin;
    @JoinColumn(name = "company_ID", referencedColumnName = "company_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Company companyID;

    /**
     *
     */
    public Logins() {
    }

    /**
     *
     * @param userId
     */
    public Logins(Integer userId) {
        this.userId = userId;
    }

    /**
     *
     * @param dateAdded
     * @param username
     * @param password
     * @param companyID
     * @param isActive
     * @param isAdmin
     */
    public Logins(Date dateAdded, String username, String password, Company companyID, Character isActive, Character isAdmin) {
        this.dateAdded = dateAdded;
        this.username = username;
        this.password = password;
        this.companyID = companyID;
        this.isActive = isActive;
        this.isAdmin = isAdmin;
               
    }
    
    /**
     *
     * @param dateAdded
     * @param username
     * @param password
     * @param isActive
     * @param isAdmin
     */
    public Logins(Date dateAdded, String username, String password, Character isActive, Character isAdmin) {
        this.dateAdded = dateAdded;
        this.username = username;
        this.password = password;
 
        this.isActive = isActive;
        this.isAdmin = isAdmin;
               
    }

    /**
     *
     * @param dateAdded
     * @param username
     * @param password
     * @param companyID
     */
    public Logins(Date dateAdded, String username, String password, Company companyID) {
         this.dateAdded = dateAdded;
        this.username = username;
        this.password = password;
    }

    /**
     *
     * @return
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     *
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
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
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     */
    public Character getIsActive() {
        return isActive;
    }

    /**
     *
     * @param isActive
     */
    public void setIsActive(Character isActive) {
        this.isActive = isActive;
    }

    /**
     *
     * @return
     */
    public Character getIsAdmin() {
        return isAdmin;
    }

    /**
     *
     * @param isAdmin
     */
    public void setIsAdmin(Character isAdmin) {
        this.isAdmin = isAdmin;
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
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Logins)) {
            return false;
        }
        Logins other = (Logins) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Logins[ userId=" + userId + " ]";
    }

    
}
