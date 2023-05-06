package test.functionality.dao.implementation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import test.functionality.entity.Fertilizer;
import test.util.FunctionalLib;

@Stateless
public class FertilizerDAOImpl1 extends CrudDAO<Fertilizer> {
    FunctionalLib fl = new FunctionalLib();
    public FertilizerDAOImpl1() {
        super(null);
    }

    @Inject
    public FertilizerDAOImpl1(EntityManager em) {
        super(em);
    }

    public Fertilizer create(Fertilizer customerDTO) {
        Fertilizer customer = new Fertilizer();
        customer = create(customer);
        return customerDTO;
    }

     public Fertilizer findByID(Integer id) {
        Map<String, Object> parameters = new HashMap<>(1);
        parameters.put("id", id);
        Fertilizer soldlivestocks = new Fertilizer();
        soldlivestocks = findWithNamedAndParamsQuery("Fertilizer.findByFertilizerid", parameters);
        return soldlivestocks;
    }
    
    public List<Fertilizer> retriveFertilizer() {
        List<Fertilizer> users = findWithNamedQuery("Fertilizer.findAll");
        return users;
    }
    
    public List<Fertilizer> searchBy(String type, String value) {
        Map<String, Object> parameters = new HashMap<>(1);
        parameters.put(fl.lowerCaseFirstLetter(type), value);
        List<Fertilizer> users = findWithNamedQuery("Fertilizer.findBy"+fl.capitilizeFirstLetter(type),parameters);
        return users;
    }

}
