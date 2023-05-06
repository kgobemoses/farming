package test.functionality.dto;

import test.functionality.entity.*;
import java.util.Collection;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author moses
 */

public class CustomerDTO {

   
    private Integer id;
    private String firstname;
    private String lastname;
    private String iDNumber;
    private String cellNumber;
    private String email;
    private String location;
    private Collection<PurchasedLivestocks> purchasedLivestocksCollection;

    public CustomerDTO() {
    }

    public CustomerDTO(Integer id) {
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
    
}
