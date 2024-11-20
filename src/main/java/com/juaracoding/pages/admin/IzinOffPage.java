package com.juaracoding.pages.admin;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.nio.file.WatchEvent;


public class IzinOffPage {
    private WebDriver driver;

    public IzinOffPage() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-aqx7sf'][normalize-space()='Izin Off']")
    private WebElement izinOffBtn;

    @FindBy(xpath = "//tbody/tr[1]/td[7]/div[1]/div[1]/button[1]//*[name()='svg']")
    private WebElement aksiBtn;

    @FindBy(xpath = "//li[@class='MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters MuiMenuItem-root MuiMenuItem-gutters css-1fh5cnl' and text()='Approval Koreksi']")
    private WebElement approveBtn;

    @FindBy(xpath = "//li[@class='MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters MuiMenuItem-root MuiMenuItem-gutters css-1fh5cnl' and text()='Reject Koreksi']")
    private WebElement rejectBtn;

    @FindBy(xpath = "//button[@id='sumbit-approval-request' and text()='Setujui']")
    private WebElement setujuiBtn;

    @FindBy(xpath = "//input[@id='reject_reason']")
    private WebElement inputAlasan;

    @FindBy(xpath = "//button[@id='sumbit-approval-request']")
    private WebElement tolakBtn;

    @FindBy(xpath = "//div[contains(@class, 'MuiSnackbarContent-message') and text()='Gagal menyetujui. Tidak bisa approve dengan atasan yang berbeda']")
    private WebElement verifyApproval;

    @FindBy(xpath = "//div[@class='MuiSnackbarContent-message css-1w0ym84']\n")
    private WebElement verifyReject;


    public void setIzinOffBtn() {
        izinOffBtn.click();
    }

    public void setAksiBtn() {
        aksiBtn.click();
    }

    public void setApproveBtn() {
        approveBtn.click();
    }

    public void setSetujuiBtn() {
        setujuiBtn.click();
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

    public void setTolakBtn() {
        tolakBtn.click();
    }

    public String setVerifyApproval() {
        Utils.delay(2);
        return verifyApproval.getText();
    }

    public String setVerifyReject() {
        Utils.delay(2);
        return verifyReject.getText();
    }

    public String isAlasanRequired() {
        return inputAlasan.getAttribute("required");
    }
}
