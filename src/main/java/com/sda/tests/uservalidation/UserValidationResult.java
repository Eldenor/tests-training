package com.sda.tests.uservalidation;

import java.util.Objects;

public class UserValidationResult {
    private String usernameValidationResult;
    private String passwordValidationResult;

    public UserValidationResult(String usernameValidationResult, String passwordValidationResult) {
        this.usernameValidationResult = usernameValidationResult;
        this.passwordValidationResult = passwordValidationResult;
    }

    public String getUsernameValidationResult() {
        return usernameValidationResult;
    }

    public String getPasswordValidationResult() {
        return passwordValidationResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserValidationResult that = (UserValidationResult) o;
        return Objects.equals(usernameValidationResult, that.usernameValidationResult) &&
                Objects.equals(passwordValidationResult, that.passwordValidationResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usernameValidationResult, passwordValidationResult);
    }
}

