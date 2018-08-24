package com.sda.tests.services;

import java.util.HashMap;
import java.util.Map;

public class ProductStore {
    private Map<Long, Product> allProducts;

    public ProductStore() {
        this.allProducts = new HashMap<>();
    }

    // tutaj dodaj podstawo

    public boolean add(Long id, Product product){
        return false;
    }

    public boolean edit(Long id, Product product){
        return false;
    }

    public boolean remove(Long id, Product product){
        return false;
    }

}
