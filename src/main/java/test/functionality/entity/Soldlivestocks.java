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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author moses
 */
@Entity
@Table(name="soldlivestocks")
@XmlRootElement
@NamedQueries({
	@javax.persistence.NamedQuery(name="Soldlivestocks.findAll", query="SELECT s FROM Soldlivestocks s"), 
	@javax.persistence.NamedQuery(name="Soldlivestocks.findById", query="SELECT s FROM Soldlivestocks s WHERE s.id = :id"), 
	@javax.persistence.NamedQuery(name="Soldlivestocks.findByDatesold", query="SELECT s FROM Soldlivestocks s WHERE s.datesold = :datesold")
})
public class Soldlivestocks implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "datesold")
    private String datesold;
    @javax.persistence.ManyToOne(optional=false)
	@javax.persistence.JoinColumn(name="InvoiceNumber", referencedColumnName="invoiceid")
    private Invoice invoiceNumber;
    @javax.persistence.ManyToOne(optional=false)
	@javax.persistence.JoinColumn(name="tagNumber", referencedColumnName="tagNumber")
    private Livestock tagNumber;

    public Soldlivestocks() {
    }

    public Soldlivestocks(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDatesold() {
        return datesold;
    }

    public void setDatesold(String datesold) {
        this.datesold = datesold;
    }

    public Invoice getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(Invoice invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Livestock getTagNumber() {
        return tagNumber;
    }

    public void setTagNumber(Livestock tagNumber) {
        this.tagNumber = tagNumber;
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
        if (!(object instanceof Soldlivestocks)) {
            return false;
        }
        Soldlivestocks other = (Soldlivestocks) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication18.Soldlivestocks[ id=" + id + " ]";
    }
    
}
