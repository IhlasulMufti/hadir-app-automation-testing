package com.juaracoding.drivers.strategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;

public class Chrome implements DriverStrategy {

    @Override
    public WebDriver setStrategy() {
        HashMap<String, Integer> contentSettings = new HashMap<String, Integer>();
        HashMap<String, Object> profile = new HashMap<String, Object>();
        HashMap<String, Object> prefs = new HashMap<String, Object>();

        contentSettings.put("media_stream", 1);
        contentSettings.put("geolocation", 1);
        profile.put("managed_default_content_settings", contentSettings);
        prefs.put("profile", profile);

        System.setProperty("webdriver.chrome.driver", "C:\\MyTools\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--no-sandbox");
        options.addArguments("--use-fake-device-for-media-stream");
        options.addArguments("--headless");  // Setting headless mode
        options.addArguments("--disable-gpu");  // GPU hardware acceleration isn't useful in headless mode
        options.addArguments("--window-size=1366,768");  // Set the window size

        return new ChromeDriver(options);
    }

}
