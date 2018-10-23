package ws.tilda.anastasia.plantplacesapp;

import org.json.JSONException;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import ws.tilda.anastasia.plantplacesapp.dao.IPlantDAO;
import ws.tilda.anastasia.plantplacesapp.dao.PlantDAO;
import ws.tilda.anastasia.plantplacesapp.dto.PlantDTO;

import static org.junit.Assert.assertTrue;

public class BDDTestPlantDAO {
    IPlantDAO plantDAO;
    private List<PlantDTO> plants;

    @Test
    public void testPlantDAO_fetchShouldReturnResultsForRedbud() throws IOException, JSONException {
        givenPlantDAOIsInitialized();
        whenSearchForRedbud();
        thenVerifyAtLeastOneCercisCanadensis();
    }

    private void givenPlantDAOIsInitialized() {
        plantDAO = new PlantDAO();
    }

    private void whenSearchForRedbud() throws IOException, JSONException {
        plants = plantDAO.fetchPlants("Redbud");
    }

    private void thenVerifyAtLeastOneCercisCanadensis() {
        // assume we don't have a match
        boolean redbudFound = false;
        for (PlantDTO plant : plants) {
            if (plant.getGenus().contains("Cercis") && plant.getSpecies().contains("canadensis")) {
                redbudFound = true;
            }
        }
        // did we find a cercis canadensis?
        assertTrue(redbudFound);

        System.out.println("Test: Running Redbud test");
    }


}
