package com.sda.tests.services;

import java.util.Collections;
import java.util.List;

public class BasketService {

    private Basket basket;

    private ProductService productService;

    public BasketService(ProductService productService) {
        this.productService = productService;
    }

    Basket createEmptyBasket(User user){
        return new Basket(user, Collections.emptyList());
    }

    void addProductToBasket(long productId) {
        List<Product> productsForIds = productService.getProductsForIds(productId);
        basket.addProductToBasket(productsForIds);
    }

}
