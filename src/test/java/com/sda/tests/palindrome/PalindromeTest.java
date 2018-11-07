package com.sda.tests.palindrome;


import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PalindromeTest {


    static List<String> stringProvider() {
        File dataFile = new File("testdata.txt");

        ArrayList<String> result = new ArrayList<>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(dataFile);
            while (scanner.hasNextLine()) {
                result.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
        return result;
    }

    @Test
    void isPalindrome() {
        Palindrome palindrome = new Palindrome();
        try {
            palindrome.isPalindrome(null);
        }catch (PalindromeCanNotBeNullException e){
            assertEquals("Word can not be null", e.getMessage());
        }
    }
}
