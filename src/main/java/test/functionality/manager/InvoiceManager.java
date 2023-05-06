package test.functionality.manager;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import test.functionality.dao.implementation.InvoiceDAOImpl;

import test.functionality.entity.Invoice;
import test.functionality.entity.Livestock;

@Stateless
public class InvoiceManager {

    private InvoiceDAOImpl customerDAOImpl;

    public InvoiceManager() {
        super();
    }

    @Inject
    public InvoiceManager(InvoiceDAOImpl customerDAOImpl) {
        super();
        this.customerDAOImpl = customerDAOImpl;
    }

    public Invoice create(Invoice livestockDTO) {
        Livestock livestock = new Livestock();
        customerDAOImpl.create(convert(livestockDTO));
        return livestockDTO;
    }

    public List<Invoice> retrieveAll() {
       return customerDAOImpl.retriveInvoice();
    }
    
    public List<Invoice> searchBy(String type, String value) {
        return customerDAOImpl.searchBy(type, value);
    }
    
    private Invoice convert(Invoice livestockDTO) {
        Gson gson = new Gson();
        String jsonInString = gson.toJson(livestockDTO);
        Gson gson_ = new Gson();
        String json = jsonInString;
        Invoice obj = gson.fromJson(jsonInString, Invoice.class);
        return obj;
    }

    public Invoice retrieveByID(Integer id) {
       return customerDAOImpl.findByID(id);
    }

}
