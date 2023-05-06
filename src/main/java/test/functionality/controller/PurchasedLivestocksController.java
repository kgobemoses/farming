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
import test.functionality.entity.PurchasedLivestocks;
import test.functionality.manager.PurchasedLivestocksManager;

@Path("PurchasedLivestocks")
@Stateless
public class PurchasedLivestocksController extends AbstractController {

    private PurchasedLivestocksManager manager;

    public PurchasedLivestocksController() {
    }

    @Inject
    public PurchasedLivestocksController(PurchasedLivestocksManager fileMan) {
        super();
        this.manager = fileMan;
    }

    /**
	 * 
	 * @param livestockDTO
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
    public PurchasedLivestocks addLiveStock(PurchasedLivestocks livestockDTO) {
        livestockDTO = manager.create(livestockDTO);
        return livestockDTO;
    }

    /**
	 * 
	 * @param type
	 * @param value
	 */
	@GET
	@Path("searchBy/{type}/{value}")
	@Produces(MediaType.APPLICATION_JSON)
    public List<PurchasedLivestocks> searchBy(@PathParam("type") String type, @PathParam("value") String value) {
        return manager.searchBy(type, value);
    }

    @GET
	@Produces(MediaType.APPLICATION_JSON)
    public List<PurchasedLivestocks> reteiveAll() {
        return manager.retrieveAll();
    }
}
