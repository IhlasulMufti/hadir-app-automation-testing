package com.juaracoding;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {
        "/Users/macosx/Documents/hadir-app-automation-testing/src/main/resources/features/04Koreksi.feature",
        "/Users/macosx/Documents/hadir-app-automation-testing/src/main/resources/features/05IzinOff.feature"},
        glue = "com.juaracoding",
        plugin = {"pretty","html:target/cucumber-report.html","json:target/cucumber.json"})
public class TestRunner extends AbstractTestNGCucumberTests {
}
