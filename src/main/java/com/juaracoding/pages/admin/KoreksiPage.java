package com.juaracoding.pages.admin;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.utils.Utils;
import jdk.jshell.execution.Util;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class KoreksiPage {
    private WebDriver driver;

    public KoreksiPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//p[normalize-space()='Laporan']")
    private WebElement laporanBtn;

    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-aqx7sf'][normalize-space()='Koreksi']")
    private WebElement koreksiBtn;

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

    @FindBy(xpath = "//tbody[@class='MuiTableContainer-root css-kge0eu']")
    private List<WebElement> allTableElements;

    @FindBy(xpath = "//input[@id='search']")
    private WebElement inputName;

    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedSecondary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-root MuiButton-contained MuiButton-containedSecondary MuiButton-sizeMedium MuiButton-containedSizeMedium css-1k0lhp1']//*[name()='svg']")
    private WebElement filterBtn;

    @FindBy(xpath = "//input[@id='job_departement']")
    private WebElement searchDepartment;

    @FindBy(xpath = "//button[@type='submit' and text()='Terapkan']")
    private WebElement terapkanBtn;

    @FindBy(xpath = "//tr[@class='MuiTableRow-root MuiTableRow-head css-9arnca']")
    private WebElement verifyUnit;

    @FindBy(xpath = "(//button[@aria-label='Approval Koreksi'])[1]")
    private WebElement approvalBtn;

    @FindBy(xpath = "//button[@aria-label='Reject Koreksi']")
    private WebElement rejectBtn;

    @FindBy(xpath = "//h6[@class='MuiTypography-root MuiTypography-h6 css-nub3j7' and text()='APPROVED']")
    private List<WebElement> verifyApproval;

    @FindBy(xpath = "//h6[@class='MuiTypography-root MuiTypography-h6 css-nub3j7' and text()='REJECT']")
    private List<WebElement> verifyReject;

    @FindBy(xpath = "//button[@type='submit' and text()='Setujui']")
    private WebElement setujuiBtn;

    @FindBy(xpath = "//input[@id='rejectReason']")
    private WebElement inputAlasan;

    @FindBy(xpath = "//button[@type='submit' and text()='Tolak']")
    private WebElement tolakBtn;

    @FindBy(xpath = "//input[@class='MuiSelect-nativeInput css-1k3x8v3']")
    private WebElement changeRows;

    @FindBy(xpath = "//tr[@role='checkbox']")
    private List<WebElement> displayedRows;


    public void setLaporanBtn() {
        laporanBtn.click();
    }

    public void setKoreksiBtn() {
        koreksiBtn.click();
    }

    public void setStartDateBtn() {
        Utils.delay(2);
        startDateBtn.click();
    }

    public void setDateValid(String startDate, String endDate) {
         startDateInput.click();
         startDateInput.sendKeys(Keys.COMMAND + "a");  // Select All (select seluruh teks)
         startDateInput.sendKeys(Keys.BACK_SPACE);  // Menghapus karakter
         Utils.delay(2);
         startDateInput.sendKeys(startDate);
         endDateInput.click();
         endDateInput.sendKeys(Keys.COMMAND + "a");  // Select All (select seluruh teks)
         endDateInput.sendKeys(Keys.BACK_SPACE);  // Menghapus karakter
         Utils.delay(2);
         endDateInput.sendKeys(endDate);
         Utils.delay(1);
     }


     public void setSaveBtn() {
        saveBtn.click();
     }

     public void setSearchBtn() {
        searchBtn.click();
     }

    public List<LocalDate> getAllDisplayedDates() {
        DateTimeFormatter tableFormatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        return allTableElements.stream()
                .map(WebElement::getText)
                .map(dateText -> LocalDate.parse(dateText, tableFormatter))
                .collect(Collectors.toList());
    }

    public void setNameValid(String name) {
        inputName.sendKeys(name);
    }

    public List<String> getAllDisplayedNames() {
        return allTableElements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public int getTableRowCount() {
        return allTableElements.size();
    }

    public void setFilterBtn() {
        filterBtn.click();
    }

    public void clickSearchDepartment() {
        searchDepartment.click();
    }

    public void setSearchDepartment(String filter) {
        searchDepartment.sendKeys(filter);
        Utils.delay(2);
        searchDepartment.sendKeys(Keys.ARROW_DOWN);
        searchDepartment.sendKeys(Keys.ENTER);
    }

    public void setTerapkanBtn() {
        terapkanBtn.click();
    }

    public String setVerifyUnit() {
        Utils.delay(2);
        return verifyUnit.getText();
    }

    public boolean isButtonDisabled() {
        return !terapkanBtn.isEnabled();  // Akan mengembalikan true jika tombol disabled
    }

    public void setApprovalBtn() {
        approvalBtn.click();
    }

    public void setSetujuiBtn(){
        setujuiBtn.click();
    }

    public int setVerifyApproval() {
        Utils.delay(2);
        return verifyApproval.size();
    }

    public void setRejectBtn() {
        rejectBtn.click();
    }

    public void clickInputAlasan() {
        inputAlasan.click();
    }

    public void setInputAlasan(String alasan) {
        Utils.delay(1);
        inputAlasan.sendKeys(alasan);
    }

    public void setTolakBtn() { tolakBtn.click();}

    public int setVerifyReject() {
        Utils.delay(2);
        return verifyReject.size();
    }

    public void setChangeRows() {
        Actions actions = new Actions(driver);
        actions.moveToElement(changeRows).click().perform();
        Utils.delay(3);
        actions.sendKeys(Keys.ARROW_UP).sendKeys(Keys.ENTER).perform();
    }

    public void setChangeRows25() {
        Actions actions = new Actions(driver);
        actions.moveToElement(changeRows).click().perform();
        Utils.delay(3);
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }

    public int getDisplayedRowCount() {
        return displayedRows.size();
    }

    public String isAlasanRequired() {
        return inputAlasan.getAttribute("required");
    }
}
