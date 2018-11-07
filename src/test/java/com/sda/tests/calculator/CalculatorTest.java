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

    @Ignore
    @DisplayName("powinn się ładnie odjąć")
    @Test
    void subtractShouldSubtrac() {
        //given
        int a = 10;
        int b = 5;
        //when
        int actualResult = calculator.subtract(a, b);
        //then
        assertEquals(5, actualResult);
    }

    @Test
    public void shouldAddTwoNumbers() {
        int result = calculator.add(99, 100);
        Assertions.assertThat(result)
                .as("Powinno wyjść 199")
                .isLessThan(200)
                .isCloseTo(200, Percentage.withPercentage(10))
                .isBetween(130, 230);
    }

    @Test
    void divideShouldNotDevideByZero() {
        try {
            int divide = calculator.divide(2, 3);
        } catch (ArithmeticException e) {
            assertEquals(e.getMessage(), "Can not divide by 0");
        }
    }

    @Test
    void divideShouldNotDevideByZero2() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.divide(4, 0);
        });
    }

    @Test
    void safeAddShouldThrowExeption() {
        assertThrows(ArithmeticException.class, () -> {
            Calculator calculator = new Calculator();
            calculator.safeAdd(999955999, 855558888);
        });
    }
}
