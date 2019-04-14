package com.example.travelmanageapp.sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.travelmanageapp.models.City;
import com.example.travelmanageapp.models.Country;

public class SampleData {

    public static List<Country> countryList;
    public static  List<City> cityList;
    public static Map<String,Country> countryMap;

    static {
        countryMap = new HashMap<>();
        countryList = new ArrayList<>();
        //countryList = new ArrayList<>();

//        addItem(new Country(null,"Japonija","geras salis daug visko pamatyt galima"),new City("hakamora"));
//        addItem(new Country(null,"Anglija","geras salis daug visko pamatyt galima,normaliai"),new City("hakamora"));
//        addItem(new Country(null,"Rusija","geras salis daug visko pamatyt galima keliaut"),new City("hakamora"));
        Country country = new Country(null,"LATVIJA","noriu noriu");
//        addItem(country);
        countryMap.put("1", country);


    }

    public static String getString(Country currentCountry){

        for (String currentVal: countryMap.keySet()){
            if (countryMap.get(currentVal).getName().contains(currentCountry.getName())){
                return currentVal;
            }
        }

        return null;
    }

    public static void addItem(Country country,City city){
        countryList.add(country);
        cityList.add(city);
        countryMap.put(country.getId(),country);

    }

    public static void replaceCountry(String key, Country country){
        countryMap.remove(key);
        countryMap.put(key, country);
    }

    public static void addItem(Country country){
        countryMap.put(country.getId(),country);
    }

    public static Country findCountry(String id){
        Country country = null;
        for (int i = 0; i <countryMap.size() ; i++) {
            if (id.equals(countryMap.get(i).getId())){
                 country = countryMap.get(i);
            }
        }
        return country;
    }
}
