package com.juaracoding.pages.user;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserKoreksiAbsenPage {

    private WebDriver driver;

    public UserKoreksiAbsenPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//div[@class= 'MuiBox-root css-11uwjng'])[2]")
    private WebElement btnKoreksiAbsen;
    @FindBy(xpath = "//p[contains(text(), 'Halaman')]")
    private WebElement txtHalaman;
    @FindBy(xpath = "//p[contains(text(), 'List Koreksi')]")
    private WebElement txtListKoreksi;
    @FindBy(xpath = "//p[contains(text(), 'testerjuara')]")
    private WebElement txtNameUser;
    @FindBy(xpath = "//button[contains(@class, 'MuiButton-fullWidth css-otounb')]")
    private WebElement btnAjukanKoreksi;
    @FindBy(xpath = "(//button[contains(@class, ' MuiIconButton-edgeEnd MuiIconButton-sizeMedium css-md0l3g')])[1]")
    private WebElement btnJamMasuk;
    @FindBy(xpath = "(//button[contains(@class, ' MuiIconButton-edgeEnd MuiIconButton-sizeMedium css-md0l3g')])[2]")
    private WebElement btnJamKeluar;
    @FindBy(xpath = "//button[@class= 'MuiButtonBase-root MuiPickersDay-root MuiPickersDay-dayWithMargin MuiPickersDay-today css-17l5z2h']")
    private WebElement btnTanggalMasuk;
    @FindBy(xpath = "//button[@class= 'MuiButtonBase-root MuiPickersDay-root MuiPickersDay-dayWithMargin css-1r5gsy8']")
    private WebElement btnTanggalKeluar;
    @FindBy(xpath = "//div[@class= 'MuiClock-squareMask css-1umqo6f']")
    private WebElement btnTimer;
    @FindBy(xpath = "//div[contains(@class, 'MuiInputBase-inputSizeSmall css-1wuqy62')]")
    private WebElement inputTypeAbsen;
    @FindBy(xpath = "(//li[contains(@class, 'MuiMenuItem-gutters css-1fh5cnl')])[1]")
    private WebElement typeWFH;
    @FindBy(xpath = "//p[@class= 'MuiTypography-root MuiTypography-body1 css-1bwr8un']")
    private WebElement txtWarning;
    @FindBy(xpath = "//button[contains(@class, 'MuiButton-sizeMedium MuiButton-textSizeMedium css-f5765a')]")
    private WebElement btnBack;


    public void setBtnKoreksiAbsen(){
        btnKoreksiAbsen.click();
    }
    public String getTxtHalaman(){
        return txtHalaman.getText();
    }

    public String getTxtListKoreksi(){
        return txtListKoreksi.getText();
    }

    public String getTxtNameUser(){
        return txtNameUser.getText();
    }

    public void setBtnAjukanKoreksi(){
        btnAjukanKoreksi.click();
    }

    public void setBtnJamMasuk(){
        btnJamMasuk.click();
    }

    public void setBtnJamKeluar(){
        btnJamKeluar.click();
    }

    public void setBtnTanggalMasuk(){
        btnTanggalMasuk.click();
    }

    public void setBtnTanggalKeluar(){
        btnTanggalKeluar.click();
    }

    public void setBtnTimer(){
        btnTimer.click();
    }

    public void setInputTypeAbsen(){
        inputTypeAbsen.click();
    }

    public void setTypeWFH(){
        typeWFH.click();
    }

    public String getTxtWarning(){
        return txtWarning.getText();
    }

    public void setBtnBack(){
        btnBack.click();
    }
}
