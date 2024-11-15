package com.juaracoding.admin;


import com.juaracoding.Hooks;
import com.juaracoding.pages.admin.DashboardPage;
import com.juaracoding.pages.admin.LoginPage;
import com.juaracoding.utils.Constants;
import com.juaracoding.utils.Utils;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DashboardTest {

    private static WebDriver driver;

    private static ExtentTest extentTest;

    private static LoginPage loginPage = new LoginPage();

    private static DashboardPage dashboardPage = new DashboardPage();

    public DashboardTest() {
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }


    @When("I enter a valid email {string} and password {string}")
    public void i_enter_a_valid_email_and_password(String email, String password){
        loginPage.loginUser(email, password);
        extentTest.log(LogStatus.PASS, "I enter a valid email "+email+" and password "+password);
    }

    @Then("I should be redirect to dashboard page")
    public void i_should_be_redirect_to_dashboard_page(){
        Utils.delay(3);
        dashboardPage.setDashboardMenuList();
        Assert.assertEquals(dashboardPage.getTxtDashboardPage(), "Dashboard");
        Assert.assertEquals(dashboardPage.getTxtTotalSemuaKaryawan(), "Total semua karyawan");
        Assert.assertEquals(dashboardPage.getTxtTotalAbsenHariIni(), "Total absen hari ini");
        Assert.assertEquals(dashboardPage.getTxtKaryawanWFH(), "Karyawan yang sedang WFH hari ini");
        Assert.assertEquals(dashboardPage.getTxtKaryawanCuti(), "Karyawan yang sedang cuti hari ini");
        Assert.assertEquals(dashboardPage.getTxtKaryawanSakit(), "Karyawan yang sedang sakit hari ini");
        Assert.assertEquals(dashboardPage.getTxtKaryawanIzin(), "Karyawan yang sedang Izin hari ini");
        Assert.assertEquals(driver.getCurrentUrl(), "https://magang.dikahadir.com/dashboards/dashboard");
        Utils.delay(3);
        extentTest.log(LogStatus.PASS, "I should be redirect to dashboard page");
    }
}
