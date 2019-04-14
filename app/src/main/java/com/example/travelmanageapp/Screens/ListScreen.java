package com.example.travelmanageapp.Screens;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.travelmanageapp.R;

import java.util.ArrayList;
import java.util.List;

import com.example.travelmanageapp.adapters.CountryAdapter;

import com.example.travelmanageapp.models.Country;
import com.example.travelmanageapp.sample.SampleData;

public class ListScreen extends AppCompatActivity {

    List<Country> countryList = SampleData.countryList;
    List<String>itemNames = new ArrayList<>();
    TextView button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_screen);

        CountryAdapter countryAdapter = new CountryAdapter(this,countryList);

        RecyclerView view = (RecyclerView) findViewById(R.id.rvItems);
        view.setAdapter(countryAdapter);

    }


}
