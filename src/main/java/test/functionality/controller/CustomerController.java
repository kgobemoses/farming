package test.functionality.controller;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import test.controller.AbstractController;
import test.functionality.dto.CustomerDTO;
import test.functionality.dto.LivestockDTO;
import test.functionality.entity.Customer;
import test.functionality.manager.CustomerManager;

@Path("customer")
@Stateless
public class CustomerController extends AbstractController {

    private CustomerManager manager;

    public CustomerController() {
    }

    @Inject
    public CustomerController(CustomerManager fileMan) {
        super();
        this.manager = fileMan;
    }

    /**
	 * 
	 * @param customerDTO
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
    public CustomerDTO addLiveStock(CustomerDTO customerDTO) {
        customerDTO = manager.create(customerDTO);
        return customerDTO;
    }

    /**
	 * 
	 * @param type
	 * @param value
	 */
	@GET
	@Path("searchBy/{type}/{value}")
	@Produces(MediaType.APPLICATION_JSON)
    public List<Customer> searchBy(@PathParam("type") String type, @PathParam("value") String value) {
        return manager.searchBy(type, value);
    }

    @GET
	@Produces(MediaType.APPLICATION_JSON)
    public List<Customer> reteiveAll() {
        return manager.retrieveAll();
    }
    
    /**
	 * 
	 * @param id
	 */
	@GET
	@Path("retrieve/{id}")
	@Produces(MediaType.APPLICATION_JSON)
    public Customer reteiveFile(@PathParam("id") Integer id) {
        Customer cust = manager.retrieveByID(id);

        return cust;
    }
}
