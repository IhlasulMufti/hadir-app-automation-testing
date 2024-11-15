package com.juaracoding.pages.admin;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    private  WebDriver driver;

    public DashboardPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//p[@class= 'MuiTypography-root MuiTypography-body1 css-aqx7sf'])[1]")
    private WebElement dashboardMenuList;
    @FindBy(xpath = "//p[@class= 'MuiTypography-root MuiTypography-body1 css-1kei35f']")
    private WebElement txtDashboardPage;
    @FindBy(xpath = "(//h3[@class= 'MuiTypography-root MuiTypography-h3 css-1mdl9uy'])[1]")
    private WebElement txtTotalSemuaKaryawan;
    @FindBy(xpath = "(//h3[@class= 'MuiTypography-root MuiTypography-h3 css-1mdl9uy'])[2]")
    private WebElement txtTotalAbsenHariIni;
    @FindBy(xpath = "(//h3[@class= 'MuiTypography-root MuiTypography-h3 css-1mdl9uy'])[3]")
    private WebElement txtKaryawanWFH;
    @FindBy(xpath = "(//h3[@class= 'MuiTypography-root MuiTypography-h3 css-1mdl9uy'])[4]")
    private WebElement txtKaryawanCuti;
    @FindBy(xpath = "(//h3[@class= 'MuiTypography-root MuiTypography-h3 css-1mdl9uy'])[5]")
    private WebElement txtKaryawansakit;
    @FindBy(xpath = "(//h3[@class= 'MuiTypography-root MuiTypography-h3 css-1mdl9uy'])[6]")
    private WebElement txtKaryawanIzin;

    public void setDashboardMenuList(){
        dashboardMenuList.click();
    }

    public String getTxtDashboardPage(){
        return txtDashboardPage.getText();
    }

    public String getTxtTotalSemuaKaryawan(){
        return txtTotalSemuaKaryawan.getText();
    }

    public String getTxtTotalAbsenHariIni(){
        return txtTotalAbsenHariIni.getText();
    }

    public String getTxtKaryawanWFH(){
        return txtKaryawanWFH.getText();
    }

    public String getTxtKaryawanCuti(){
        return txtKaryawanCuti.getText();
    }

    public String getTxtKaryawanSakit(){
        return txtKaryawansakit.getText();
    }

    public String getTxtKaryawanIzin(){
        return txtKaryawanIzin.getText();
    }
}