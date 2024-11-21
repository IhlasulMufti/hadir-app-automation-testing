package com.juaracoding.pages.admin;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagementUserPage{

    private WebDriver driver;

    public ManagementUserPage() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//p[@class='MuiTypography-root MuiTypography-body1 css-1ub5lza'])[3]")
    private WebElement managementMenuBar;
    @FindBy(xpath = "(//p[@class= 'MuiTypography-root MuiTypography-body1 css-aqx7sf'])[3]")
    private WebElement userManagementList;
    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-1kei35f']")
    private WebElement txtUser;
    @FindBy(xpath = "//input[@id='search']")
    private WebElement inputSearch;
    @FindBy(xpath = "//button[@type= 'submit']")
    private WebElement btnSearch;
    @FindBy(xpath = "//h5[text()='testerjuara']")
    private WebElement txtNamaKaryawan;

    public void setManagementMenuBar(){
        managementMenuBar.click();
    }

    public void setUserManagementList(){
        userManagementList.click();
    }

    public String getTxtUser(){
        return txtUser.getText();
    }

    public void setInputSearch(String name) {
        this.inputSearch.sendKeys(name);
    }

    public void setBtnSearch(){
        btnSearch.click();
    }

    public String getTxtNamaKaryawan(){
        return txtNamaKaryawan.getText();
    }
}
