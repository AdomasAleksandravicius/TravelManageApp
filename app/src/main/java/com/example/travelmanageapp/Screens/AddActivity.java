package com.example.travelmanageapp.Screens;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.travelmanageapp.R;
import com.example.travelmanageapp.models.Country;
import com.example.travelmanageapp.sample.SampleData;

public class AddActivity extends AppCompatActivity {

    private EditText mName;
    private Button mAdd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        mName = findViewById(R.id.name);
        mAdd = findViewById(R.id.addCountry);

        mAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveCountry();
            }
        });
    }

    private void saveCountry() {
        Country newCountry = new Country();
        newCountry.setName(mName.getText().toString());
        SampleData.addItem(newCountry);
        finish();
    }

}
