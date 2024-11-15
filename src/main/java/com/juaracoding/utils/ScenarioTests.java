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
    //dashboard
    T13("Successfully go to the dashboard page"),
    //laporanSemua
    T14("Success view all report data by entering name, department, date"),
    T15("View all report data by not enter name, department, date"),
    T16("View report data by using Input unregistered name"),
    T17("View all report data by entering the start date and end date"),
    T18("Display all report data by entering a start date without an end date"),
    T19("Display all report data by entering end date without start date"),
    T20("Displays report data all with department and date input"),
    T21("Entering dates is not formatted"),
    T22("Reset all inputs using the Reset button");

    private String scenarioTestName;

    ScenarioTests(String value){
        scenarioTestName = value;
    }

    public String getScenarioTestName(){
        return scenarioTestName;
    }
}
