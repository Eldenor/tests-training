package com.sda.tests.uservalidation;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserValidatorTest {

    UserValidator userValidator;

    @BeforeEach
    public void setUp() {
        System.out.println("Start test");
        userValidator = new UserValidator();
    }

    @AfterEach
    public void tearDown() {
        System.out.printf("Jeeee!");
    }

    @Test
    public void validateUser() {
        //given
        User karolina = new User("karolina", "!karolina");

        //when
        UserValidationResult userValidationResult = userValidator.validateUser(karolina);

        //then
        UserValidationResult expectedValidationResult = new UserValidationResult("Ok", "Ok");
        assertEquals(expectedValidationResult, userValidationResult);

    }


    //TODO 1. Napisz metodę testową, która przyjmuje jako parametry obiekty typi User i UserValidator
    //TODO 2. Wywołaj testowaną funkcję validateUser z klasy UserValidator
    //TODO 3. Porównaj za pomocą assercji dane zwrócone przez UserValidator z obiektem UserValidator, który przekazujesz do testu jako parametr metody.


    @ParameterizedTest
    @MethodSource("stringIntAndListProvider")
    public void validateUserParametrized(User user, UserValidationResult expectedResult) {
        UserValidationResult actualResult = userValidator.validateUser(user);

        assertEquals(expectedResult, actualResult);

    }

    static Stream<Arguments> stringIntAndListProvider() {
        return Stream.of(
                Arguments.of(new User("karolina", "!karolina"), new UserValidationResult("Ok", "Ok"))
                //TODO 4. tutaj dopisz pozotałe przypadki testowe
        );
    }
}
