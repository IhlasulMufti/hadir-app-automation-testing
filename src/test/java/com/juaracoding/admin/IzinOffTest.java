package com.juaracoding.admin;


import com.juaracoding.Hooks;
import com.juaracoding.pages.admin.IzinOffPage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class IzinOffTest {

    private static WebDriver driver;
    private ExtentTest extentTest;
    private static IzinOffPage izinOffPage = new IzinOffPage();


    public IzinOffTest() {
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @When("Click izin off button")
    public void click_laporan_button() {
        izinOffPage.setIzinOffBtn();
        extentTest.log(LogStatus.PASS, "CLick izin off button");
    }

    @And("Click aksi button")
    public void click_aksi_button() {
        izinOffPage.setAksiBtn();
        extentTest.log(LogStatus.PASS, "CLick aksi button");
    }

    @And("Click approval izin off")
    public void click_approval_izin_off() {
        izinOffPage.setApproveBtn();
        extentTest.log(LogStatus.PASS, "Click approval izin off");
    }

    @And("Click setujui button on the alert message")
    public void click_setujui_button() {
        izinOffPage.setSetujuiBtn();
        extentTest.log(LogStatus.PASS, "Click setujui button on the alert message");
    }

    @And("Click reject izin off")
    public void click_reject_izin_off() {
        izinOffPage.setRejectBtn();
        extentTest.log(LogStatus.PASS, "CLick reject koreksi");
    }

    @And("Input dengan alasan reject and click tolak")
    public void input_dengan_alasan_reject_and_click_tolak() {
        izinOffPage.clickInputAlasan();
        izinOffPage.setInputAlasan("Data yang dikoreksi salah");
        izinOffPage.setTolakBtn();
        extentTest.log(LogStatus.PASS, "Input dengan alasan reject and click tolak");
    }

    @And("Click tolak without alasan")
    public void click_tolak_without_alasan() {
        izinOffPage.setTolakBtn();
        extentTest.log(LogStatus.PASS, "Click tolak without alasan");
    }

    @Then("Verify approval izin off is failed because different boss")
    public void verify_approval_izin_off_is_failed_because_different_boss() {
        Assert.assertEquals(izinOffPage.setVerifyApproval(),"Gagal menyetujui. Tidak bisa approve dengan atasan yang berbeda" );
        extentTest.log(LogStatus.PASS, "Verify approval izin off failed because different boss");
    }

    @Then("Verify rejected izin off is failed because different boss")
    public void verify_rejected_izin_off_is_failed_because_different_boss() {
        Assert.assertEquals(izinOffPage.setVerifyReject(), "Gagal menolak. Tidak bisa approve dengan atasan yang berbeda" );
        extentTest.log(LogStatus.PASS, "Verify rejected izin off is failed because different boss");
    }

    @Then("Verify rejected izin off is failed")
    public void verify_rejected_izin_off_is_failed() {
        Assert.assertEquals(izinOffPage.isAlasanRequired(), "true", "Verify rejected is failed because input is required");
        extentTest.log(LogStatus.PASS, "Verify rejected izin off is failed");
    }



}


