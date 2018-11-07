package com.sda.tests.uservalidation;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}
