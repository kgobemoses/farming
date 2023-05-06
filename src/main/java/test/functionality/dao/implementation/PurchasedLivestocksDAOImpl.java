package test.functionality.dao.implementation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import test.functionality.entity.PurchasedLivestocks;
import test.util.FunctionalLib;

@Stateless
public class PurchasedLivestocksDAOImpl extends CrudDAO<PurchasedLivestocks> {
    FunctionalLib fl = new FunctionalLib();
    public PurchasedLivestocksDAOImpl() {
        super(null);
    }

    @Inject
    public PurchasedLivestocksDAOImpl(EntityManager em) {
        super(em);
    }

    public PurchasedLivestocks create(PurchasedLivestocks livestockDTO) {
        PurchasedLivestocks liveStock = new PurchasedLivestocks();
        liveStock = create(liveStock);
        return livestockDTO;
    }

    public PurchasedLivestocks findByTagNumber(Integer tagNumber) {
        Map<String, Object> parameters = new HashMap<>(1);
        parameters.put("tagNumber", tagNumber);
        PurchasedLivestocks liveStock = new PurchasedLivestocks();
        liveStock = findWithNamedAndParamsQuery("PurchasedLivestocks.findByTagNumber", parameters);
        return liveStock;
    }

    public List<PurchasedLivestocks> retrivePurchasedLivestocks() {
        List<PurchasedLivestocks> users = findWithNamedQuery("PurchasedLivestocks.findAll");
        return users;
    }
    
    public List<PurchasedLivestocks> searchBy(String type, String value) {
        Map<String, Object> parameters = new HashMap<>(1);
        parameters.put(fl.lowerCaseFirstLetter(type), value);
        List<PurchasedLivestocks> users = findWithNamedQuery("PurchasedLivestocks.findBy"+fl.capitilizeFirstLetter(type),parameters);
        return users;
    }

}
