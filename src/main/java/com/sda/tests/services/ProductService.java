package com.sda.tests.services;

import org.javamoney.moneta.Money;

import java.math.BigDecimal;
import java.util.Collection;
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
        Map<Long, Product> allProducts = productStore.getAllProducts();

        Collection<Product> allProductsCollection = allProducts.values();

        Money sumPrice = Money.of(0, "USD");

        for (Product product : allProductsCollection) {
            Money priceOfProduct = product.getPrice();
            sumPrice = sumPrice.add(priceOfProduct);
        }
        return sumPrice;
    }

    public Money getSumPriceOfAllProducts2() {
        return productStore.getAllProducts().values()
                .stream()
                .map(Product::getPrice)
                .reduce(Money::add)
                .orElse(Money.of(0, "USD"));
    }

    public Money getPriceOfProducts(List<Product> products) {
        return null;
    }

    public List<Product> getProductWithIds(long... ids){
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
