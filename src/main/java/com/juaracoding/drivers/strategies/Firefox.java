package com.juaracoding.drivers.strategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox implements DriverStrategy{

    @Override
    public WebDriver setStrategy() {
        System.setProperty("webdriver.firefox.driver", "/Users/macosx/Documents/chromedriver-mac-x64/chromedriver");
        return new FirefoxDriver();
    }

}
