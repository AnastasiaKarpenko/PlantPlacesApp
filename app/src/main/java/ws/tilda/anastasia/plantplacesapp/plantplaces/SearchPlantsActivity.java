package ws.tilda.anastasia.plantplacesapp.plantplaces;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import java.util.List;

import ws.tilda.anastasia.plantplacesapp.R;
import ws.tilda.anastasia.plantplacesapp.dto.PlantDTO;
import ws.tilda.anastasia.plantplacesapp.service.IPlantService;
import ws.tilda.anastasia.plantplacesapp.service.PlantService;

public class SearchPlantsActivity extends AppCompatActivity {

    IPlantService plantService;
    private AutoCompleteTextView actPlantName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_plants);
        plantService = new PlantService();

        actPlantName = findViewById(R.id.actPlantName);

    }

    public void searchPlants(View v) {
        List<PlantDTO> plants = plantService.fetchPlants(actPlantName.getText().toString());

        for (PlantDTO plant : plants) {
            String showText = "";

            Toast.makeText(this, showText, Toast.LENGTH_LONG).show();
        }
    }
}
