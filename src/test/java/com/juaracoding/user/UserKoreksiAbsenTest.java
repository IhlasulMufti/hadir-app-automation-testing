package com.juaracoding.user;

import com.juaracoding.Hooks;
import com.juaracoding.pages.user.UserKoreksiAbsenPage;
import com.juaracoding.utils.Constants;
import com.juaracoding.utils.Utils;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class UserKoreksiAbsenTest {

    private static WebDriver driver;

    private ExtentTest extentTest;

    private static UserKoreksiAbsenPage userKoreksiAbsenPage = new UserKoreksiAbsenPage();

    private WebDriver WebDriverRefrence;

    public UserKoreksiAbsenTest(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @And("i click attendance correction")
    public void i_click_attedance_correction(){
        userKoreksiAbsenPage.setBtnKoreksiAbsen();
        extentTest.log(LogStatus.PASS, "i click attendance correction");
    }

    @Then("I should be redirect to correction page")
    public void i_should_be_redirect_to_correction_page(){
        Assert.assertEquals(userKoreksiAbsenPage.getTxtHalaman(), "Halaman Koreksi");
        Assert.assertEquals(userKoreksiAbsenPage.getTxtListKoreksi(), "List Koreksi");
        Assert.assertEquals(userKoreksiAbsenPage.getTxtNameUser(), "testerjuara");
        extentTest.log(LogStatus.PASS, "I should be redirect to correction page");
    }

    @And("I click Request Correction")
    public void i_click_request_correction(){
        userKoreksiAbsenPage.setBtnAjukanKoreksi();
        extentTest.log(LogStatus.PASS, "I click Request Correction");
    }

    @And("I choose a date and time")
    public void i_choose_a_date_and_time(){
        userKoreksiAbsenPage.setBtnJamMasuk();
        Utils.delay(2);
        userKoreksiAbsenPage.setBtnTanggalMasuk();
        userKoreksiAbsenPage.setBtnTimer();
        Utils.delay(2);
        userKoreksiAbsenPage.setBtnTimer();

        userKoreksiAbsenPage.setBtnJamKeluar();
        Utils.delay(2);
        userKoreksiAbsenPage.setBtnTanggalKeluar();
        userKoreksiAbsenPage.setBtnTimer();
        Utils.delay(2);
        userKoreksiAbsenPage.setBtnTimer();
        extentTest.log(LogStatus.PASS, "I choose a date and time");
    }

    @And("I choose attendance type")
    public void i_choose_attendace_type(){
        userKoreksiAbsenPage.setInputTypeAbsen();
        userKoreksiAbsenPage.setTypeWFH();
        extentTest.log(LogStatus.PASS, "I choose attendance type");
    }

    @And("I click button request")
    public void i_click_button_request(){
        WebDriverWait wait = new WebDriverWait(driver, 3);
        boolean invisible =  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("menu-is_wfh")));
        if (invisible){
        WebElement btnAjukan = driver.findElement(By.xpath("//button[normalize-space()='Ajukan']"));
        btnAjukan.click();
        }
        extentTest.log(LogStatus.PASS, "I click button request");
    }

    @Then("I see data correction page")
    public void i_see_data_correction_page(){
        Assert.assertEquals(userKoreksiAbsenPage.getTxtHalaman(), "Halaman Koreksi");
        Assert.assertEquals(userKoreksiAbsenPage.getTxtListKoreksi(), "List Koreksi");
        Assert.assertEquals(userKoreksiAbsenPage.getTxtNameUser(), "testerjuara");
        extentTest.log(LogStatus.PASS, "I see data correction page");
    }

    @Then("I see warning")
    public void i_see_warning(){
        Assert.assertEquals(userKoreksiAbsenPage.getTxtWarning(), "Salah satu harus diisi!");
        extentTest.log(LogStatus.PASS, "I see warning");
    }

    @And("I click button back")
    public void i_click_button_back(){
        userKoreksiAbsenPage.setBtnBack();
        extentTest.log(LogStatus.PASS, "I click button back");
    }

    @Then("I see home absent view")
    public void i_see_home_absent_view(){
        Assert.assertEquals(userKoreksiAbsenPage.getTxtNameUser(), "testerjuara");
    }

}