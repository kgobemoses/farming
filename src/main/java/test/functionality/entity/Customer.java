/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.functionality.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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

/**
 *
 * @author moses
 */
@Entity
@Table(name="customer")
@XmlRootElement
@NamedQueries({
	@javax.persistence.NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c"), 
	@javax.persistence.NamedQuery(name="Customer.findById", query="SELECT c FROM Customer c WHERE c.id = :id"), 
	@javax.persistence.NamedQuery(name="Customer.findByFirstname", query="SELECT c FROM Customer c WHERE c.firstname = :firstname"), 
	@javax.persistence.NamedQuery(name="Customer.findByLastname", query="SELECT c FROM Customer c WHERE c.lastname = :lastname"), 
	@javax.persistence.NamedQuery(name="Customer.findByIDNumber", query="SELECT c FROM Customer c WHERE c.iDNumber = :iDNumber"), 
	@javax.persistence.NamedQuery(name="Customer.findByCellNumber", query="SELECT c FROM Customer c WHERE c.cellNumber = :cellNumber"), 
	@javax.persistence.NamedQuery(name="Customer.findByEmail", query="SELECT c FROM Customer c WHERE c.email = :email"), 
	@javax.persistence.NamedQuery(name="Customer.findByLocation", query="SELECT c FROM Customer c WHERE c.location = :location")
})
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "Firstname")
    private String firstname;
    @Column(name = "Lastname")
    private String lastname;
    @Column(name = "IDNumber")
    private String iDNumber;
    @Column(name = "CellNumber")
    private String cellNumber;
    @Column(name = "Email")
    private String email;
    @Column(name = "Location")
    private String location;
    @javax.persistence.Transient
    private Collection<PurchasedLivestocks> purchasedLivestocksCollection;

    public Customer() {
    }

    public Customer(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getIDNumber() {
        return iDNumber;
    }

    public void setIDNumber(String iDNumber) {
        this.iDNumber = iDNumber;
    }

    public String getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(String cellNumber) {
        this.cellNumber = cellNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @XmlTransient
    public Collection<PurchasedLivestocks> getPurchasedLivestocksCollection() {
        return purchasedLivestocksCollection;
    }

    public void setPurchasedLivestocksCollection(Collection<PurchasedLivestocks> purchasedLivestocksCollection) {
        this.purchasedLivestocksCollection = purchasedLivestocksCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication18.Customer[ id=" + id + " ]";
    }
    
}
