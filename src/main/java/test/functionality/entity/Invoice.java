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
@Table(name="invoice")
@XmlRootElement
@NamedQueries({
	@javax.persistence.NamedQuery(name="Invoice.findAll", query="SELECT i FROM Invoice i"), 
	@javax.persistence.NamedQuery(name="Invoice.findByInvoiceid", query="SELECT i FROM Invoice i WHERE i.invoiceid = :invoiceid"), 
	@javax.persistence.NamedQuery(name="Invoice.findByDate", query="SELECT i FROM Invoice i WHERE i.date = :date")
})
public class Invoice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "invoiceid")
    private Integer invoiceid;
    @Column(name="\"Date\"")
    private String date;
    @javax.persistence.Transient
    private Collection<PurchasedLivestocks> purchasedLivestocksCollection;
    @javax.persistence.Transient
    private Collection<Soldlivestocks> soldlivestocksCollection;

    public Invoice() {
    }

    public Invoice(Integer invoiceid) {
        this.invoiceid = invoiceid;
    }

    public Integer getInvoiceid() {
        return invoiceid;
    }

    public void setInvoiceid(Integer invoiceid) {
        this.invoiceid = invoiceid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @XmlTransient
    public Collection<PurchasedLivestocks> getPurchasedLivestocksCollection() {
        return purchasedLivestocksCollection;
    }

    public void setPurchasedLivestocksCollection(Collection<PurchasedLivestocks> purchasedLivestocksCollection) {
        this.purchasedLivestocksCollection = purchasedLivestocksCollection;
    }

    @XmlTransient
    public Collection<Soldlivestocks> getSoldlivestocksCollection() {
        return soldlivestocksCollection;
    }

    public void setSoldlivestocksCollection(Collection<Soldlivestocks> soldlivestocksCollection) {
        this.soldlivestocksCollection = soldlivestocksCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invoiceid != null ? invoiceid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invoice)) {
            return false;
        }
        Invoice other = (Invoice) object;
        if ((this.invoiceid == null && other.invoiceid != null) || (this.invoiceid != null && !this.invoiceid.equals(other.invoiceid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication18.Invoice[ invoiceid=" + invoiceid + " ]";
    }
    
}
