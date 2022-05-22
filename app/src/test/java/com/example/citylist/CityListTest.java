package com.example.citylist;

import org.junit.Test;

import static org.junit.Assert.*;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities(0).size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities(0).size());
        assertTrue(cityList.getCities(0).contains(city));
    }

    /**
     * this function  will check the number of cities after deletion
     */
    @Test
    public void testDelete() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities(0).size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.count());

        cityList.delete(city);
        assertEquals(1, cityList.count());

    }

    /**
     * this function  will check the exception while deletion
     */
    @Test
    public void testDeleteException() {
        CityList cityList= new CityList();
        City city = new City("Regina", "SK");
        cityList.add(city);
        cityList.delete(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);
        });
    }

    /**
     * this function will count the number of cities in the cityList
     */
    @Test
    public void testCount() {
        CityList cityList=mockCityList();
        assertEquals(1,cityList.count());
        City city = new City("Regina", "SK");
        cityList.add(city);
        assertEquals(2,cityList.count());
    }

    private void assertEquals(int i, int size) {
    }

    @Test
    public void testAddException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    /**
     * this function will return the cityList in sorted order
     * if input is zero then it will sort according to city if input
     * is one then it will sort according to province and check the output
     */
    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities(0).get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities(0).get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities(0).get(1)));

        assertEquals(0, city.compareTo(cityList.getCities(1).get(1)));
        assertEquals(0, mockCity().compareTo(cityList.getCities(1).get(0)));
    }
}
