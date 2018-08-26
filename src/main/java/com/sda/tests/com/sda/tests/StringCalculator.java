package com.sda.tests.com.sda.tests;

import java.util.regex.Pattern;

public class StringCalculator {

    public int add(String string) {
        return Pattern.compile(",")
                .splitAsStream(string)
                .mapToInt(Integer::parseInt)
                .peek(i -> {
                    if (i < 0) {
                        throw new IllegalArgumentException("negatives not allowed");
                    }
                })
                .filter(x -> x < 1000)
                .sum();
    }

    public static void main(String[] args) {
        int add = new StringCalculator().add("1,10000");
        System.out.println(add);
    }

}
