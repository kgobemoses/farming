package test.functionality.dao.implementation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import test.functionality.entity.Soldlivestocks;
import test.util.FunctionalLib;

@Stateless
public class SoldlivestocksDAOImpl extends CrudDAO<Soldlivestocks> {
    FunctionalLib fl = new FunctionalLib();
    public SoldlivestocksDAOImpl() {
        super(null);
    }

    @Inject
    public SoldlivestocksDAOImpl(EntityManager em) {
        super(em);
    }

    public Soldlivestocks create(Soldlivestocks customerDTO) {
        Soldlivestocks customer = new Soldlivestocks();
        customer = create(customer);
        return customerDTO;
    }

     public Soldlivestocks findByID(Integer id) {
        Map<String, Object> parameters = new HashMap<>(1);
        parameters.put("id", id);
        Soldlivestocks soldlivestocks = new Soldlivestocks();
        soldlivestocks = findWithNamedAndParamsQuery("Soldlivestocks.findBySoldlivestocksid", parameters);
        return soldlivestocks;
    }
    
    public List<Soldlivestocks> retriveSoldlivestocks() {
        List<Soldlivestocks> users = findWithNamedQuery("Soldlivestocks.findAll");
        return users;
    }
    
    public List<Soldlivestocks> searchBy(String type, String value) {
        Map<String, Object> parameters = new HashMap<>(1);
        parameters.put(fl.lowerCaseFirstLetter(type), value);
        List<Soldlivestocks> users = findWithNamedQuery("Soldlivestocks.findBy"+fl.capitilizeFirstLetter(type),parameters);
        return users;
    }

}
