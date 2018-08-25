package com.sda.tests.strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringMethodsTest {

    private StringMethods stringMethods;

    @ParameterizedTest
    @ValueSource(strings = { "racecar", "radadr", "able was I ere I saw elba" })
    void isPalindromeCheck(String candidate) {
        StringMethods stringMethods = new StringMethods();
        boolean palindrome = stringMethods.isPalindrome(candidate);
        assertTrue(palindrome);
    }

    @ParameterizedTest
    @MethodSource({"testWithSimpleMethodSourceHavingNoValue"})
    public void isPalindromeCheck2(String candidate){
        StringMethods stringMethods = new StringMethods();
        assertTrue(stringMethods.isPalindrome(candidate));
    }

    static Stream<String> testWithSimpleMethodSourceHavingNoValue() {
        return Stream.of("foof", "barrab");
    }
}
