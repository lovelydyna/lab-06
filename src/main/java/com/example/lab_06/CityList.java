package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps a list of City objects.
 */
public class CityList {

    private List<City> cities = new ArrayList<>();

    /**
     * Adds a City object to the list.
     * @param city the City object to add
     * @throws IllegalArgumentException if the City object already exists in the list
     */
    public void add (City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException("City already exists");
        }
        cities.add(city);
    }

    /**
     * Returns a sorted list of City objects.
     * @return a sorted list of City objects
     */
    public List<City> getCities() {
        List<City> list =  cities;
        Collections.sort(list);
        return list;
    }



}
