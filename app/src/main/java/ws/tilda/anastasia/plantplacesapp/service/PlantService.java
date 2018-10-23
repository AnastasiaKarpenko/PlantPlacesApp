package ws.tilda.anastasia.plantplacesapp.service;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

import ws.tilda.anastasia.plantplacesapp.dao.IPlantDAO;
import ws.tilda.anastasia.plantplacesapp.dao.PlantDAOStub;
import ws.tilda.anastasia.plantplacesapp.dto.PlantDTO;

public class PlantService implements IPlantService {
    IPlantDAO plantDAO;

    public PlantService() {
        plantDAO = new PlantDAOStub();
    }

    @Override
    public List<PlantDTO> fetchPlants(String filter) throws IOException, JSONException {
        return plantDAO.fetchPlants(filter);
    }
}
