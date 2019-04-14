package com.example.travelmanageapp.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.travelmanageapp.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.example.travelmanageapp.models.Country;

public class CountryAdapterListView extends ArrayAdapter<Country> {
    List<Country> mCountryList;
    LayoutInflater mInflater;
    public CountryAdapterListView(Context context, List<Country> objects) {
        super(context, R.layout.countrylistitem, objects);
        mCountryList = objects;
        mInflater = LayoutInflater.from(context);
    }


    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
       if (convertView == null) {
            convertView = mInflater.inflate(R.layout.countrylistitem,parent,false);
        }

       TextView countryName = (TextView)convertView.findViewById(R.id.itemNameText);
       ImageView image = (ImageView)convertView.findViewById(R.id.imageView2);

       Country country = mCountryList.get(position);

        countryName.setText(country.getName());
        InputStream inputStream = null;
        try {
            String imageFile = country.getImage();
            inputStream= getContext().getAssets().open(imageFile);
            Drawable d = Drawable.createFromStream(inputStream,null);
            image.setImageDrawable(d);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {

                if (inputStream != null){
                    inputStream.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }

       return convertView;
    }


}
