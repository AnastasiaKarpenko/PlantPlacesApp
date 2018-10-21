package ws.tilda.anastasia.plantplacesapp.dao;

import java.util.List;

import ws.tilda.anastasia.plantplacesapp.dto.PlantDTO;

/**
 * A collection of methods to access plants data
 */

public interface IPlantDAO {

    /**
     * Accept filter text, and return a collection of plants that contain that filter text
     *
     * @param filter the text we wanna match in our return collection of plants
     * @return a list of plants that contain the given filter in either genus, species, cultivar, or common name
     */

    public List<PlantDTO> fetchPlants(String filter);
}
