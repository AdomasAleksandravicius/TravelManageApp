package com.example.travelmanageapp.Screens;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.travelmanageapp.R;
import com.example.travelmanageapp.adapters.CityAdapter;
import com.example.travelmanageapp.adapters.CountryAdapter;
import com.example.travelmanageapp.models.City;
import com.example.travelmanageapp.models.Country;
import com.example.travelmanageapp.sample.SampleData;

import java.util.List;

public class AddActivity extends AppCompatActivity {
    private List<City> cityList = SampleData.cityList;
    private EditText mName;
    private EditText mDescribtion;
    private Button mAdd;
    private EditText cityName;
    private CityAdapter cityAdapter = new CityAdapter(this,cityList);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        mName = findViewById(R.id.name);
        mDescribtion =findViewById(R.id.describtionEdit);
        mAdd = findViewById(R.id.addCountry);
        cityName =findViewById(R.id.city);

        RecyclerView viewCity = (RecyclerView) findViewById(R.id.city);
        viewCity.setAdapter(cityAdapter);

        mAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveCountry();
            }
        });
    }

    private void saveCountry() {
        Country newCountry = new Country();
        City city = new City();
        city.setName(cityName.getText().toString());
        cityAdapter.addCity(cityList);
        newCountry.setName(mName.getText().toString());
        newCountry.setDescription(mDescribtion.getText().toString());
        SampleData.addItem(newCountry,city);
        finish();
    }

}
