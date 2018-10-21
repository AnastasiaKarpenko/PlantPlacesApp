package ws.tilda.anastasia.plantplacesapp.service;

import java.util.List;

import ws.tilda.anastasia.plantplacesapp.dto.PlantDTO;

/**
 * Business logic for fetching and managing plants
 */

public interface IPlantService {
    /**
     * Accept filter text, and return a collection of plants that contain that filter text
     *
     * @param filter the text that should  be contained in the returned plants.
     * @return a list of plants that match search criteria
     */

    List<PlantDTO> fetchPlants(String filter);
}
