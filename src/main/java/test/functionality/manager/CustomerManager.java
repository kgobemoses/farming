package test.functionality.manager;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import test.functionality.dao.implementation.CustomerDAOImpl;

import test.functionality.dao.implementation.LiveStockDAOImpl;
import test.functionality.dto.CustomerDTO;
import test.functionality.entity.Customer;
import test.functionality.entity.Livestock;

@Stateless
public class CustomerManager {

    private CustomerDAOImpl customerDAOImpl;

    public CustomerManager() {
        super();
    }

    @Inject
    public CustomerManager(CustomerDAOImpl customerDAOImpl) {
        super();
        this.customerDAOImpl = customerDAOImpl;
    }

    public CustomerDTO create(CustomerDTO livestockDTO) {
        Livestock livestock = new Livestock();
        customerDAOImpl.create(convert(livestockDTO));
        return livestockDTO;
    }

    public List<Customer> retrieveAll() {
       return customerDAOImpl.retriveCustomer();
    }
    
    public List<Customer> searchBy(String type, String value) {
        return customerDAOImpl.searchBy(type, value);
    }
    
    private CustomerDTO convert(Customer livestockDTO) {
        Gson gson = new Gson();
        String jsonInString = gson.toJson(livestockDTO);
        Gson gson_ = new Gson();
        String json = jsonInString;
        CustomerDTO obj = gson.fromJson(jsonInString, CustomerDTO.class);
        return obj;
    }

    private Customer convert(CustomerDTO livestockDTO) {
        Gson gson = new Gson();
        String jsonInString = gson.toJson(livestockDTO);
        Gson gson_ = new Gson();
        String json = jsonInString;
        Customer obj = gson.fromJson(jsonInString, Customer.class);
        return obj;
    }

    public Customer retrieveByID(Integer id) {
       return customerDAOImpl.findByID(id);
    }

}
