package ws.tilda.anastasia.plantplacesapp.dao;

import org.json.JSONException;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import ws.tilda.anastasia.plantplacesapp.dao.IPlantDAO;
import ws.tilda.anastasia.plantplacesapp.dao.NetworkDAO;
import ws.tilda.anastasia.plantplacesapp.dao.PlantDAO;
import ws.tilda.anastasia.plantplacesapp.dto.PlantDTO;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

    @Test
    public void testPlantDAO_fetchShouldReturnGenusQuercusForQuercus() throws IOException, JSONException {
        givenPlantDAOIsInitialized();
        whenSearchForQuercus();
        thenVerifyAllGenusAreQuercus();

    }

    private void thenVerifyAllGenusAreQuercus() {
        for (PlantDTO plant : plants) {
            assertThat(plant, hasProperty("genus", containsString("Quercus")));
        }
    }

    private void thenVerifyNoResults() {
        assertThat(plants, empty());
    }

    private void whenSearchForGibberish() throws IOException, JSONException {
        plants = plantDAO.fetchPlants("skujapodhsjl");
    }

    private void givenPlantDAOIsInitialized() throws IOException {
        plantDAO = new PlantDAO();

        //here we are going to mock NetworkDAO
        NetworkDAO mock = mock(NetworkDAO.class);
        when(mock.fetch("http://plantplaces.com/perl/mobile/viewplantsjson.pl?Combined_Name=Quercus"))
                .thenReturn(quercusJSON);
        when(mock.fetch("http://plantplaces.com/perl/mobile/viewplantsjson.pl?Combined_Name=skujapodhsjl"))
                .thenReturn(gibberishJSON);
        when(mock.fetch("http://plantplaces.com/perl/mobile/viewplantsjson.pl?Combined_Name=Redbud"))
                .thenReturn(redbudJSON);

        plantDAO.setNetworkDAO(mock);
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

    String redbudJSON = "{\"plants\":[" +
            "{\"id\":\"83\",\"genus\":\"Cercis\",\"species\":\"canadensis\",\"cultivar\":\"\",\"common\":\"Eastern Redbud\"}," +
            "]}";

    String quercusJSON =
            "{\"plants\":[" +
                    "{\"id\":\"286\",\"genus\":\"Quercus\",\"species\":\"alba\",\"cultivar\":\"\",\"common\":\"White Oak\"}," +
                    "{\"id\":\"286\",\"genus\":\"Quercus\",\"species\":\"robur\",\"cultivar\":\"\",\"common\":\"English Oak\"}" +
                    "]}";

    String gibberishJSON =
            "{\"plants\":[" +
                    "]" +
                    "}-1";

}
