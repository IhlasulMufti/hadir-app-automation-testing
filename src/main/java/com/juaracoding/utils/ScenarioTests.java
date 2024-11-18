package com.juaracoding.utils;

public enum ScenarioTests {

/*    T1("Login with email and password valid"),
    T2("Account log out verification"),
    T3("Login with email and password invalid"),
    T4("Login with email and password invalid"),
    T5("Login with email and password invalid"),
    T6("Login with email and password invalid"),
    T7("Login with email and password invalid"),
    T8("Login with email and password invalid"),
    T9("Login with invalid format email"),
    T10("Login with invalid format email"),
    T11("Login with invalid format email"),
    T12("Password masking verification when entering password"),
    T13("Disable password masking"),
    T14("Login with email and password valid"),
    T15("Account log out verification"),
    T16("Login with email and password invalid"),
    T17("Login with email and password invalid"),
    T18("Login with email and password invalid"),
    T19("Login with email and password invalid"),
    T20("Login with email and password invalid"),
    T21("Login with email and password invalid"),
    T22("Login with invalid format email"),
    T23("Login with invalid format email"),
    T24("Login with invalid format email"),
    T25("Password masking verification when entering password"),
    T26("Disable password masking"),*/
    T27("Successful clocking in (selfie)"),
    T28("Successful clocking in (selfie)"),
    T29("Successful clocking in (non-selfie)"),
    T30("Successful clocking in (non-selfie)"),
    T31("Unable to clock in when already clocked in on the same day"),
    T32("Successful clocking out"),
    T33("Successful clocking out");

    private String scenarioTestName;

    ScenarioTests(String value){
        scenarioTestName = value;
    }

    public String getScenarioTestName(){
        return scenarioTestName;
    }
}
