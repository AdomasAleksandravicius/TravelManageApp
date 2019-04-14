package com.example.travelmanageapp.Screens;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.travelmanageapp.R;
import com.example.travelmanageapp.models.Country;
import com.example.travelmanageapp.sample.SampleData;

import static com.example.travelmanageapp.adapters.CountryAdapter.ITEM_ID_KEY;

public class EditCountry extends AppCompatActivity {
    private EditText mName;
    private EditText mDescribtion;
    private Button mEdit;
    private Bundle extras;

    private String itemId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_country);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mName = findViewById(R.id.name2);
        mDescribtion =findViewById(R.id.describtionEdit2);
        mEdit = findViewById(R.id.editCountry);
        extras = getIntent().getExtras();
        itemId = extras.getString(ITEM_ID_KEY);
        final Country country = SampleData.countryMap.get(itemId);
        mEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editCountry(country);
            }
        });
        mName.setText(country.getName());
        mDescribtion.setText(country.getDescription());

    }

    @Override
    public void onBackPressed() {

        Country newCountry = new Country(null,mName.getText().toString(),mDescribtion.getText().toString());
        SampleData.replaceCountry(itemId,newCountry);
        super.onBackPressed();
    }

    private void editCountry(Country country) {

        country.setName(mName.getText().toString());
        country.setDescription(mDescribtion.getText().toString());
        finish();
    }

}
