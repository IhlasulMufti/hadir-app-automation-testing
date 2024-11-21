package com.juaracoding.utils;

public enum ScenarioTests {

    T1("Download Tamplate import cuti, successfully completed"),
    T2("Import file according to the template"),
    T3("Failing to import leave data due to incorrect file format"),
    T4("Failing to import leave data due to incorrect file template"),
    T5("Attempting to import leave data without selecting a file"),
    T6("Attempting to import leave data from an empty file");

    private String scenarioTestName;

    ScenarioTests(String value){
        scenarioTestName = value;
    }

    public String getScenarioTestName(){
        return scenarioTestName;
    }
}
