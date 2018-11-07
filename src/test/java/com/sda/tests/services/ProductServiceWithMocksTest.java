package com.sda.tests.services;

import org.javamoney.moneta.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class ProductServiceWithMocksTest {

    private ProductService productService;

    ProductStore mockProductStore;

    @BeforeEach
    void setUp(){
        mockProductStore = Mockito.mock(ProductStore.class);
        productService = new ProductService(mockProductStore);
    }

    @Test
    void test(){

        Product product = new Product("Chleb", Money.of(1, "USD"));

        //doReturn(product).when(mockProductStore.add(1L, product));

        when(mockProductStore.add(1L, product)).thenReturn(true);

        productService.addProductToStore(1L, product);

        verify(mockProductStore).add(anyLong(), any());
    }

}
