package sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Country;

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

}
