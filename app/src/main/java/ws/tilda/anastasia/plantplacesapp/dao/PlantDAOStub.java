package ws.tilda.anastasia.plantplacesapp.dao;

import java.util.ArrayList;
import java.util.List;

import ws.tilda.anastasia.plantplacesapp.dto.FlowerDTO;
import ws.tilda.anastasia.plantplacesapp.dto.PlantDTO;
import ws.tilda.anastasia.plantplacesapp.dto.TreeDTO;

public class PlantDAOStub implements IPlantDAO {
    @Override
    public List<PlantDTO> fetchPlants(String filter) {
        List<PlantDTO> allPlants = new ArrayList<>();

        TreeDTO plant = new TreeDTO();
        plant.setGenus("Cercis");
        plant.setSpecies("canadensis");
        plant.setCommon("Eastern Redbud");
        plant.setSize(30);
        plant.setFallColor("Yellowish");
        plant.setType("tree");
        allPlants.add(plant);

        PlantDTO flower = new FlowerDTO();
        flower.setGenus("Tropoleum");
        flower.setSpecies("spp");
        flower.setCommon("Nasturitium");
        allPlants.add(flower);
        flower.setType("flower");

        return allPlants;
    }

    @Override
    public void setNetworkDAO(NetworkDAO networkDAO) {

    }
}
