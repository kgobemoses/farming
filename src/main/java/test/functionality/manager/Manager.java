package test.functionality.manager;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import test.functionality.dao.implementation.LiveStockDAOImpl;
import test.functionality.dto.LivestockDTO;
import test.functionality.entity.Livestock;

@Stateless
public class Manager {

    private LiveStockDAOImpl liveStockDAOImpl;

    public Manager() {
        super();
    }

    @Inject
    public Manager(LiveStockDAOImpl liveStockDAOImpl) {
        super();
        this.liveStockDAOImpl = liveStockDAOImpl;
    }

    public LivestockDTO create(LivestockDTO livestockDTO) {
        Livestock livestock = new Livestock();
        liveStockDAOImpl.create(convert(livestockDTO));
        return livestockDTO;
    }

    public List<Livestock> retrieveAll() {
       return liveStockDAOImpl.retriveLivestock();
    }
    
    public List<Livestock> searchBy(String type, String value) {
        return liveStockDAOImpl.searchBy(type, value);
    }

    public LivestockDTO retrieveByTagNumber(int tagNumber) {

        return convert(liveStockDAOImpl.findByTagNumber(tagNumber));
    }
    
    private LivestockDTO convert(Livestock livestockDTO) {
        Gson gson = new Gson();
        String jsonInString = gson.toJson(livestockDTO);
        Gson gson_ = new Gson();
        String json = jsonInString;
        LivestockDTO livestock = gson.fromJson(jsonInString, LivestockDTO.class);
        return livestock;
    }

    private Livestock convert(LivestockDTO livestockDTO) {
        Gson gson = new Gson();
        String jsonInString = gson.toJson(livestockDTO);
        Gson gson_ = new Gson();
        String json = jsonInString;
        Livestock livestock = gson.fromJson(jsonInString, Livestock.class);
        return livestock;
    }

   
}
