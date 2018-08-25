package com.sda.tests.services;

import java.util.Collections;

public class BasketService {

    private ProductService productService;

    public BasketService(ProductService productService) {
        this.productService = productService;
    }

    Basket createEmptyBasket(User user){
        return new Basket(user, Collections.emptyList());
    }


}
