package com.example.lab_06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps a list of City objects.
 */
public class CityList {

    private final List<City> cities = new ArrayList<>();

    /**
     * Adds a City object to the list.
     *
     * @param city the City object to add
     * @throws IllegalArgumentException if the City object already exists in the list
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException("City already exists");
        }
        cities.add(city);
    }

    /**
     * Returns a sorted list of City objects.
     *
     * @return a sorted list of City objects
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * Checks if a City object exists in the list.
     *
     * @param city the City object to check
     * @return true if the City object exists, false otherwise
     */
    public boolean hasCity(City city) {
        if (city == null) {
            throw new IllegalArgumentException("City cannot be null");
        }
        if (city.getCityName().isEmpty()) {
            throw new IllegalArgumentException("City is empty");
        }
        if (city.getProvinceName().isEmpty()) {
            throw new IllegalArgumentException("Province is empty");
        }

        return cities.contains(city);
    }

    /**
     * Deletes a City object from the list.
     *
     * @param city the City object to delete
     */
    public void delete(City city) {
        if (city == null) {
            throw new IllegalArgumentException("City cannot be null");
        }
        if (!cities.contains(city)) {
            throw new IllegalArgumentException("City does not exist");
        }
        cities.remove(city);
    }

    /**
     * Counts the number of City objects in the list.
     *
     * @return the number of City objects in the list
     */
    public int countCities() {
        if (cities.size() >= 0) {
            return cities.size();
        }
        return 0;
    }
}
