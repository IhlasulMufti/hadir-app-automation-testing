package com.juaracoding.pages.user;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.utils.Utils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AbsentPage {

    private WebDriver driver;

    public AbsentPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[normalize-space()='Absen Masuk']")
    private WebElement btnClockingIn;

    @FindBy(xpath = "//button[contains(@class, 'css-1xarbr2')]")
    private WebElement btnCamera;

    @FindBy(xpath = "//input[contains(@class, 'css-mnn31')]")
    private WebElement time;

    @FindBy(xpath = "//div[contains(@id, 'select-is_wfh')]")
    private WebElement absentTpye;

    @FindBy(xpath = "//li[@tabindex='0']")
    private WebElement absentTypeList;

    @FindBy(xpath = "//input[@name='notes']")
    private WebElement clockingInNotes;

    @FindBy(xpath = "//button[contains(@class, 'css-1a2vnko')]")
    private WebElement clockingInSubmitBtn;

    @FindBy(xpath = "(//p[contains(@class, 'css-td73y7')])[1]")
    private WebElement successAbsentDate;

    @FindBy(xpath = "(//p[contains(@class, 'css-8otdjv')])[1]")
    private WebElement successAbsentTime;

    @FindBy(xpath = "(//p[contains(@class, 'css-8otdjv')])[2]")
    private WebElement successAbsentNote;

    @FindBy(xpath = "(//img[@alt='Photo Check In'])[1]")
    private WebElement successAbsentPhoto;

    @FindBy(xpath = "//p[normalize-space()='History Absensi']")
    private WebElement txtAbsentHistory;

    @FindBy(xpath = "//button[contains(@class, 'css-1fl1h2m')]")
    private WebElement btnKeluar;

    @FindBy(xpath = "//textarea[@name='notes']")
    private WebElement clockingOutNotes;

    @FindBy(xpath = "//button[contains(@class, 'css-arawcv')]")
    private WebElement clockingOutSubmitBtn;

    public String clickBtnClockingIn() {
        try {
            btnClockingIn.click();
            return "Clocking In Button Found";
        } catch (RuntimeException e) {
            return "Clocking In Button Not Found";
        }
    }

    public void clickBtnClockingOut() { btnKeluar.click(); }

    public void takeSelfiePhoto() {
        btnCamera.click();
    }

    public String absentTime() {
        return time.getAttribute("value");
    }

    public void selectAbsentType() {
        absentTpye.click();
        absentTypeList.click();
    }

    public void inputClockingInNotes(String notes) {
        Utils.delay(2);
        this.clockingInNotes.sendKeys(notes);
    }

    public void inputClockingOutNotes(String notes) {
        Utils.delay(2);
        this.clockingOutNotes.sendKeys(notes);
    }

    public void submitClockingIn() {
        clockingInSubmitBtn.click();
    }

    public void submitClockingOut() {
        clockingOutSubmitBtn.click();
    }

    public String setTxtAbsentHistory() {
        return txtAbsentHistory.getText();
    }

    public String  setSuccessAbsentDate() {
        return successAbsentDate.getText();
    }

    public String setSuccessAbsentTime() {
        return successAbsentTime.getText();
    }

    public String setSuccessAbsentNote() {
        return successAbsentNote.getText();
    }

    public boolean setSuccessAbsentPhoto() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Boolean is_image_loaded = (Boolean) js.executeScript(
                "return arguments[0].complete && arguments[0].naturalWidth > 0", successAbsentPhoto);

        return is_image_loaded;
    }
}
