package com.juaracoding.pages.admin;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ImportAbsenPage {
    private WebDriver driver;

    public ImportAbsenPage(){
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//p[text()='Import']")
    private WebElement tabImportMenu;
    @FindBy(xpath = "//p[text()='Import Absen']")
    private WebElement importAbsenMenu;
    @FindBy(xpath = "//input[@id='selfie']")
    private WebElement chooseFile;
    @FindBy(xpath = "//button[@type='submit' and text()='Import']")
    private WebElement importBtn;
    @FindBy(xpath = "//button[@type='button' and text()='Download Template']")
    private WebElement downloadTemplateBtn;
    @FindBy(xpath = "//p[@id='selfie-helper-text']")
    private WebElement errorInvalidFormatFile;
    @FindBy(xpath = "//div[@class='MuiSnackbarContent-message css-1w0ym84']")
    private WebElement importFileMessage;

    public void clickTabImportMenu(){
        tabImportMenu.click();
    }
    public void clickImportAbsenMenu(){
        importAbsenMenu.click();
    }
    public void uploadFile(String path){
        chooseFile.sendKeys(path);
    }
    public void clickImportBtn(){
        importBtn.click();
    }
    public void clickDownloadTemplateBtn(){
        downloadTemplateBtn.click();
    }
    public String getErrInvalidFormatFile(){
        return errorInvalidFormatFile.getText();
    }
    public String getImportFileMessage(){
        return importFileMessage.getText();
    }
}
