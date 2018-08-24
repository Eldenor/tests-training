package com.sda.tests.strings;

public class StringMethods {


    public boolean isPalindrome(String string){
        return string.equals(new StringBuilder(string).reverse().toString());
    }

}
