package com.juaracoding.user;

import com.juaracoding.Hooks;
import com.juaracoding.pages.user.UserHistoryAbsensiPage;
import com.juaracoding.pages.user.UserLoginPage;
import com.juaracoding.utils.Utils;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class UserHistoryAbsenTest {

    private static WebDriver driver;

    private ExtentTest extentTest;

    private static UserLoginPage userLoginPage = new UserLoginPage();

    private static UserHistoryAbsensiPage userHistoryAbsensiPage = new UserHistoryAbsensiPage();

    public UserHistoryAbsenTest(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @And("I click Absensi")
    public void i_click_absensi(){
        userHistoryAbsensiPage.setBtnAbsensi();
        extentTest.log(LogStatus.PASS, "I click Absensi");
    }

    @Then("I should be redirect to attendance history")
    public void i_should_be_redirect_to_attedance_history(){
        Utils.delay(3);
        Assert.assertEquals(userHistoryAbsensiPage.getTxtName(), "testerjuara");
        Assert.assertEquals(userHistoryAbsensiPage.getTxtHistoryAbsensi(), "History Absensi");
        Assert.assertEquals(userHistoryAbsensiPage.getTxtTidakAdaLagiData(), "Tidak ada lagi data");
        extentTest.log(LogStatus.PASS, "I should be redirect to attendance history");
    }

    @And("Return to the home view")
    public void return_to_the_home_view(){
        userHistoryAbsensiPage.setBtnBackDashboard();
        Assert.assertEquals(userHistoryAbsensiPage.getTxtNameUser(), "testerjuara");
        extentTest.log(LogStatus.PASS, "Return to the home view");
    }

    @And("I click link more")
    public void i_click_link_more(){
        Utils.delay(3);
        userHistoryAbsensiPage.setBtnSelengkapnya();
        extentTest.log(LogStatus.PASS, "I click link more");
    }
}
