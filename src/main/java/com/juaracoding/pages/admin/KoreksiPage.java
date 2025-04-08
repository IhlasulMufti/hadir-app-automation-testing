package com.juaracoding.pages.admin;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class KoreksiPage {

    private WebDriver driver;



    public KoreksiPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-aqx7sf'][normalize-space()='Koreksi']")
    private WebElement subMenuKoreksi;

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

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/div/div[2]/div[1]/div/table/tbody/tr[1]/td[6]/h6[1]")
    private WebElement txt08nov;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/div/div[2]/div[1]/div/table/tbody/tr[1]/td[2]/h6")
    private WebElement txtUserQA;

    @FindBy(xpath = "//button[@aria-label='Approval Koreksi']//*[name()='svg']")
    private WebElement btnApproval;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/div/div[2]/div[1]/div/table/tbody/tr[1]/td[8]/div/h6")
    private WebElement txtApproved;

    @FindBy(xpath = "/html/body/div[3]/div[3]/div/form/div[2]/button[1]")
    private WebElement btnSetuju;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/div/div[2]/div[1]/div/table/tbody/tr[1]/td[10]/div/button[2]")
    private WebElement btnReject;

    @FindBy(xpath = "//*[@id=\"rejectReason\"]")
    private WebElement inputAlasan;

    @FindBy(xpath = "/html/body/div[3]/div[3]/div/form/div[2]/button[1]")
    private WebElement btnTolak;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/div/div[2]/div[1]/div/table/tbody/tr[1]/td[8]/div/h6")
    private WebElement txtReject;

    @FindBy(xpath = "//button[normalize-space()='Reset']")
    private WebElement btnReset2;


    public void setSubMenuKoreksi(){
        subMenuKoreksi.click();
    }

    public void setInputSearch(String nama){
        inputSearch.sendKeys(nama);
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

    public String getTxt08Nov(){
        return txt08nov.getText();

    }

    public String getTxtUserQA(){
        return txtUserQA.getText();
    }

    public void setBtnApproval(){
        btnApproval.click();
    }

    public String getTxtApproved(){
        return txtApproved.getText();
    }

    public void setBtnSetuju(){
        btnSetuju.click();
    }

    public void setBtnReject(){
        btnReject.click();
    }

    public void setInputAlasan(String alasan){
        inputAlasan.sendKeys(alasan);
    }

    public void setBtnTolak(){
        btnTolak.click();
    }

    public String getTxtReject(){
        return txtReject.getText();
    }

    public void getBtnReset2(){
        btnReset2.click();
    }

}


