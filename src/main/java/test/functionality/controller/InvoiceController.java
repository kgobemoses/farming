/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import test.functionality.entity.Invoice;
import test.functionality.entity.Invoice;
import test.functionality.manager.InvoiceManager;

/**
 *
 * @author moses
 */
@Path("invoice")
@Stateless
public class InvoiceController extends AbstractController {

    private InvoiceManager manager;

    public InvoiceController() {
    }

    @Inject
    public InvoiceController(InvoiceManager fileMan) {
        super();
        this.manager = fileMan;
    }

    /**
	 * 
	 * @param invoice
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
    public Invoice addLiveStock(Invoice invoice) {
        invoice = manager.create(invoice);
        return invoice;
    }

    /**
	 * 
	 * @param type
	 * @param value
	 */
	@GET
	@Path("searchBy/{type}/{value}")
	@Produces(MediaType.APPLICATION_JSON)
    public List<Invoice> searchBy(@PathParam("type") String type, @PathParam("value") String value) {
        return manager.searchBy(type, value);
    }

    @GET
	@Produces(MediaType.APPLICATION_JSON)
    public List<Invoice> reteiveAll() {
        return manager.retrieveAll();
    }
    
    /**
	 * 
	 * @param id
	 */
	@GET
	@Path("retrieve/{id}")
	@Produces(MediaType.APPLICATION_JSON)
    public Invoice reteiveFile(@PathParam("id") Integer id) {
        Invoice cust = manager.retrieveByID(id);
        return cust;
    }
}
