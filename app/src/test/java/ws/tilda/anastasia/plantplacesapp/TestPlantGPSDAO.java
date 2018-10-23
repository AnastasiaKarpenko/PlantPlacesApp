package ws.tilda.anastasia.plantplacesapp;

import org.junit.Test;

import java.util.List;

public class TestPlantGPSDAO {

    private ISpecimenDAO specimenDAO;
    private List<SpecimenDTO> specimens;

    @Test
    public void testGPSDAO_fetchGPSReturnsResultsWithinRange() {
        givenGPSDAOInitialized();
        whenSearchForSpecimensNearBotanicGarden();
        thenReturnSpecimensWithinRange();
    }

    private void thenReturnSpecimensWithinRange() {

    }

    private void whenSearchForSpecimensNearBotanicGarden() {

    }

    private void givenGPSDAOInitialized() {

    }

}
