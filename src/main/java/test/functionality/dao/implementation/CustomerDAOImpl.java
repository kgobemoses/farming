package test.functionality.dao.implementation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import test.functionality.dto.CustomerDTO;
import test.functionality.entity.Customer;
import test.functionality.entity.Livestock;
import test.util.FunctionalLib;

@Stateless
public class CustomerDAOImpl extends CrudDAO<Customer> {
    FunctionalLib fl = new FunctionalLib();
    public CustomerDAOImpl() {
        super(null);
    }

    @Inject
    public CustomerDAOImpl(EntityManager em) {
        super(em);
    }

    public CustomerDTO create(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer = create(customer);
        return customerDTO;
    }

     public Customer findByID(Integer id) {
        Map<String, Object> parameters = new HashMap<>(1);
        parameters.put("id", id);
        Customer customer = new Customer();
        customer = findWithNamedAndParamsQuery("Customer.findById", parameters);
        return customer;
    }
    
    public List<Customer> retriveCustomer() {
        List<Customer> users = findWithNamedQuery("Customer.findAll");
        return users;
    }
    
    public List<Customer> searchBy(String type, String value) {
        Map<String, Object> parameters = new HashMap<>(1);
        parameters.put(fl.lowerCaseFirstLetter(type), value);
        List<Customer> users = findWithNamedQuery("Customer.findBy"+fl.capitilizeFirstLetter(type),parameters);
        return users;
    }

}
