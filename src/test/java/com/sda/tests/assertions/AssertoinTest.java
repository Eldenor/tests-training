package com.sda.tests.assertions;

import com.sda.tests.services.Product;
import org.assertj.core.api.Condition;
import org.assertj.core.data.Percentage;
import org.javamoney.moneta.Money;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class AssertoinTest {

    @Test
    void numberAssertions() {

        int numberUnderTest = 199;

        Condition<Integer> oddNumberCondition = new Condition<>(number -> number % 2 == 1, "Liczba musi być nieparzysta");
        assertThat(numberUnderTest)
                .isBetween(180, 200)
                .is(oddNumberCondition)
                .isCloseTo(200, Percentage.withPercentage(3))
                .isGreaterThanOrEqualTo(199)
                .isNotIn(198, 200, 201)
                .isPositive()
                .isNotZero()
                .isInstanceOf(Integer.class);

    }

    @Test
    void objectAssertions() {

        List<Product> productList = Arrays.asList(
                new Product("Telewizor", Money.of(200, "USD")),
                new Product("Komputer", Money.of(1000, "USD"))
        );

        Product product = new Product("Telewizor", Money.of(200, "USD"));


        Condition<Product> nonFreeProductCondition =
                new Condition<>(prod -> prod.getPrice().equals(Money.of(0, "USD")), "Non free product");


        assertThat(product)
                .hasFieldOrProperty("name")
                .isNot(nonFreeProductCondition)
                .isEqualToIgnoringNullFields(new Product("Telewizor", null))
                .isIn(productList)
                .isNotNull()
                .isNotInstanceOfAny(Integer.class, Money.class);

    }


    @Test
    void stringAssertions() {
        String testedString = "This is just string to testing";

        assertThat(testedString)
                .contains("just")
                .startsWith("This ")
                .endsWith("ing")
                .doesNotContain("bad words")
                .hasLineCount(1)
                .hasSameSizeAs("Tekst o takim samym rozmiarze.")
                .isNotBlank();
    }

    @Test
    void collectionsAssertions() {
        List<Product> productList = Arrays.asList(
                new Product("Telewizor", Money.of(200, "USD")),
                new Product("Komputer", Money.of(1000, "USD")),
                new Product("Telefon", Money.of(100, "USD"))
        );


        assertThat(productList)
                .contains(new Product("Telewizor", Money.of(200, "USD")))
                .doesNotContain(new Product("Mikroskop", Money.of(100, "USD")))
                .doesNotHaveDuplicates()
                .hasSize(3)
                .isNotNull();
    }

    @Test
    void exeptionAssertions() {
        assertThatThrownBy(() -> Math.multiplyExact(9999999, 9999999))
                .hasMessage("integer overflow")
                .isInstanceOf(ArithmeticException.class);

    }

}
