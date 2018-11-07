package com.sda.tests.uservalidation;

public class UserValidator {

    public UserValidationResult validateUser(User user) {
        String usernameValidationResult = validateUsername(user);
        String passwordValidationResult = validatePassword(user);
        return new UserValidationResult(usernameValidationResult, passwordValidationResult);
    }

    private String validateUsername(User user) {
        String username = user.getUsername();
        if (username.length() <= 3) {
            return "User name too short";
        }
        if (!username.endsWith("a")) {
            return "User name have to end with a";
        }
        return "Ok";
    }

    private String validatePassword(User user) {
        String password = user.getPassword();
        if (!password.contains("!")) {
            return "Pass must contain !";
        }
        return "Ok";
    }

}
