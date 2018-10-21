package ws.tilda.anastasia.plantplacesapp.plantplaces;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;

import ws.tilda.anastasia.plantplacesapp.R;
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
        plantService.fetchPlants(actPlantName.getText().toString());
    }
}
