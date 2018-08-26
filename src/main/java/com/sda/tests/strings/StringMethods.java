package com.sda.tests.strings;

public class StringMethods {

    public static void main(String[] args) {
        "asdas".split(",");
    }

    public boolean isPalindrome(String string){
        return string.equals(new StringBuilder(string).reverse().toString());
    }

}
