package ws.tilda.anastasia.plantplacesapp;

import org.json.JSONException;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import ws.tilda.anastasia.plantplacesapp.dao.IPlantDAO;
import ws.tilda.anastasia.plantplacesapp.dao.PlantDAO;
import ws.tilda.anastasia.plantplacesapp.dto.PlantDTO;

import static org.junit.Assert.assertEquals;
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

    @Test
    public void testPlantDAO_fetchShouldReturnAtLeastTwoOaksForQuercus() throws IOException, JSONException {
        givenPlantDAOIsInitialized();
        whenSearchForQuercus();
        thenVerifyTwoOaks();

    }

    @Test
    public void testPlantDAO_fetchShouldReturnNothingForGibberish() throws IOException, JSONException {
        givenPlantDAOIsInitialized();
        whenSearchForGibberish();
        thenVerifyNoResults();
    }

    private void thenVerifyNoResults() {
        int size = plants.size();
        assertEquals(0, size);
    }

    private void whenSearchForGibberish() throws IOException, JSONException {
        plants = plantDAO.fetchPlants("skujapodhsjl");
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


    private void whenSearchForQuercus() throws IOException, JSONException {
        plants = plantDAO.fetchPlants("Quercus");
    }

    private void thenVerifyTwoOaks() {
// assume we don't have a match
        boolean quercusRoburFound = false;
        for (PlantDTO plant : plants) {
            if (plant.getGenus().contains("Quercus") && plant.getSpecies().contains("robur")
                    && plant.getCommon().contains("Oak")) {
                quercusRoburFound = true;
            }
        }
        // did we find a quercus?
        assertTrue(quercusRoburFound);

        System.out.println("Test: Running quercus robur test");

        // assume we don't have a match
        boolean quercusAlbaFound = false;

        for (PlantDTO plant : plants)

        {
            if (plant.getGenus().contains("Quercus") && plant.getSpecies().contains("alba")
                    && plant.getCommon().contains("Oak")) {
                quercusAlbaFound = true;
            }
        }

        // did we find a quercus?
        assertTrue(quercusAlbaFound);

        System.out.println("Test: Running quercus alba test");
    }

}
