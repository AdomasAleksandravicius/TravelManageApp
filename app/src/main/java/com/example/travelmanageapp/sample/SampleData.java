package com.example.travelmanageapp.sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.travelmanageapp.models.Country;

public class SampleData {

    public static List<Country> countryList;
    public static Map<String,Country> countryMap;

    static {
        countryMap = new HashMap<>();
        countryList = new ArrayList<>();

        addItem(new Country(null,"Japonija","geras salis daug visko pamatyt galima","flag.jpg"));
        addItem(new Country(null,"Anglija","geras salis daug visko pamatyt galima,normaliai","flag.jpg"));
        addItem(new Country(null,"Rusija","geras salis daug visko pamatyt galima keliaut","flag.jpg"));
    }

    public static void addItem(Country country){
        countryList.add(country);
        countryMap.put(country.getId(),country);

    }
    public static Country findCountry(String id){
        Country country = null;
        for (int i = 0; i <countryList.size() ; i++) {
            if (id.equals(countryList.get(i).getId())){
                 country = countryList.get(i);
            }
        }
        return country;
    }

}
