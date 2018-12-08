package com.sda.tests.weater;

public class WeatherStatisticsService {

    private final WeatherService weatherService;

    public WeatherStatisticsService(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    public int getMeasurementsCount() {
        return weatherService.getTemperatureList("Wroclaw").size();
    }
}
