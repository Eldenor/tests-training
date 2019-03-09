package com.sda.tests.median;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

class MedianCalculatorTest {


    @ParameterizedTest
    @MethodSource("medianTestData")
    public void test(int[] array, int expectedValue) {
        int median = MedianCalculator.getMedian(array);
        Assertions.assertThat(median).isEqualTo(expectedValue);
    }

    private static List<Arguments> medianTestData() {
        int[] testData0 = null;
        int[] testData1 = {};
        int[] testData2 = {2};
        int[] testData3 = {1, 7};
        int[] testData4 = {1, 2, 3};
        int[] testData5 = {10, 20, 30, 40};
        int[] testData6 = {7, 9, 4};
        return Arrays.asList(
                Arguments.of(testData0, -1),
                Arguments.of(testData1, -1),
                Arguments.of(testData2, 2),
                Arguments.of(testData3, 4),
                Arguments.of(testData4, 2),
                Arguments.of(testData5, 25),
                Arguments.of(testData6, 7)
        );
    }

}