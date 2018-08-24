package com.sda.tests.calculator;

public class Calculator {
    int add(int a, int b) {
        return a + b;
    }

    int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Can not divide by 0");
        }
        return a / b;
    }
}
