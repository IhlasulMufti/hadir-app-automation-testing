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
    T12("Disable password masking");

    private String scenarioTestName;

    ScenarioTests(String value){
        scenarioTestName = value;
    }

    public String getScenarioTestName(){
        return scenarioTestName;
    }
}
