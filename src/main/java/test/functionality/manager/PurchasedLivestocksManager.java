package test.functionality.manager;

import com.google.gson.Gson;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import test.functionality.dao.implementation.PurchasedLivestocksDAOImpl;

import test.functionality.entity.PurchasedLivestocks;
import test.functionality.entity.Livestock;

@Stateless
public class PurchasedLivestocksManager {

    private PurchasedLivestocksDAOImpl customerDAOImpl;

    public PurchasedLivestocksManager() {
        super();
    }

    @Inject
    public PurchasedLivestocksManager(PurchasedLivestocksDAOImpl customerDAOImpl) {
        super();
        this.customerDAOImpl = customerDAOImpl;
    }

    public PurchasedLivestocks create(PurchasedLivestocks livestockDTO) {
        Livestock livestock = new Livestock();
        customerDAOImpl.create(convert(livestockDTO));
        return livestockDTO;
    }

    public List<PurchasedLivestocks> retrieveAll() {
       return customerDAOImpl.retrivePurchasedLivestocks();
    }
    
    public List<PurchasedLivestocks> searchBy(String type, String value) {
        return customerDAOImpl.searchBy(type, value);
    }
    
    private PurchasedLivestocks convert(PurchasedLivestocks livestockDTO) {
        Gson gson = new Gson();
        String jsonInString = gson.toJson(livestockDTO);
        Gson gson_ = new Gson();
        String json = jsonInString;
        PurchasedLivestocks obj = gson.fromJson(jsonInString, PurchasedLivestocks.class);
        return obj;
    }

//    private PurchasedLivestocks convert(PurchasedLivestocks livestockDTO) {
//        Gson gson = new Gson();
//        String jsonInString = gson.toJson(livestockDTO);
//        Gson gson_ = new Gson();
//        String json = jsonInString;
//        PurchasedLivestocks obj = gson.fromJson(jsonInString, PurchasedLivestocks.class);
//        return obj;
//    }

   
}
