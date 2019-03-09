package com.sda.tests.weater;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WeatherStatisticsTestExcersies {

    private WeatherStatisticsService weatherStatisticsService;

    private WeatherService weatherService;

    @BeforeEach
    public void setUp(){

        weatherService = mock(WeatherService.class);

        weatherStatisticsService = new WeatherStatisticsService(weatherService);
    }

    @Test
    public void shouldFindAverageTemperature(){

        //given
        List<Double> mockedTemperatures = Arrays.asList(1d, 2d, 3d);
        when(weatherService.getTemperatureList(anyString()))
                .thenReturn(mockedTemperatures);

        //when
        double actualAverage = weatherStatisticsService
                .getAverageTemperature("Wroclaw");

        //then
        Assertions.assertThat(actualAverage)
                .isEqualTo(2d);
    }

}
