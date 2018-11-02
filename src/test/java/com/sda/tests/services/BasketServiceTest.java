package com.sda.tests.services;

import org.javamoney.moneta.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class BasketServiceTest {

    private BasketService basketService;

    private ProductService productServiceMock;


    @BeforeEach
    void setUp(){
        productServiceMock = mock(ProductService.class);
        basketService = new BasketService(productServiceMock);
    }

    @Test
    void addProductToBasket() {

    }
}