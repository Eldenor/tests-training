package com.sda.tests.weater;

import org.junit.jupiter.api.Test;

import java.util.List;

class WeatherServiceTest {

    private WeatherService weatherService = new WeatherService();

    @Test
    public void test() {
        Double wroclaw = weatherService.rainForecastSum("Wroclaw");
        System.out.println(wroclaw);
    }
}