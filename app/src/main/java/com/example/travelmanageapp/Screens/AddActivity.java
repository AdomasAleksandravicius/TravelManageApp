package com.example.travelmanageapp.Screens;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.travelmanageapp.R;
import com.example.travelmanageapp.adapters.CityAdapter;
import com.example.travelmanageapp.models.City;
import com.example.travelmanageapp.models.Country;
import com.example.travelmanageapp.sample.SampleData;

import java.util.List;

public class AddActivity extends AppCompatActivity {
    private List<City> cityList = SampleData.cityList;
    private EditText mName;
    private EditText mDescribtion;
    private Button mAdd;
    private Button mAddCity;
    private EditText cityName;
    private CityAdapter cityAdapter = new CityAdapter(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        mName = findViewById(R.id.name);
        mDescribtion =findViewById(R.id.describtionEdit);
        mAdd = findViewById(R.id.addCountry);
        mAddCity = findViewById(R.id.addCity);
        cityName = findViewById(R.id.cityName);

        RecyclerView viewCity = findViewById(R.id.cityList);
        viewCity.setAdapter(cityAdapter);

        mAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveCountry();
            }
        });

        mAddCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCity();
            }
        });

    }

    private void addCity(){
        String name = cityName.getText().toString();
        if (TextUtils.isEmpty(name)){
            return;
        }

        City city = new City(name);
        cityAdapter.addCity(city);
    }

    private void saveCountry() {
        Country newCountry = new Country();
        newCountry.setCities(cityAdapter.getCities());
        newCountry.setName(mName.getText().toString());
        newCountry.setDescription(mDescribtion.getText().toString());
        SampleData.addItem(newCountry);
        finish();
    }

}
