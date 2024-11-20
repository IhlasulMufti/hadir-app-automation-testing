package com.juaracoding.pages.admin;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.utils.Utils;
import jdk.jshell.execution.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KehadiranPage {
    private WebDriver driver;

    public KehadiranPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//p[normalize-space()='Laporan']")
    private WebElement laporanBtn;

    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-aqx7sf'][normalize-space()='Kehadiran']")
    private WebElement kehadiranBtn;

    @FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-md-7 MuiGrid-grid-lg-8 css-kw2xn2']//div[1]//div[1]//div[1]//button[1]//*[name()='svg']")
    private WebElement startDateBtn;

    @FindBy(xpath = "//input[@placeholder='Early']")
    private WebElement startDateInput;

    @FindBy(xpath = "//input[@placeholder='Continuous']")
    private WebElement endDateInput;

    @FindBy(xpath = "//button[normalize-space()='save']")
    private WebElement saveBtn;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchBtn;

    @FindBy(xpath = "//input[@id='search']")
    private WebElement name;

    @FindBy(xpath = "//button[contains(@class, 'MuiButton-containedSecondary')]//*[name()='svg']")
    private WebElement filterBtn;

    @FindBy(xpath = "//*[@id='job_departement']")
    private WebElement jobDepartment;

    @FindBy(xpath = "//button[contains(@class, 'MuiButton-containedSizeMedium css-4075ia')]")
    private WebElement btnTerapkan;

    @FindBy(xpath = "//h6[normalize-space()='kazama']")
    private WebElement validTxt;

    @FindBy(xpath = "//p[contains(@class, 'displayedRows')]")
    private WebElement invalidTxt;

    @FindBy(xpath = "//button[normalize-space()='Export']")
    private WebElement exportBtn;

    @FindBy(xpath = "//button[@type='submit' and (text()='Export' or .='Export')]")
    private WebElement extendExportBtn;

    @FindBy(xpath = "//div[contains(@class, 'MuiSnackbarContent-message') and contains(text(), 'Maaf terjadi kesalahan pada server')]")
    private WebElement errorTxt;

    @FindBy(xpath = "//button[normalize-space()='Reset']")
    private WebElement resetBtn;

    @FindBy(xpath = "//h5[normalize-space()='Unit']")
    private WebElement resetKehadiranTxt;

    public void clearStartDate() {
        Utils.delay(2);
        startDateInput.clear();
    }

    public void clearEndDate() {
        Utils.delay(2);
        endDateInput.clear();
    }

    public void setLaporanBtn(){
        laporanBtn.click();
    }

    public void setKehadiranBtn(){
        kehadiranBtn.click();
    }

    public void setName(String name){
        this.name.sendKeys(name);
    }

    public void setDateButton(){
        startDateBtn.click();
    }

    public void getInputStartDate(String startDateInput){
        this.startDateInput.sendKeys(startDateInput);
    }

    public void getInputEndDate(String endDateInput){
        this.endDateInput.sendKeys(endDateInput);
    }

    public void getSaveButton(){
        saveBtn.click();
    }

    public void getFilterButton(){
        filterBtn.click();
    }

    public void setJobDepartment(String jobDepartment){
        this.jobDepartment.sendKeys(jobDepartment);
    }

    public void getTerapkanButton(){
        btnTerapkan.click();
    }

    public void getSearchButton(){
        searchBtn.click();
    }

    public String getTxtValid(){
        return validTxt.getText();
    }

    public String getTxtInvalid(){
        return invalidTxt.getText();
    }

    public void getExportButton(){
        exportBtn.click();
    }

    public void getExtendExportButton(){
        extendExportBtn.click();
    }

    public String getErroTxt(){
        return errorTxt.getText();
    }

    public void getResetButton(){
        resetBtn.click();
    }

    public String getResetButtonValid(){
        return resetKehadiranTxt.getText();
    }

}
