package com.juaracoding.pages.admin;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ImportStrukturUserPage {

    private WebDriver driver;

    public ImportStrukturUserPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//p[normalize-space()='Import']")
    private WebElement dropdownMenuImport;

    @FindBy(xpath = "//p[normalize-space()='Import Struktur User']")
    private WebElement btnSubMenuImportStrukturUser;

    @FindBy(xpath = "//button[contains(@class, 'css-5lyhfd')]")
    private WebElement btnImportStrukturUser;

    @FindBy(xpath = "//button[contains(@class, 'css-yebgwc')]")
    private WebElement btnDownloadTemplateStrukturUser;

    @FindBy(xpath = "//div[contains(@class, 'css-c352pn')]")
    private WebElement txtValidasi;

    @FindBy(xpath = "//input[@id='selfie']")
    private WebElement chooseFile;

    public void setBtnMenuImportStrukturUser(){
        dropdownMenuImport.click();
    }

    public void setBtnSubMenuImportStrukturUser() {
        btnSubMenuImportStrukturUser.click();
    }

    public void setBtnDownloadTemplateStrukturUser(){
        btnDownloadTemplateStrukturUser.click();
    }

    public String getTxtValidasi(){
        return txtValidasi.getText();
    }

    public void setBtnImportStrukturUser(){
        btnImportStrukturUser.click();
    }

    public void addFileValid(String file) {
        chooseFile.sendKeys("C:\\Juara Coding\\sqa batch 18\\hadir-app\\hadir-app-automation-testing\\src\\main\\resources\\uploadFile\\DATA_STRUKTUR_USER.xlsx");
    }

    public void addFileInvalid(String file){
        chooseFile.sendKeys("C:\\Juara Coding\\sqa batch 18\\hadir-app\\hadir-app-automation-testing\\src\\main\\resources\\uploadFile\\DATA_STRUKTUR_USER_INVALID.xlsx");
    }

    public void addFileEmptyData(String file){
        chooseFile.sendKeys("C:\\Juara Coding\\sqa batch 18\\hadir-app\\hadir-app-automation-testing\\src\\main\\resources\\uploadFile\\DATA_STRUKTUR_USER_EMPTY_DATA.xlsx");
    }

    public void addFileFormatInvalid(String file){
        chooseFile.sendKeys("C:\\Juara Coding\\sqa batch 18\\hadir-app\\hadir-app-automation-testing\\src\\main\\resources\\uploadFile\\DATA_STRUKTUR_USER.pdf");
    }

}
