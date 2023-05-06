/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.functionality.dto;

import test.functionality.entity.*;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlTransient;

public class LivestockDTO {

   
    private Integer tagNumber;
    
    private String category;
  
    private String type;
  
    private String gender;
    
    private String name;
  
    private String location;
    
    private BigInteger price;
   
    private Integer numOfMonths;
    
    private String color;
  
    private String weight;
    
    private byte[] image;
   
    private String treatments;
    
    private String notes;
   
    private List<Soldlivestocks>  soldlivestocksCollection;

    public LivestockDTO() {
    }

    public LivestockDTO(Integer tagNumber) {
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

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
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

    public List<Soldlivestocks> getSoldlivestocksCollection() {
        return soldlivestocksCollection;
    }

    public void setSoldlivestocksCollection(List<Soldlivestocks> soldlivestocksCollection) {
        this.soldlivestocksCollection = soldlivestocksCollection;
    }
   
}
