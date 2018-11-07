package com.sda.tests.palindrome;

public class Palindrome {

    boolean isPalindrome(String word) {
        if (word == null) {
            throw new PalindromeCanNotBeNullException("Word can not be null");
        }

        return new StringBuilder(word)
                .reverse()
                .toString()
                .equals(word);
    }

    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        try {
            palindrome.isPalindrome(null);
        } catch (PalindromeCanNotBeNullException e){
            System.out.print("WyjĄtek!");
            System.out.printf(e.getMessage());
        }
    }



}
