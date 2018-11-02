package com.sda.tests.services;

import java.util.HashMap;
import java.util.Map;

public class ProductStore {
    private Map<Long, Product> allProducts;

    public ProductStore() {
        this.allProducts = new HashMap<>();
    }

    public Map<Long, Product> getAllProducts() {
        return allProducts;
    }

    public boolean add(Long id, Product product){
        if(allProducts.containsKey(id)){
            return false;
        }
        allProducts.put(id, product);
        return true;
    }

    public boolean edit(Long id, Product product){
        return false;
    }

    public boolean remove(Long id){
        if(!allProducts.containsKey(id)){
            return false;
        }
        allProducts.remove(id);
        return true;
    }

}
