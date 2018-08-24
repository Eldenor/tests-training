package com.sda.tests.calculator;


import com.sda.tests.calculator.Calculator;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.rules.ExpectedException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CalculatorTest {

    private Calculator calculator;

    @BeforeAll
    public void setUp(){
        calculator = new Calculator();
    }

    @Test
    public void addShouldAddTwoNumbers(){
        //GIVEN
        int a = 2;
        int b = 3;

        //when
        int addResult = calculator.add(a, b);

        //then
        assertEquals(5, addResult);
    }

    @Test
    void divideShouldNotDevideByZero(){
        try {
            int divide = calculator.divide(2, 3);
        } catch (ArithmeticException e) {
            assertEquals(e.getMessage(), "Can not divide by 0");
        }
    }

    @Test
    void divideShouldNotDevideByZero2(){
        assertThrows(ArithmeticException.class, ()->{
            calculator.divide(4, 0);
        });
    }
}
