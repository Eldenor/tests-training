package com.sda.tests.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorParametrizedTest {

    @ParameterizedTest
    @ValueSource(doubles = {0, 1.2, 1000})
    void shouldSqrt(double number){
        Calculator calculator = new Calculator();
        double actualResult = calculator.sqrt(number);
        double expetedResult = Math.sqrt(number);
        assertEquals(expetedResult, actualResult);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1.2, -1000, -191919})
    void shouldNotSqrt(double number){
        Calculator calculator = new Calculator();
        double actualResult = 0;
        try {
            actualResult = calculator.sqrt(number);
        } catch (Exception e) {
            assertNotNull(e);
            assertEquals(e.getMessage(), "Must be positve");
        }

    }

    @DisplayName("Adding with parameters is cool.")
    @ParameterizedTest
    @CsvSource({
            "1,2,3",
            "7,10,17",
            "100,999,1099"
    })
    void add_ShouldAddTwoNumbers(int a, int b, int expectedAddResult){
        Calculator calculator = new Calculator();
        //when
        int actuualAddResult = calculator.add(a, b);
        //then
        assertEquals(expectedAddResult, actuualAddResult);
    }

    @DisplayName("Adding with parameters is cool.")
    @ParameterizedTest
    @CsvFileSource(resources = {"/testdata.csv"})
    void add_ShouldAddTwoNumbers2(int a, int b, int expectedAddResult){
        Calculator calculator = new Calculator();
        //when
        int actuualAddResult = calculator.add(a, b);
        //then
        assertEquals(expectedAddResult, actuualAddResult);
    }


}
