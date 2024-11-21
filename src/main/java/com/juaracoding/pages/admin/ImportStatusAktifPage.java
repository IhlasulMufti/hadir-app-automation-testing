package com.juaracoding.pages.admin;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.utils.Utils;
import jdk.jshell.execution.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ImportStatusAktifPage {

    private WebDriver driver;

    public ImportStatusAktifPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//p[normalize-space()='Import']")
    private WebElement dropdownMenuImport;

    @FindBy(xpath = "//p[normalize-space()='Import Status Aktif']")
    private WebElement btnSubMenuImportStatusAktif;

    @FindBy(xpath = "//button[contains(@class, 'css-5lyhfd')]")
    private WebElement btnImportStatusAktif;

    @FindBy(xpath = "//button[contains(@class, 'css-yebgwc')]")
    private WebElement btnDownloadTemplateStatusAktif;

    @FindBy(xpath = "//div[contains(@class, 'css-c352pn')]")
    private WebElement txtValidasi;

    @FindBy(xpath = "//input[@id='selfie']")
    private WebElement chooseFile;

    public void setBtnMenuImportStatusAktif(){
        dropdownMenuImport.click();
    }

    public void setBtnSubMenuImportStatusAktif() {
        btnSubMenuImportStatusAktif.click();
    }

    public void setBtnDownloadTemplateStatusAktif(){
        btnDownloadTemplateStatusAktif.click();
    }

    public String getTxtValidasi(){
        return txtValidasi.getText();
    }

    public void setBtnImportStatusAktif(){
        btnImportStatusAktif.click();
    }

    public void addFileValid(String file) {
        chooseFile.sendKeys("C:\\Juara Coding\\sqa batch 18\\hadir-app\\hadir-app-automation-testing\\src\\main\\resources\\uploadFile\\DATA_STATUS_USER.xlsx");
    }

    public void addFileInvalid(String file){
        chooseFile.sendKeys("C:\\Juara Coding\\sqa batch 18\\hadir-app\\hadir-app-automation-testing\\src\\main\\resources\\uploadFile\\DATA_STATUS_USER_INVALID.xlsx");
    }

    public void addFileEmptyData(String file){
        chooseFile.sendKeys("C:\\Juara Coding\\sqa batch 18\\hadir-app\\hadir-app-automation-testing\\src\\main\\resources\\uploadFile\\DATA_STATUS_USER_EMPTY_DATA.xlsx");
    }

    public void addFileFormatInvalid(String file){
        chooseFile.sendKeys("C:\\Juara Coding\\sqa batch 18\\hadir-app\\hadir-app-automation-testing\\src\\main\\resources\\uploadFile\\DATA_STATUS_USER.pdf");
    }

}