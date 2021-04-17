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

// TODO: Auto-generated Javadoc
/**
 * The Class Logins.
 *
 * @author Chels
 */
@Entity
@Table(name = "logins")
@NamedQueries({
    @NamedQuery(name = "Logins.findAll", query = "SELECT l FROM Logins l")
    , @NamedQuery(name = "Logins.getUser", query = "SELECT l FROM Logins l WHERE l.username = :username")})
public class Logins implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    /** The user id. */
    @Id
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;
    
    /** The date added. */
    @Column(name = "dateAdded")
    @Temporal(TemporalType.DATE)
    private Date dateAdded;
    
    /** The date removed. */
    @Column(name = "dateRemoved")
    @Temporal(TemporalType.DATE)
    private Date dateRemoved;
    
    /** The user added. */
    @Column(name = "userAdded")
    private Integer userAdded;
    
    /** The user removed. */
    @Column(name = "userRemoved")
    private Integer userRemoved;
    
    /** The username. */
    @Column(name = "username")
    private String username;
    
    /** The password. */
    @Column(name = "password")
    private String password;
    
    /** The is active. */
    @Column(name = "isActive")
    private Character isActive;
    
    /** The is admin. */
    @Column(name = "isAdmin")
    private Character isAdmin;
    
    /** The company ID. */
    @JoinColumn(name = "company_ID", referencedColumnName = "company_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Company companyID;

    /**
     * Instantiates a new logins.
     */
    public Logins() {
    }

    /**
     * Instantiates a new logins.
     *
     * @param userId takes in user id
     */
    public Logins(Integer userId) {
        this.userId = userId;
    }

    /**
     * Instantiates a new logins.
     *
     * @param dateAdded takes in useradded
     * @param username takes in username
     * @param password takes in password
     * @param companyID takes in company id
     * @param isActive takes in is active
     * @param isAdmin takes is isAdmin
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
     * Instantiates a new logins.
     *
     * @param dateAdded takes in dateAdded
     * @param username takes in username
     * @param password takes in password
     * @param isActive takes in active
     * @param isAdmin takes in admin
     */
    public Logins(Date dateAdded, String username, String password, Character isActive, Character isAdmin) {
        this.dateAdded = dateAdded;
        this.username = username;
        this.password = password;
 
        this.isActive = isActive;
        this.isAdmin = isAdmin;
               
    }

    /**
     * Instantiates a new logins.
     *
     * @param dateAdded t
     * @param username the username
     * @param password the password
     * @param companyID the company ID
     */
    public Logins(Date dateAdded, String username, String password, Company companyID) {
         this.dateAdded = dateAdded;
        this.username = username;
        this.password = password;
    }

    /**
     * Gets the user id.
     *
     * @return Integer returns a integer
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * Sets the user id.
     *
     * @param userId the new user id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * Gets the date added.
     *
     * @return Date returns a date
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
     * @return Date returns a date
     */
    public Date getDateRemoved() {
        return dateRemoved;
    }

    /**
     * Sets the date removed.
     *
     * @param dateRemoved takes in a date
     */
    public void setDateRemoved(Date dateRemoved) {
        this.dateRemoved = dateRemoved;
    }

    /**
     * Gets the user added.
     *
     * @return Integer returns a integer
     */
    public Integer getUserAdded() {
        return userAdded;
    }

    /**
     * Sets the user added.
     *
     * @param userAdded takes in a integer
     */
    public void setUserAdded(Integer userAdded) {
        this.userAdded = userAdded;
    }

    /**
     * Gets the user removed.
     *
     * @return UserRemoved returns a integer
     */
    public Integer getUserRemoved() {
        return userRemoved;
    }

    /**
     * Sets the user removed.
     *
     * @param userRemoved takes in integer
     */
    public void setUserRemoved(Integer userRemoved) {
        this.userRemoved = userRemoved;
    }

    /**
     * Gets the username.
     *
     * @return String returns a string
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username.
     *
     * @param username the new username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password.
     *
     * @return String returns a string
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param password takes in a string
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the checks if is active.
     *
     * @return Character returns a character
     */
    public Character getIsActive() {
        return isActive;
    }

    /**
     * Sets the checks if is active.
     *
     * @param isActive takes in a character
     */
    public void setIsActive(Character isActive) {
        this.isActive = isActive;
    }

    /**
     * Gets the checks if is admin.
     *
     * @return Character returns a character
     */
    public Character getIsAdmin() {
        return isAdmin;
    }

    /**
     * Sets the checks if is admin.
     *
     * @param isAdmin takes in a character
     */
    public void setIsAdmin(Character isAdmin) {
        this.isAdmin = isAdmin;
    }

    /**
     * Gets the company ID.
     *
     * @return Company returns a company
     */
    public Company getCompanyID() {
        return companyID;
    }

    /**
     * Sets the company ID.
     *
     * @param companyID takes in a company
     */
    public void setCompanyID(Company companyID) {
        this.companyID = companyID;
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
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
        if (!(object instanceof Logins)) {
            return false;
        }
        Logins other = (Logins) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
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
        return "domain.Logins[ userId=" + userId + " ]";
    }

    
}
