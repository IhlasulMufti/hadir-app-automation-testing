package com.juaracoding.utils;

public enum ScenarioTests {

    T1("Login with email and password valid");

    private String scenarioTestName;

    ScenarioTests(String value){
        scenarioTestName = value;
    }

    public String getScenarioTestName(){
        return scenarioTestName;
    }
}
