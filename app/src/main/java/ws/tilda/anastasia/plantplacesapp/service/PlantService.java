package ws.tilda.anastasia.plantplacesapp.service;

import java.util.List;

import ws.tilda.anastasia.plantplacesapp.dao.IPlantDAO;
import ws.tilda.anastasia.plantplacesapp.dao.PlantJsonDao;
import ws.tilda.anastasia.plantplacesapp.dto.PlantDTO;

public class PlantService implements IPlantService {
    IPlantDAO plantDAO;

    public PlantService() {
        plantDAO = new PlantJsonDao();
    }

    @Override
    public List<PlantDTO> fetchPlants(String filter) {
        return plantDAO.fetchPlants(filter);
    }
}
