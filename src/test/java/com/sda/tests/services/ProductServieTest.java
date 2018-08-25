package com.sda.tests.services;

import org.javamoney.moneta.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductServieTest {

    private ProductService productService;

    @BeforeEach
    void setUpService() {
        ProductStore productStore = new ProductStore();
        productService = new ProductService(productStore);
    }

    @DisplayName("Dodawnie produktu zakończone sukcesem")
    @Test
    void addProductToStoreShouldAddFirstProduct() {
        //given
        long id = 1;
        Product product = new Product("Komputer", Money.of(1000, "USD"));
        //when
        boolean actualResult = productService.addProductToStore(id, product);
        //then
        assertTrue(actualResult);
    }

    @DisplayName("Nie można dodać produktu z takim samym ID")
    @Test
    void addProductToStoreShoulNotAddProductWithDuplicatedKey() {
        //given
        long id = 1;
        Product product = new Product("Komputer", Money.of(1000, "USD"));
        Product product2 = new Product("Telewizor", Money.of(200, "USD"));
        //when
        boolean actualFirstAddResult = productService.addProductToStore(id, product);
        boolean actualSecondAddResult = productService.addProductToStore(id, product2);
        //then
        assertTrue(actualFirstAddResult);
        assertFalse(actualSecondAddResult);
    }

    @Test
    void removeProductShouldRemoveProduct() {
        //given
        long id = 1;
        Product product = new Product("Komputer", Money.of(1000, "USD"));
        //when
        boolean actualAdditionResult = productService.addProductToStore(id, product);
        boolean actualRemoveResult = productService.removeProduct(id);

        //then
        assertTrue(actualAdditionResult);
        assertTrue(actualRemoveResult);
    }

    @Test
    void getSumPriceOfAllProductsShouldReturnZero() {
        //when
        Money actualSumPrice = productService.getSumPriceOfAllProducts();
        //then
        assertEquals(Money.of(0, "USD"), actualSumPrice);
    }

    @Test
    void getSumPriceOfAllProductsShouldReturnPriceOfOne() {
        //given
        Money price = Money.of(1000, "USD");
        Product product1 = new Product("Komputer", price);
        productService.addProductToStore(1L, product1);

        //when
        Money actualSumPrice = productService.getSumPriceOfAllProducts();

        //then
        Money expectedPrice = Money.of(1000, "USD");
        assertEquals(expectedPrice, actualSumPrice);
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void getSumPriceOfAllProductsShouldReturnPriceOfSome(List<Product> productsToPutToService, Money expectedPrice) {
        long id = 0;
        for (Product product : productsToPutToService) {
            productService.addProductToStore(id++, product);
        }

        //when
        Money sumPriceOfAllProducts = productService.getSumPriceOfAllProducts();
        //then
        assertEquals(expectedPrice, sumPriceOfAllProducts);
    }

    static List<Arguments> arguments() {
        //pierwszy argument
        List<Product> products1 = Arrays.asList(
                new Product("a", Money.of(0, "USD")),
                new Product("a", Money.of(0, "USD")),
                new Product("a", Money.of(0, "USD"))
        );
        Money expectedPrice1 = Money.of(0, "USD");

        //drugi argument
        List<Product> products2 = Arrays.asList(
                new Product("a", Money.of(100, "USD"))
        );
        Money expectedPrice2 = Money.of(100, "USD");

        //trzeci argument
        List<Product> products3 = new ArrayList<>();
        products3.add(new Product("", Money.of(0, "USD")));
        products3.add(new Product("", Money.of(0, "USD")));
        products3.add(new Product("", Money.of(1000, "USD")));
        Money expectedPrice3 = Money.of(1000, "USD");


        List<Arguments> arguments = Arrays.asList(
                Arguments.of(products1, expectedPrice1),
                Arguments.of(products2, expectedPrice2),
                Arguments.of(products3, expectedPrice3)
        );

        return arguments;
    }


}
