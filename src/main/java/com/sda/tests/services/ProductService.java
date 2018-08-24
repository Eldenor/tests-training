package com.sda.tests.services;

import org.javamoney.moneta.Money;

import java.math.BigDecimal;
import java.util.List;

public class ProductService {

    private ProductStore productStore;


    public boolean removeProduct(Long id){
        return false;
    }

    public boolean removeProduct(Product product){
        return false;
    }

    public boolean addProductToStore(Long id, Product product){
        return false;
    }

    public Money getSumPriceOfAllProducts(){
        return null;
    }

    public Money getPriceOfProducts(List<Product> products){
        return null;
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
