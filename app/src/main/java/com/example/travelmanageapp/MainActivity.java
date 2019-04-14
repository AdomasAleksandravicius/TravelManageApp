package com.example.travelmanageapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.travelmanageapp.Screens.ListScreen;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.manageList);

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

