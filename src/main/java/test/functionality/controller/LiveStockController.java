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
import test.functionality.dto.LivestockDTO;
import test.functionality.entity.Livestock;
import test.functionality.manager.Manager;

@Path("livestock")
@Stateless
public class LiveStockController extends AbstractController {

    private Manager manager;

    public LiveStockController() {
    }

    @Inject
    public LiveStockController(Manager fileMan) {
        super();
        this.manager = fileMan;
    }

    /**
	 * 
	 * @param livestockDTO
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
    public LivestockDTO addLiveStock(LivestockDTO livestockDTO) {
        livestockDTO = manager.create(livestockDTO);
        return livestockDTO;
    }

    /**
	 * 
	 * @param tagNumber
	 */
	@GET
	@Path("retrieve/{tagNumber}")
	@Produces(MediaType.APPLICATION_JSON)
    public LivestockDTO reteiveFile(@PathParam("tagNumber") Integer tagNumber) {
        LivestockDTO livestockDTO = manager.retrieveByTagNumber(tagNumber);

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
    public List<Livestock> searchBy(@PathParam("type") String type, @PathParam("value") String value) {
        return manager.searchBy(type, value);
    }

    @GET
	@Produces(MediaType.APPLICATION_JSON)
    public List<Livestock> reteiveAll() {
        return manager.retrieveAll();
    }
}
