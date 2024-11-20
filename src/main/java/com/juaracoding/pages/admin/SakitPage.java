package com.juaracoding.pages.admin;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.utils.Utils;
import jdk.jshell.execution.Util;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SakitPage {
    private WebDriver driver;
    private static final String DOWNLOAD_DIR = "C:\\Users\\giffari\\Downloads";


    public SakitPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//p[normalize-space()='Laporan']")
    private WebElement menuLaporan;

    @FindBy(xpath = "//p[normalize-space()='Sakit']")
    private WebElement subMenuSakit;

    @FindBy(xpath = "//input[@id='search']")
    private WebElement inputSearch;

    @FindBy(xpath = "//button[contains(@class, 'MuiIconButton-sizeMedium css-q9cuy5')]")
    private WebElement btnDate;

    @FindBy(xpath = "//input[@placeholder='Early']")
    private WebElement inputStartDate;

    @FindBy(xpath = "//input[@placeholder='Continuous']")
    private WebElement inputEndDate;

    @FindBy(xpath = "//button[normalize-space()='save']")
    private WebElement btnSaveDate;

    @FindBy(xpath = "//button[contains(@class, 'MuiButton-containedSizeMedium')]")
    private WebElement btnFilter;

    @FindBy(id = "job_departement")
    private WebElement inputFilter;

    @FindBy(xpath = "//button[contains(@class, 'MuiButton-containedSizeMedium css-4075ia')]")
    private WebElement btnTerapkan;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnSearch;

    @FindBy(xpath = "//button[normalize-space()='Reset']")
    private WebElement btnReset;

    @FindBy(xpath = "/html/body/div[3]/div[3]/div/form/div[1]/div/div/div/div/div/div")
    private WebElement btnClearFilter;

    @FindBy(xpath = "/html/body/div[3]/div[3]/div/form/div[2]/button[1]")
    private WebElement btnBatalFilter;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/div/div[2]/div/div[1]/div/table/tbody/tr[1]/td[5]/h6/div/div/a[1]")
    private WebElement btnView;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/div/div[2]/div/div[1]/div/table/tbody/tr[1]/td[5]/h6/div/div/a[2]")
    private WebElement btnDownload;

    @FindBy(xpath = "//p[@class= 'MuiTablePagination-displayedRows css-kim0d']")
    private WebElement txtDataRecordEmpty;

    @FindBy(xpath = "//td//h6[contains(@class, 'css-d5zmtp')]")
    private WebElement recordName;

    @FindBy(xpath = "//td//h6[contains(@class, 'css-1gtt4lb')]")
    private List <WebElement> recordDate;

    @FindBy(xpath = "/html/body/div[3]")
    private WebElement buktiSakit;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/div/div[2]/div/div[1]/div/table/tbody/tr[1]")
    private List<WebElement> recordData;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/div/div[2]/div/div[1]/div/table/thead/tr")
    private WebElement txtUnit;

    @FindBy(xpath = "//img[@alt= 'Photo sakit']")
    private WebElement viewDisplay;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/div/div[2]/div/div[2]/div/div/div[3]/button[3]")
    private WebElement btnNextPage;

    @FindBy(xpath = "//p[contains(@class, 'MuiTablePagination-displayedRows css-kim0d')] ")
    private WebElement txtNextPage;

    public boolean fileExport(){
        String path = DOWNLOAD_DIR + "\\" + "foto bukti sakit.jpg";
        File file = new File(path);
        return file.exists();
    }



    public String getTxtNextPage(){

        return txtNextPage.getText();
    }
    public void setBtnNextPage(){
        Utils.delay(2);
        btnNextPage.click();
        Utils.delay(2);
    }

    public boolean getViewDisplay(){
        System.out.println(viewDisplay.isDisplayed());
        return viewDisplay.isDisplayed();
    }


    public String getTxtUnit(){
        return txtUnit.getText();
    }


    public boolean setRecordData(){
        System.out.println(recordData.size());
        System.out.println();
        for (WebElement dataRecord : recordData){
            System.out.println(dataRecord.getText());
        }
        return recordData.isEmpty();
    }

    public String getTxtDataRecordEmpty(){

        return txtDataRecordEmpty.getText();
    }

    public String recordNameDetail(){
        return recordName.getText();
    }

    public String recordDateDetail(){
        return recordDate.get(0).getText();
    }


    public void setMenuLaporan(){
        menuLaporan.click();
    }
    public void setSubMenuSakit(){
        subMenuSakit.click();
    }
    public void setInputSearchInvalid(String name){
        inputSearch.sendKeys(name);
    }

    public void setBtnDate(){
        btnDate.click();
    }
    public void setInputStartDate(String startdate){
        inputStartDate.clear();
        inputStartDate.sendKeys(startdate);
    }
    public void setInputEndDate(String enddate){
        inputEndDate.clear();
        inputEndDate.sendKeys(enddate);
    }
    public void setBtnSaveDate(){
        btnSaveDate.click();
    }
    public void setBtnFilter(){
        btnFilter.click();
    }
    public void setInputFilterInvalid(String filter){

        inputFilter.sendKeys(filter);
        Utils.delay(2);
        inputFilter.sendKeys(Keys.ARROW_DOWN);
        inputFilter.sendKeys(Keys.ARROW_DOWN);
        inputFilter.sendKeys(Keys.ENTER);
    }
    public void setBtnTerapkan(){
        btnTerapkan.sendKeys(Keys.ENTER);
    }
    public void setBtnSearch(){
        btnSearch.click();
    }

    public void setBtnReset(){
        btnReset.click();
    }

    public void setBtnClearFilter(){
        btnClearFilter.click();
    }

    public void setBtnBatalFilter(){
        btnBatalFilter.click();
    }

    public void setInputFiltervalid(String filter){

        inputFilter.sendKeys(filter);
        Utils.delay(3);
        inputFilter.sendKeys(Keys.ARROW_DOWN);
        inputFilter.sendKeys(Keys.ENTER);
    }

    public void setInputSearchValid(String name){
        inputSearch.sendKeys(name);
    }

    public void setInputSearchValid2(String name){
        inputSearch.sendKeys(name);
    }

    public void setBtnView(){
        btnView.click();
        Utils.delay(3);

    }


    public void setBtnDownload(){
        btnDownload.click();
        Utils.delay(2);
    }


}