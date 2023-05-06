package test.functionality.dao.implementation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import test.functionality.entity.Invoice;
import test.util.FunctionalLib;

@Stateless
public class InvoiceDAOImpl extends CrudDAO<Invoice> {
    FunctionalLib fl = new FunctionalLib();
    public InvoiceDAOImpl() {
        super(null);
    }

    @Inject
    public InvoiceDAOImpl(EntityManager em) {
        super(em);
    }

    public Invoice create(Invoice customerDTO) {
        Invoice customer = new Invoice();
        customer = create(customer);
        return customerDTO;
    }

     public Invoice findByID(Integer id) {
        Map<String, Object> parameters = new HashMap<>(1);
        parameters.put("id", id);
        Invoice invoice = new Invoice();
        invoice = findWithNamedAndParamsQuery("Invoice.findByInvoiceid", parameters);
        return invoice;
    }
    
    public List<Invoice> retriveInvoice() {
        List<Invoice> users = findWithNamedQuery("Invoice.findAll");
        return users;
    }
    
    public List<Invoice> searchBy(String type, String value) {
        Map<String, Object> parameters = new HashMap<>(1);
        parameters.put(fl.lowerCaseFirstLetter(type), value);
        List<Invoice> users = findWithNamedQuery("Invoice.findBy"+fl.capitilizeFirstLetter(type),parameters);
        return users;
    }

}
