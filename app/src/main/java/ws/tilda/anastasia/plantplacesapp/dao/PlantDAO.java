package ws.tilda.anastasia.plantplacesapp.dao;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

import ws.tilda.anastasia.plantplacesapp.dto.PlantDTO;

public class PlantDAO implements IPlantDAO {
    @Override
    public List<PlantDTO> fetchPlants(String filter) throws IOException, JSONException {
        return null;
    }
}
