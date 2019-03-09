package com.sda.tests.weater;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class WeatherStatisticsServiceTest {

    WeatherStatisticsService weatherStatisticsService;

    WeatherService weatherService = mock(WeatherService.class);

    @BeforeEach
    public void setUp() {
        when(weatherService.getTemperatureList(any())).thenReturn(Arrays.asList(1d, 2d));

        weatherStatisticsService = new WeatherStatisticsService(weatherService);
    }

    @Test
    void getMeasurementsCountTest() {
        int measurementsCount = weatherStatisticsService.getMeasurementsCount();
        assertEquals(measurementsCount, 2);
    }
}