package Screens;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import com.example.travelmanageapp.R;

import java.util.ArrayList;
import java.util.List;

import adapters.CountryAdapter;
import adapters.CountryAdapterListView;
import models.Country;
import sample.SampleData;

public class ListScreen extends AppCompatActivity {

    List<Country> countryList = SampleData.countryList;
    List<String>itemNames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_screen);

        CountryAdapter countryAdapter = new CountryAdapter(this,countryList);

        RecyclerView view = (RecyclerView) findViewById(R.id.rvItems);
        view.setAdapter(countryAdapter);
    }

}
