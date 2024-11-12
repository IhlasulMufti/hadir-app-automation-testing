package com.juaracoding.admin;

import com.juaracoding.Hooks;
import com.juaracoding.pages.admin.LoginPage;
import com.juaracoding.utils.Constants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginTest {

    private static WebDriver driver;
    private ExtentTest extentTest;
    private static LoginPage loginPage = new LoginPage();

    public LoginTest(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @Given("I am on the login page")
    public void i_am_on_the_login_page(){
        driver.get(Constants.ADMIN_URL);
        Assert.assertEquals(driver.getCurrentUrl(), Constants.ADMIN_URL);
        extentTest.log(LogStatus.PASS, "I am on the login page");
    }

    @When("I enter email {string} and password {string}")
    public void i_enter_email_and_password(String email, String password){
        loginPage.loginUser(email, password);
        extentTest.log(LogStatus.PASS, "I enter email "+email+" and password "+password);
    }

    @And("I click the login button")
    public void i_click_the_login_button(){
        loginPage.setBtnLogin();
        extentTest.log(LogStatus.PASS, "I click the login button");
    }

    @Then("I should be redirected to dashboard page")
    public void i_should_be_redirected_to_dashboard_page(){
        Assert.assertEquals(loginPage.getTxtDashboard(), "Dashboard");
        Assert.assertEquals(driver.getCurrentUrl(), "https://magang.dikahadir.com/dashboards/dashboard");
        extentTest.log(LogStatus.PASS, "I should be redirected to dashboard page");
    }

}
