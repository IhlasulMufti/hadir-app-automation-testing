package com.juaracoding.utils;

public enum ScenarioTests {

    T1("Login with email and password valid"),
    T2("Account log out verification"),
    T3("Login with email and password invalid"),
    T4("Login with email and password invalid"),
    T5("Login with email and password invalid"),
    T6("Login with email and password invalid"),
    T7("Login with email and password invalid"),
    T8("Login with email and password invalid"),
    T9("Login with invalid format email"),
    T10("Login with invalid format email"),
    T11("Password masking verification when entering password"),
    T12("Disable password masking"),
    T13("Login with email and password valid"),
    T14("Account log out verification"),
    T15("Login with email and password invalid"),
    T16("Login with email and password invalid"),
    T17("Login with email and password invalid"),
    T18("Login with email and password invalid"),
    T19("Login with email and password invalid"),
    T20("Login with email and password invalid"),
    T21("Login with invalid format email"),
    T22("Login with invalid format email"),
    T23("Password masking verification when entering password"),
    T24("Disable password masking");

    private String scenarioTestName;

    ScenarioTests(String value){
        scenarioTestName = value;
    }

    public String getScenarioTestName(){
        return scenarioTestName;
    }
}
