package ws.tilda.anastasia.plantplacesapp;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import ws.tilda.anastasia.plantplacesapp.dao.IPlantDAO;
import ws.tilda.anastasia.plantplacesapp.dao.PlantDAOStub;
import ws.tilda.anastasia.plantplacesapp.dto.PlantDTO;

import static org.junit.Assert.assertTrue;

public class TestPlantDAO {

    // define a variable that we are testing
    IPlantDAO plantDAO;

    @Before
    public void setUp() {
        plantDAO = new PlantDAOStub();
    }


    @Test
    public void testPlantDAO_searchForRedbudShouldReturnAtLeastOneResult() {
        List<PlantDTO> plants = plantDAO.fetchPlants("Redbud");

        // assume we don't have a match
        boolean redbudFound = false;

        for (PlantDTO plant : plants) {
            if (plant.getCommon().contains("Redbud")) {
                redbudFound = true;
            }
        }
        // did we find a redbud?
        assertTrue(redbudFound);
    }
}
