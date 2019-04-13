package com.example.travelmanageapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import Screens.ListScreen;
import models.Country;
import sample.SampleData;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.manageList);

        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                goToListScreen();

            }

        });
    }
    private void goToListScreen() {

        Intent intent = new Intent(this, ListScreen.class);

        startActivity(intent);

    }

}

