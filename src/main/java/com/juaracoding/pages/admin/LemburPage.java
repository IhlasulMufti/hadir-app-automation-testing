package com.juaracoding.pages.admin;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.utils.Utils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class LemburPage {
    private WebDriver driver;

    public LemburPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//p[normalize-space()='Laporan']")
    private WebElement menuLaporan;

    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-aqx7sf'][normalize-space()='Lembur']")
    private WebElement subMenuLembur;

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

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/div/div[2]/div/div[3]/div/div/p[2]")
    private WebElement txtDataRecordEmpty;

    @FindBy(xpath = "//tr[@class= 'MuiTableRow-root MuiTableRow-hover css-lry5m7']")
    private WebElement listDataRecord;

    @FindBy(xpath = "//button[normalize-space()='Export']")
    private WebElement btnExport;

    @FindBy(xpath = "//div[@class='MuiSnackbarContent-message css-1w0ym84']")
    private WebElement txtAlertExport;

    @FindBy(xpath = "//p[@class= 'MuiTablePagination-displayedRows css-kim0d']")
    private WebElement txtJmlDataRow;

    @FindBy(xpath = "//h6[text()=\"IT Programmer\"]")
    private List<WebElement> txtUnit;

    @FindBy(xpath = "//tr[@class= 'MuiTableRow-root MuiTableRow-head css-9arnca']")
    private WebElement txtTabelUnit;

    @FindBy(xpath = "//tbody/tr[1]/td[14]/div[1]/div[2]/a[1]")
    private WebElement btnView;

    @FindBy(xpath = "//tbody/tr[1]/td[15]/button[1]//*[name()='svg']")
    private WebElement btnAksi;

    @FindBy(xpath = "//button[contains(@class, 'MuiButton-containedSizeMedium css-3uvhvk')]")
    private WebElement btnCancelRequest;

    @FindBy(xpath = "//h6[@class= 'MuiTypography-root MuiTypography-h6 css-nub3j7']")
    private WebElement txtStatusWait;

    @FindBy(xpath = "//button[contains(@class, 'MuiButton-containedSizeMedium css-4075ia')]")
    private WebElement btnUbahData;

    @FindBy(xpath = "//div[@id='mui-3']")
    private WebElement btnRowsPerPage;

    @FindBy(xpath = "//li[contains(@class, 'MuiTablePagination-menuItem css-74h9kj')]")
    private WebElement btnRowsPerPage5;

    @FindBy(xpath = "//*[@id=\"mui-2\"]/li[2]")
    private WebElement btnRowsPerPage10;

    @FindBy(xpath = "//*[@id=\"mui-2\"]/li[3]")
    private WebElement btnRowsPerPage25;

    @FindBy(xpath = "//p[@class= 'MuiTablePagination-displayedRows css-kim0d']")
    private WebElement txtRows25;


    public String getTxtRows(){
        return txtRows25.getText();
    }

    public void setBtnRowsPerPage(){
        btnRowsPerPage.click();
    }
    public void setBtnRowsPerPage25(){
        btnRowsPerPage25.click();
    }
    public void setBtnRowsPerPage10(){
        btnRowsPerPage10.click();
    }
    public void setBtnRowsPerPage5(){
        btnRowsPerPage5.click();
    }
    public void setBtnAksi(){
        btnAksi.click();
    }
    public void setBtnCancelRequest(){
        btnCancelRequest.click();
    }
    public void setBtnView(){
        btnView.click();
    }
    public String getTxtTabelUnit(){
        return txtTabelUnit.getText();
    }
    public String getTxtUnitTotal(){
        return Integer.toString(txtUnit.size());
    }

    public String getTxtJmlDataRow(){
        return txtJmlDataRow.getText();
    }

    public void setBtnExport(){
        btnExport.click();
    }

    public String getTxtAlertExport(){
        return txtAlertExport.getText();
    }


    public String getTxtDataEmpty(){
        return txtDataRecordEmpty.getText();
    }


    public void setMenuLaporan(){
        menuLaporan.click();
    }
    public void setSubMenuLembur(){
        subMenuLembur.click();
    }

    public void setInputSearchInvalid(String name){
        inputSearch.sendKeys(name);
    }

    public void setInputStartDate(String startdate){
        inputStartDate.clear();
        inputStartDate.sendKeys(startdate);
    }
    public void setInputEndDate(String enddate){
        inputEndDate.clear();
        inputEndDate.sendKeys(enddate);
    }
    public void setInputFilterInvalid(String filter){

        inputFilter.sendKeys(filter);
        Utils.delay(2);
        inputFilter.sendKeys(Keys.ARROW_DOWN);
        inputFilter.sendKeys(Keys.ENTER);
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

}
