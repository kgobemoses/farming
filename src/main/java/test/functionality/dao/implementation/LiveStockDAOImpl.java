package test.functionality.dao.implementation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import test.functionality.dto.LivestockDTO;
import test.functionality.entity.Livestock;
import test.util.FunctionalLib;

@Stateless
public class LiveStockDAOImpl extends CrudDAO<Livestock> {
    FunctionalLib fl = new FunctionalLib();
    public LiveStockDAOImpl() {
        super(null);
    }

    @Inject
    public LiveStockDAOImpl(EntityManager em) {
        super(em);
    }

    public LivestockDTO create(LivestockDTO livestockDTO) {
        Livestock liveStock = new Livestock();
        liveStock = create(liveStock);
        return livestockDTO;
    }

    public Livestock findByTagNumber(Integer tagNumber) {
        Map<String, Object> parameters = new HashMap<>(1);
        parameters.put("tagNumber", tagNumber);
        Livestock liveStock = new Livestock();
        liveStock = findWithNamedAndParamsQuery("Livestock.findByTagNumber", parameters);
        return liveStock;
    }

    public List<Livestock> retriveLivestock() {
        List<Livestock> users = findWithNamedQuery("Livestock.findAll");
        return users;
    }
    
    public List<Livestock> searchBy(String type, String value) {
        Map<String, Object> parameters = new HashMap<>(1);
        parameters.put(fl.lowerCaseFirstLetter(type), value);
        List<Livestock> users = findWithNamedQuery("Livestock.findBy"+fl.capitilizeFirstLetter(type),parameters);
        return users;
    }

}
