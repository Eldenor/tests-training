package com.sda.tests.com.sda.tests;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void setup(){
        stringCalculator = new StringCalculator();
    }

    @Test
    void add_shouldThrowExeption() {
        StringCalculator stringCalculator = new StringCalculator();
        //given
        String wrong = "-1,2,3";
        try {
            stringCalculator.add(wrong);
        } catch (Exception e) {
            assertNotNull(e);
            assertThat(e.getMessage())
                    .contains("not allowed");
        }
    }

    @Test
    void add_shouldThrowExeption2() {
        StringCalculator stringCalculator = new StringCalculator();
        //given
        String wrong = "-1,2,3";
        stringCalculator.add(wrong);

        ThrowableAssert.ThrowingCallable throwingCallable = () -> stringCalculator.add(wrong);

        ThrowableAssert.ThrowingCallable throwingCallable2 = new ThrowableAssert.ThrowingCallable() {
            @Override
            public void call() throws Throwable {
                stringCalculator.add(wrong);
            }
        };

        assertThatThrownBy(throwingCallable2)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("negatives not allowed");

    }

    @ParameterizedTest
    @ValueSource(strings = {"2,2", "5,2,3", "10,2,3,5", "2,2,1001", "0,1001"})
    void shouldAdd(String string){
        //expected value, to piersza wartosc
        String s = string.split(",")[0];
        int expectedValue = Integer.parseInt(s);

        String testedString = withoutFirst(string);

        int actualAddResult = stringCalculator.add(testedString);

        assertEquals(expectedValue, actualAddResult);
    }

    private String withoutFirst(String string){
        String[] split = string.split(",");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 1; i++) {
            stringBuilder.append(split[i]);
        }
        return stringBuilder.toString();
    }

    private int safaParse(String string){

        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("strings not allowed");
        }
    }

}