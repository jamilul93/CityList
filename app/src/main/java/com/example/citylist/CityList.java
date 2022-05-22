package com.example.citylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if that city does not exist
     * @param city
     *      This is the city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * this function delete cities from cityList if city
     * does not exits it throw exception
     * @param city
     */
    public void delete(City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        else
            cities.remove(city);
    }

    /**
     * This is city count method
     * @return
     *      returning  number of cities
     */
    public int count() {
        return cities.size();
    }

    /**
     * This returns a sorted list of cities
     * @param test
     * if test = 0, comparing by cities
     * else comparing by province
     * @return
     *      Return the sorted list of cities
     */
    public List<City> getCities(int test) {
        List<City> cityList = cities;
        if(test == 0)
            Collections.sort(cityList);
        else
            cityList.sort(Comparator.comparing(City::getProvinceName));
        return cityList;
    }
}
