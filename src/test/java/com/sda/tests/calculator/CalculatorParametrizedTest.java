package com.sda.tests.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorParametrizedTest {
    @DisplayName("Adding with parameters is cool.")
    @ParameterizedTest
    @CsvSource({
            "1,2,3",
            "7,10,17",
            "100,999,1099"
    })
    void addShouldAddTwoNumbers(int a, int b, int expectedAddResult){
        Calculator calculator = new Calculator();
        //when
        int actuualAddResult = calculator.add(a, b);
        //then
        assertEquals(expectedAddResult, actuualAddResult);
    }
}
