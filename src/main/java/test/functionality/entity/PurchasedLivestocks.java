/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.functionality.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="purchased_livestocks")
@XmlRootElement
@NamedQueries({
	@javax.persistence.NamedQuery(name="PurchasedLivestocks.findAll", query="SELECT p FROM PurchasedLivestocks p"), 
	@javax.persistence.NamedQuery(name="PurchasedLivestocks.findById", query="SELECT p FROM PurchasedLivestocks p WHERE p.id = :id")
})
public class PurchasedLivestocks implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @javax.persistence.ManyToOne(optional=false)
	@javax.persistence.JoinColumn(name="fk_cust_id", referencedColumnName="id")
    private Customer fkCustId;
    @javax.persistence.ManyToOne(optional=false)
	@javax.persistence.JoinColumn(name="fk_invoice_id", referencedColumnName="invoiceid")
    private Invoice fkInvoiceId;

    public PurchasedLivestocks() {
    }

    public PurchasedLivestocks(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getFkCustId() {
        return fkCustId;
    }

    public void setFkCustId(Customer fkCustId) {
        this.fkCustId = fkCustId;
    }

    public Invoice getFkInvoiceId() {
        return fkInvoiceId;
    }

    public void setFkInvoiceId(Invoice fkInvoiceId) {
        this.fkInvoiceId = fkInvoiceId;
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
        if (!(object instanceof PurchasedLivestocks)) {
            return false;
        }
        PurchasedLivestocks other = (PurchasedLivestocks) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication18.PurchasedLivestocks[ id=" + id + " ]";
    }
    
}
