package com.juaracoding.drivers.strategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class Firefox implements DriverStrategy{

    @Override
    public WebDriver setStrategy() {
//        FirefoxProfile profile = new FirefoxProfile();
//
//        profile.setPreference("permissions.default.microphone", 1); // Allow microphone
//        profile.setPreference("permissions.default.camera", 1);    // Allow camera
//        profile.setPreference("permissions.default.geo", 1); // Allow geolocation by default
//        profile.setPreference("geo.enabled", true);         // Enable geolocation features
//
//        FirefoxOptions options = new FirefoxOptions();
//        options.setProfile(profile);

        System.setProperty("webdriver.gecko.driver", "C:\\MyTools\\geckodriver.exe");

        return new FirefoxDriver();
    }

}
