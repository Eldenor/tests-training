package com.sda.tests.weater;

import java.util.List;
import java.util.stream.Collectors;

public class WeatherStatisticsService {

    private final WeatherService weatherService;

    public WeatherStatisticsService(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    public int getMeasurementsCount() {
        return weatherService.getTemperatureList("Wroclaw").size();
    }

    public double getAverageTemperature(String cityName) {
        List<Double> temperatureList = weatherService.getTemperatureList(cityName);


        double sum = 0;

        for (Double temperature:temperatureList) {
            sum += temperature;
        }

        return sum / temperatureList.size();

    }

    public double getRainSumForCities(List<String> cities){
        return 0;
    }
}
