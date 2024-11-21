package com.juaracoding.utils;

public enum ScenarioTests {

    T1("Download Template: Status Active, successfully completed"),
    T2("Import file according to the template"),
    T3("Imported file does not match template"),
    T4("Import without selecting a file"),
    T5("Import does not match the file format"),
    T6("Import file with empty data"),
    T7("Download Template: Struktur User, successfully completed"),
    T8("Import file according to the template Struktur User"),
    T9("Imported file does not match template Struktur User"),
    T10("Import without selecting a file Struktur User"),
    T11("Import does not match the file format Struktur User"),
    T12("Import file with empty data Struktur User");

    private String scenarioTestName;

    ScenarioTests(String value){
        scenarioTestName = value;
    }

    public String getScenarioTestName(){
        return scenarioTestName;
    }
}
