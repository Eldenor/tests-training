package com.sda.tests.lambda;

public enum TestEnum implements Comparable<TestEnum>{

    ANNA("dasd");

    String name;

    TestEnum(String name) {
        this.name = name;
    }
}
