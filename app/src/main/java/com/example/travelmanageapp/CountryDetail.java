package com.example.travelmanageapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.travelmanageapp.adapters.CountryAdapter;
import com.example.travelmanageapp.models.Country;
import com.example.travelmanageapp.sample.SampleData;

public class CountryDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String itemId = getIntent().getExtras().getString(CountryAdapter.ITEM_ID_KEY);
        Country country = SampleData.countryMap.get(itemId);
        TextView describtion = (TextView)findViewById(R.id.single_description);
        describtion.setText(country.getDescription());
        TextView name = (TextView)findViewById(R.id.name);
        name.setText(country.getName());

    }

}
