package com.sda.tests.services;

public class User {
    private String name;
    private String passoword;

    public User(String name, String passoword) {
        this.name = name;
        this.passoword = passoword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassoword() {
        return passoword;
    }

    public void setPassoword(String passoword) {
        this.passoword = passoword;
    }
}
