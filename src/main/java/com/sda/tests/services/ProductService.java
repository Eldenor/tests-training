package com.sda.tests.services;

import org.javamoney.moneta.Money;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ProductService {

    private ProductStore productStore;

    public ProductService(ProductStore productStore) {
        this.productStore = productStore;
    }

    public boolean addProductToStore(Long id, Product product) {
        return productStore.add(id, product);
    }

    public boolean removeProduct(Long id) {
        return productStore.remove(id);
    }

    public boolean removeProduct(Product product) {
        return false;
    }

    public Money getSumPriceOfAllProducts() {
        return null;
    }


    public Money getPriceOfProducts(List<Product> products) {
        return null;
    }

    public List<Product> getProductWithIds(long... ids){
        return null;
    }

    public List<Product> getProductsForIds(long... ids){
        return Collections.emptyList();
    }


// zaimplementuj cenę jako BigDecimal, jeżeli nie chcesz poznawać biblioteki Money
//    public BigDecimal getSumPriceOfAllProducts(){
//        return null;
//    }
//
//    public BigDecimal getPriceOfProducts(List<Product> products){
//        return null;
//    }
}
