/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.functionality.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author moses
 */
@Entity
@Table(name="fertilizer")
@XmlRootElement
@NamedQueries({
	@javax.persistence.NamedQuery(name="Fertilizer.findAll", query="SELECT f FROM Fertilizer f"), 
	@javax.persistence.NamedQuery(name="Fertilizer.findById", query="SELECT f FROM Fertilizer f WHERE f.id = :id"), 
	@javax.persistence.NamedQuery(name="Fertilizer.findByBrand", query="SELECT f FROM Fertilizer f WHERE f.brand = :brand"), 
	@javax.persistence.NamedQuery(name="Fertilizer.findByExpdate", query="SELECT f FROM Fertilizer f WHERE f.expdate = :expdate"), 
	@javax.persistence.NamedQuery(name="Fertilizer.findBySize", query="SELECT f FROM Fertilizer f WHERE f.size = :size"), 
	@javax.persistence.NamedQuery(name="Fertilizer.findByShelvenumber", query="SELECT f FROM Fertilizer f WHERE f.shelvenumber = :shelvenumber"), 
	@javax.persistence.NamedQuery(name="Fertilizer.findByQuantity", query="SELECT f FROM Fertilizer f WHERE f.quantity = :quantity")
})
public class Fertilizer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "brand")
    private String brand;
    @Column(name = "expdate")
    private String expdate;
    @Column(name = "size")
    private String size;
    @Column(name = "shelvenumber")
    private String shelvenumber;
    @Column(name = "quantity")
    private String quantity;

    public Fertilizer() {
    }

    public Fertilizer(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getExpdate() {
        return expdate;
    }

    public void setExpdate(String expdate) {
        this.expdate = expdate;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getShelvenumber() {
        return shelvenumber;
    }

    public void setShelvenumber(String shelvenumber) {
        this.shelvenumber = shelvenumber;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
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
        if (!(object instanceof Fertilizer)) {
            return false;
        }
        Fertilizer other = (Fertilizer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication18.Fertilizer[ id=" + id + " ]";
    }
    
}
