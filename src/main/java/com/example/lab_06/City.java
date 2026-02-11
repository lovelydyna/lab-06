package com.example.listycity;

/**
 * Class that defines a City object.
 */
public class City implements Comparable<City> {
    private String city; // name of the city
    private String province; // name of the province

    /*
     * Constructor for the City class.
     * @param city the name of the city
     * @param province the name of the province
     */
    City(String city, String province) {
        this.city = city;
        this.province = province;
    }

    /*
     * Getter for the city name.
     * @return the name of the city
     */
    public String getCityName() {
        return this.city;
    }

    /*
     * Getter for the province name.
     * @return the name of the province
     */
    public String getProvinceName() {
        return this.province;
    }

    public int compareTo(City other) {
        return this.city.compareTo(other.getCityName());
    }
}
