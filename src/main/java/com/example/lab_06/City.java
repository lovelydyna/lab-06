package com.example.lab_06;
import java.util.Objects;

/**
 * Class that defines a City object.
 */
public class City implements Comparable<City> {
    private String city; // name of the city
    private String province; // name of the province

    /**
     * Constructor for the City class.
     * @param city the name of the city
     * @param province the name of the province
     */
    City(String city, String province) {
        this.city = city;
        this.province = province;
    }

    /**
     * Getter for the city name.
     * @return the name of the city
     */
    public String getCityName() {
        return this.city;
    }

    /**
     * Getter for the province name.
     * @return the name of the province
     */
    public String getProvinceName() {
        return this.province;
    }

    /**
     * Compares this City object to another City object.
     * @param other the other City object
     * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(City other) {
        return this.city.compareTo(other.getCityName());
    }

    /**
     * Compares this City object to another City object.
     * @param obj the other City object
     * @return true if the City objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof City)) return false;
        City other = (City) obj;
        return this.city.equals(other.city) && this.province.equals(other.province);
    }

    /**
     * Generates a hash code for this City object.
     * @return a hash code value for this City object
     */
    @Override
    public int hashCode() {
        return Objects.hash(city, province);
    }
}
