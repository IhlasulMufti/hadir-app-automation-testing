package com.juaracoding.pages.user;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLoginPage {

    private WebDriver driver;

    public UserLoginPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//p[normalize-space()='Menu']")
    private WebElement txtMenu;

    @FindBy(xpath = "//button[contains(@class, 'css-f5765a')]")
    private WebElement sidebarMenu;

    @FindBy(xpath = "//button[contains(@class, 'css-5lyhfd')]")
    private WebElement btnLogout;


    public String getTxtMenu() {
        return txtMenu.getText();
    }

    public void setSidebarMenu() {
        sidebarMenu.click();
    }

    public void setBtnLogout() {
        btnLogout.click();
    }

}
