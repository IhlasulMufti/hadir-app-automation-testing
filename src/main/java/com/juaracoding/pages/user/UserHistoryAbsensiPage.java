package com.juaracoding.pages.user;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserHistoryAbsensiPage {

    private WebDriver driver;

    public UserHistoryAbsensiPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//div[@class= 'MuiBox-root css-11uwjng'])[1]")
    private WebElement btnAbsensi;
    @FindBy(xpath = "//p[@class= 'MuiTypography-root MuiTypography-body1 css-sfy9e9']")
    private WebElement txtName;
    @FindBy(xpath = "//p[@class= 'MuiTypography-root MuiTypography-body1 css-1m443p8']")
    private WebElement txtTidakAdaLagiData;
    @FindBy(xpath = "//p[@class= 'MuiTypography-root MuiTypography-body1 css-ichibz']")
    private WebElement txtHistoryAbsensi;
    @FindBy(xpath = "//button[contains(@class, 'MuiIconButton-sizeMedium css-1enmvey')]")
    private WebElement btnBackDashboard;
    @FindBy(xpath = "//p[contains(text(), 'testerjuara')]")
    private WebElement txtNameUser;
    @FindBy(xpath = "//div[@class='MuiBox-root css-759u60']//*[name()='svg']")
    private WebElement btnSelengkapnya;

    public void setBtnAbsensi(){
        btnAbsensi.click();
    }

    public String getTxtName(){
        return txtName.getText();
    }

    public String getTxtTidakAdaLagiData(){
        return txtTidakAdaLagiData.getText();
    }

    public String getTxtHistoryAbsensi(){
        return txtHistoryAbsensi.getText();
    }

    public void setBtnBackDashboard(){
        btnBackDashboard.click();
    }

    public String getTxtNameUser(){
        return txtNameUser.getText();
    }

    public void setBtnSelengkapnya(){
        btnSelengkapnya.click();
    }
}
