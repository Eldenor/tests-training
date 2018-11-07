package com.sda.tests.calculator;

class Calculator {

    int safeAdd(int a, int b){
        return Math.addExact(a,b);
    }

    int add(int a, int b) {
        return a + b;
    }

    int subtract(int a, int b) {
        return a - b;
    }

    int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Can not divide by 0");
        }
        return a / b;
    }

    double sqrt(double number) {
        if (number < 0) {
            throw new ArithmeticException("Must be positve");
        }
        return Math.sqrt(number);
    }


    public static void main(String[] args) {
        double sqrt = new Calculator().sqrt(-1);
        System.out.println(sqrt);
    }
}
