package com.juaracoding.pages.admin;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.utils.Utils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AturanCutiPage {
    private WebDriver driver;
    private WebDriverWait wait;
    public AturanCutiPage(){
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, 20);
    }

    @FindBy(xpath = "//p[text()='Management']")
    private WebElement tabManagement;
    @FindBy(xpath = "//p[text()='Aturan Cuti']")
    private WebElement aturanCutiMenu;
    @FindBy(xpath = "//input[@name='search']")
    private WebElement searchKolom;
    @FindBy(xpath = "//button[text()='Reset']")
    private WebElement resetBtn;
    @FindBy(xpath = "//button[text()='Search']")
    private WebElement searchBtn;
    @FindBy(xpath = "//button[text()='Tambahkan Aturan Cuti']")
    private WebElement tambahAturanCutiBtn;
    @FindBy(xpath = "//div[@aria-haspopup='listbox']")
    private WebElement rowsPerPage;
    @FindBy(xpath = "//ul[@role='listbox']/li")
    private List<WebElement> valuePerPageList;
    @FindBy(xpath = "//button[@aria-label='Go to next page']")
    private WebElement goToNextPage;
    @FindBy(xpath = "//button[@aria-label='Go to previous page']")
    private WebElement goToPrevPage;
    @FindBy(xpath = "(//button[@aria-label='action'])[1]")
    private WebElement moreAction;
    @FindBy(xpath = "//li[@role='menuitem']")
    private List<WebElement> moreActionList;
    @FindBy(xpath = "//tr[@class='MuiTableRow-root MuiTableRow-hover css-9arnca']")
    private List<WebElement> aturanCutiList;

    //Tambahkan Aturan Cuti Page

    @FindBy(xpath = "//input[@id='name']")
    private WebElement namaAturanCuti;
    @FindBy(xpath = "//input[@id='eligible_leave_total_month']")
    private WebElement eligibleAturanCuti;
    @FindBy(xpath = "//input[@placeholder='d']")
    private WebElement tanggalBatasSisaCuti;
    @FindBy(xpath = "//input[@placeholder='m']")
    private WebElement bulanBatasSisaCuti;
    @FindBy(xpath = "//input[@id='max_carry_forward']")
    private WebElement maksimalSisaCuti;
    @FindBy(xpath = "//input[@id='carry_forward_total_month']")
    private WebElement jumlahBulanKerjaSisaCuti;
    @FindBy(xpath = "//button[text()='Tutup']")
    private WebElement tutupBtn;
    @FindBy(xpath = "//button[text()='Tambahkan']")
    private WebElement tambahkanBtn;
    @FindBy(xpath = "//button[text()='Simpan']")
    private WebElement simpanBtn;
    @FindBy(xpath = "//button[text()='Hapus']")
    private WebElement hapusBtn;

    //Detail Aturan Cuti Page

    @FindBy(xpath = "//button[text()='Tambahkan Detail Aturan Cuti']")
    private WebElement tambahkanDetailAturanCuti;
    @FindBy(xpath = "//input[@id='total_month_greater']")
    private WebElement minimalBulanBekerja;
    @FindBy(xpath = "//input[@id='total_leave']")
    private WebElement totalCuti;

    @FindBy(xpath = "//div[@class='MuiSnackbarContent-message css-1w0ym84']")
    private WebElement actionMessage;

    @FindBy(xpath = "//p[@class='MuiFormHelperText-root Mui-error MuiFormHelperText-sizeSmall MuiFormHelperText-contained css-a13hsf']")
    private WebElement formMessage;

    @FindBy(xpath = "//p[@id='total_month_greater-helper-text']")
    private WebElement errorMessageMinimalBulanBekerja;

    @FindBy(xpath = "//p[@id='total_leave-helper-text']")
    private WebElement errorMessageTotalCuti;

    @FindBy(xpath = "//div[@class='MuiTableContainer-root css-1dfrqi4']")
    private WebElement tableData;

    public void waitTableData(){
        wait.until(ExpectedConditions.visibilityOf(tableData));
    }

    public String getFormMessage(){
        return wait.until(ExpectedConditions.visibilityOf(formMessage)).getText();
        //return formMessage.getText();
    }

    public String getActionMessage(){
        return wait.until(ExpectedConditions.visibilityOf(actionMessage)).getText();
        //return actionMessage.getText();
    }
    public void clickManagamentMenu(){
        wait.until(ExpectedConditions.elementToBeClickable(tabManagement)).click();
        //tabManagement.click();
    }
    public void clickAturanCutiMenu(){
        wait.until(ExpectedConditions.elementToBeClickable(aturanCutiMenu)).click();
        //aturanCutiMenu.click();
    }
    public void clickSearchColumn(){
        wait.until(ExpectedConditions.elementToBeClickable(searchKolom)).click();
        //searchKolom.click();
    }
    public String getSearchColumnValue(){
        return wait.until(ExpectedConditions.visibilityOf(searchKolom)).getText();
        //return searchKolom.getText();
    }
    public void searchValue(String aturanCutiName){
        wait.until(ExpectedConditions.elementToBeClickable(searchKolom));
        searchKolom.sendKeys(Keys.CONTROL,"a",Keys.BACK_SPACE);
        searchKolom.sendKeys(aturanCutiName);
    }
    public void clickResetBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(resetBtn));
        resetBtn.click();
    }
    public void clickSearchBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
        searchBtn.click();
    }
    public void clickTambahAturanCutiBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(tambahAturanCutiBtn));
        tambahAturanCutiBtn.click();
    }
    public void clickRowsPerPage(){
        //wait.until(ExpectedConditions.visibilityOf(rowsPerPage));
        //wait.until(ExpectedConditions.elementToBeClickable(rowsPerPage));
        rowsPerPage.click();
    }
    public void clickGoToNextPage(){
        wait.until(ExpectedConditions.elementToBeClickable(goToNextPage));
        goToNextPage.click();
    }
    public void clickGoToPrevPage(){
        wait.until(ExpectedConditions.elementToBeClickable(goToPrevPage));
        goToPrevPage.click();
    }
    public void clickMoreAction(){
        wait.until(ExpectedConditions.visibilityOf(moreAction));
        wait.until(ExpectedConditions.elementToBeClickable(moreAction));
        moreAction.click();
    }
    public void clickViewActionAturanCuti(){
        wait.until(ExpectedConditions.elementToBeClickable(moreActionList.get(0)));
        moreActionList.get(0).click();
    }
    public void clickEditActionAturanCuti(){
        wait.until(ExpectedConditions.elementToBeClickable(moreActionList.get(1)));
        moreActionList.get(1).click();
    }
    public void clickDeleteActionAturanCuti(){
        wait.until(ExpectedConditions.elementToBeClickable(moreActionList.get(2)));
        moreActionList.get(2).click();
    }
    public void rowsPerPage(String valuePerPage){
        switch (valuePerPage){
            case "5":
                valuePerPageList.get(0).click();
            case "10":
                valuePerPageList.get(1).click();
            case "25":
                valuePerPageList.get(2).click();
        }
    }
    public void clickEditActionDetailAturanCuti(){
        wait.until(ExpectedConditions.elementToBeClickable(moreActionList.get(0)));
        moreActionList.get(0).click();
    }
    public void clickDeleteActionDetailAturanCuti(){
        wait.until(ExpectedConditions.elementToBeClickable(moreActionList.get(1)));
        moreActionList.get(1).click();
    }
    public void setNamaAturanCuti(String aturanCutiName){
        wait.until(ExpectedConditions.elementToBeClickable(namaAturanCuti));
        namaAturanCuti.sendKeys(Keys.CONTROL,"a",Keys.BACK_SPACE);
        namaAturanCuti.sendKeys(aturanCutiName);
    }
    public String getNameAturanCuti(){
        wait.until(ExpectedConditions.visibilityOf(namaAturanCuti));
        return namaAturanCuti.getAttribute("value");
    }
    public void setEligibleAturanCuti(String eligibleAturanCuti){
        wait.until(ExpectedConditions.elementToBeClickable(this.eligibleAturanCuti));
        this.eligibleAturanCuti.sendKeys(Keys.CONTROL,"a",Keys.BACK_SPACE);
        this.eligibleAturanCuti.sendKeys(eligibleAturanCuti);
    }
    public void setTanggalBatasSisaCuti(String tanggalBatasSisaCuti){
        wait.until(ExpectedConditions.elementToBeClickable(this.tanggalBatasSisaCuti));
        this.tanggalBatasSisaCuti.sendKeys(Keys.CONTROL,"a",Keys.BACK_SPACE);
        this.tanggalBatasSisaCuti.sendKeys(tanggalBatasSisaCuti);
    }
    public void setBulanBatasSisaCuti(String bulanBatasSisaCuti){
        wait.until(ExpectedConditions.elementToBeClickable(this.bulanBatasSisaCuti));
        this.bulanBatasSisaCuti.sendKeys(Keys.CONTROL,"a",Keys.BACK_SPACE);
        this.bulanBatasSisaCuti.sendKeys(bulanBatasSisaCuti);
    }
    public void setMaksimalSisaCuti(String maksimalSisaCuti){
        wait.until(ExpectedConditions.elementToBeClickable(this.maksimalSisaCuti));
        this.maksimalSisaCuti.sendKeys(Keys.CONTROL,"a",Keys.BACK_SPACE);
        this.maksimalSisaCuti.sendKeys(maksimalSisaCuti);
    }
    public void setJumlahBulanKerjaSisaCuti(String jumlahBulanKerjaSisaCuti){
        wait.until(ExpectedConditions.elementToBeClickable(this.jumlahBulanKerjaSisaCuti));
        this.jumlahBulanKerjaSisaCuti.sendKeys(Keys.CONTROL,"a",Keys.BACK_SPACE);
        this.jumlahBulanKerjaSisaCuti.sendKeys(jumlahBulanKerjaSisaCuti);
    }
    public void clickTutupBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(tutupBtn));
        tutupBtn.click();
    }
    public void clickTambahkanBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(tambahkanBtn));
        tambahkanBtn.click();
    }
    public void clickSimpanBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(simpanBtn));
        simpanBtn.click();
    }
    public void clickHapusBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(hapusBtn));
        hapusBtn.click();
    }
    public void clickTambahkanDetailAturanCuti(){
        wait.until(ExpectedConditions.elementToBeClickable(tambahkanDetailAturanCuti));
        tambahkanDetailAturanCuti.click();
    }
    public void setMinimalBulanBekerja(String minimalBulanBekerja){
        wait.until(ExpectedConditions.elementToBeClickable(this.minimalBulanBekerja));
        this.minimalBulanBekerja.sendKeys(Keys.CONTROL,"a",Keys.BACK_SPACE);
        this.minimalBulanBekerja.sendKeys(minimalBulanBekerja);
    }
    public void setTotalCuti(String totalCuti){
        wait.until(ExpectedConditions.elementToBeClickable(this.totalCuti));
        this.totalCuti.sendKeys(Keys.CONTROL,"a",Keys.BACK_SPACE);
        this.totalCuti.sendKeys(totalCuti);
    }
    public String getAturanCutiData(){
        wait.until(ExpectedConditions.visibilityOf(aturanCutiList.get(0)));
        return aturanCutiList.get(0).getText();
        //return aturanCutiList.get(0).findElement(By.xpath("(/td/p)[1]")).getText();
    }
    public int getCountAturanCutiData(){
        wait.until(ExpectedConditions.visibilityOfAllElements(aturanCutiList));
        return aturanCutiList.size();
    }
    public String getMinimalBulanBekerjaErrorMessage(){
        wait.until(ExpectedConditions.visibilityOf(errorMessageMinimalBulanBekerja));
        return errorMessageMinimalBulanBekerja.getText();
    }
    public String getTotalCutiErrorMessage(){
        wait.until(ExpectedConditions.visibilityOf(errorMessageTotalCuti));
        return errorMessageTotalCuti.getText();
    }
}
