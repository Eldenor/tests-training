package com.sda.tests.calculator;


import com.sda.tests.calculator.Calculator;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.assertj.core.api.Assertions;
import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CalculatorTest {

    private Calculator calculator;

    @BeforeAll
    void beforaAll() {
        System.out.println("Przed wszystkimi testami");
    }

    @AfterAll
    void afterAll() {
        System.out.println("Po wszystkich testami");
    }

    @BeforeEach
    public void setUp() {
        System.out.println("Jednym jednumm testem");
        calculator = new Calculator();
    }

    @Test
    public void addShouldAddTwoNumbers() {
        //GIVEN
        int a = 2;
        int b = 3;

        //when
        int addResult = calculator.add(a, b);

        //then
        assertEquals(5, addResult);
    }
}
