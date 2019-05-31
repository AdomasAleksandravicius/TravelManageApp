package com.example.travelmanageapp.Screens;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.travelmanageapp.R;

import java.util.ArrayList;
import java.util.List;

import com.example.travelmanageapp.adapters.CountryAdapter;

import com.example.travelmanageapp.compound_control.RateBar;
import com.example.travelmanageapp.models.City;
import com.example.travelmanageapp.models.Country;
import com.example.travelmanageapp.sample.SampleData;

public class ListScreen extends AppCompatActivity {

    List<Country> countryList;
    List<City> cityList = SampleData.cityList;

    private CountryAdapter countryAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_screen);

        countryList = new ArrayList<>();

        for(String s : SampleData.countryMap.keySet()){
            countryList.add(SampleData.countryMap.get(s));
        }

        countryAdapter = new CountryAdapter(this,countryList);

        RecyclerView view = (RecyclerView) findViewById(R.id.rvItems);

        RateBar rateBar = findViewById(R.id.rating);

        rateBar.setStars(3);

        view.setAdapter(countryAdapter);

    }

    @Override
    protected void onResume() {

        countryAdapter.notifyChanges();

        super.onResume();
    }
}
