package ws.tilda.anastasia.plantplacesapp;

import org.json.JSONException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import ws.tilda.anastasia.plantplacesapp.dao.IPlantDAO;
import ws.tilda.anastasia.plantplacesapp.dao.PlantDAOStub;
import ws.tilda.anastasia.plantplacesapp.dto.PlantDTO;

import static org.junit.Assert.assertTrue;

public class TestPlantDAO {

    // define a variable that we are testing
    IPlantDAO plantDAO;

    @BeforeClass
    public static void setupAllTests() {
        System.out.println("BeforeClass: running init for ALL tests");
    }


    @Before
    public void setUp() {
        plantDAO = new PlantDAOStub();
        System.out.println("Before: running init for EACH test");
    }


    @Test
    public void testPlantDAO_searchForRedbudShouldReturnAtLeastOneResult() throws IOException, JSONException {
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

        System.out.println("Test: Running redbud test");
    }

    @Test
    public void testPlantDAO_searchForOakShouldReturnAtLeastOneWhiteOak() throws IOException, JSONException {
        List<PlantDTO> plants = plantDAO.fetchPlants("Oak");

        // assume we don't have a match
        boolean whiteOakFound = false;

        for (PlantDTO plant : plants) {
            if (plant.getGenus().contains("Quercus") && plant.getSpecies().contains("alba")) {
                whiteOakFound = true;
            }
        }
        // did we find a white oak?
        assertTrue(whiteOakFound);

        System.out.println("Test: Running white oak test");
    }


    public void testPlantDAO_searchForEShouldReturnAtLeastTwoResults() throws IOException, JSONException {
        List<PlantDTO> plants = plantDAO.fetchPlants("e");
        int size = plants.size();
        boolean atLeastTwo = size > 2;
        assertTrue(atLeastTwo);
        System.out.println("Test: this should not run because it is not annotated");

        //assertThat(size, is(greaterThan(2)));
    }

    @After
    public void teardown() {
        System.out.println("After: Tearing down after EACH test");
    }

    @AfterClass
    public static void teardownAllTests() {
        System.out.println("AfterClass: Tearing down after ALL tests");
    }
}
