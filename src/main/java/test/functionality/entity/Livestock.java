/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.functionality.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name="livestock")
@XmlRootElement
@NamedQueries({
	@javax.persistence.NamedQuery(name="Livestock.findAll", query="SELECT l FROM Livestock l"), 
	@javax.persistence.NamedQuery(name="Livestock.findByTagNumber", query="SELECT l FROM Livestock l WHERE l.tagNumber = :tagNumber"), 
	@javax.persistence.NamedQuery(name="Livestock.findByCategory", query="SELECT l FROM Livestock l WHERE l.category = :category"), 
	@javax.persistence.NamedQuery(name="Livestock.findByType", query="SELECT l FROM Livestock l WHERE l.type = :type"), 
	@javax.persistence.NamedQuery(name="Livestock.findByGender", query="SELECT l FROM Livestock l WHERE l.gender = :gender"), 
	@javax.persistence.NamedQuery(name="Livestock.findByName", query="SELECT l FROM Livestock l WHERE l.name = :name"), 
	@javax.persistence.NamedQuery(name="Livestock.findByLocation", query="SELECT l FROM Livestock l WHERE l.location = :location"), 
	@javax.persistence.NamedQuery(name="Livestock.findByPrice", query="SELECT l FROM Livestock l WHERE l.price = :price"), 
	@javax.persistence.NamedQuery(name="Livestock.findByNumOfMonths", query="SELECT l FROM Livestock l WHERE l.numOfMonths = :numOfMonths"), 
	@javax.persistence.NamedQuery(name="Livestock.findByColor", query="SELECT l FROM Livestock l WHERE l.color = :color"), 
	@javax.persistence.NamedQuery(name="Livestock.findByWeight", query="SELECT l FROM Livestock l WHERE l.weight = :weight"), 
	@javax.persistence.NamedQuery(name="Livestock.findByTreatments", query="SELECT l FROM Livestock l WHERE l.treatments = :treatments"), 
	@javax.persistence.NamedQuery(name="Livestock.findByNotes", query="SELECT l FROM Livestock l WHERE l.notes = :notes")
})
//@NamedQuery(name=File.FIND_BY_ID, query="select f FROM file f where f.id =:id")
public class Livestock implements Serializable {

    public static final String FIND_BY_ID = "file.findByTagNumber";
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tagNumber")
    private Integer tagNumber;
    @Column(name = "category")
    private String category;
    @Column(name = "type")
    private String type;
    @Column(name = "gender")
    private String gender;
    @Column(name = "name")
    private String name;
    @Column(name = "location")
    private String location;
    @Column(name="price")
    private BigInteger price;
    @Column(name = "numOfMonths")
    private Integer numOfMonths;
    @Column(name = "color")
    private String color;
    @Column(name = "weight")
    private String weight;
    @Lob
    @Column(name = "image")
    private byte[] image;
    @Column(name = "treatments")
    private String treatments;
    @Column(name = "notes")
    private String notes;
    @javax.persistence.Transient
    private Collection<Soldlivestocks> soldlivestocksCollection;

    public Livestock() {
    }

    public Livestock(Integer tagNumber) {
        this.tagNumber = tagNumber;
    }

    public Integer getTagNumber() {
        return tagNumber;
    }

    public void setTagNumber(Integer tagNumber) {
        this.tagNumber = tagNumber;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public java.math.BigInteger getPrice() {
        return price;
    }

    public void setPrice(java.math.BigInteger price) {
        this.price = price;
    }

    public Integer getNumOfMonths() {
        return numOfMonths;
    }

    public void setNumOfMonths(Integer numOfMonths) {
        this.numOfMonths = numOfMonths;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getTreatments() {
        return treatments;
    }

    public void setTreatments(String treatments) {
        this.treatments = treatments;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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
        hash += (tagNumber != null ? tagNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Livestock)) {
            return false;
        }
        Livestock other = (Livestock) object;
        if ((this.tagNumber == null && other.tagNumber != null) || (this.tagNumber != null && !this.tagNumber.equals(other.tagNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication18.Livestock[ tagNumber=" + tagNumber + " ]";
    }
    
}
