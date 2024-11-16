package com.juaracoding.user;

import com.juaracoding.Hooks;
import com.juaracoding.pages.admin.LoginPage;
import com.juaracoding.pages.user.UserLoginPage;
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

public class UserLoginTest {

    private static WebDriver driver;
    private ExtentTest extentTest;
    private static LoginPage loginPage = new LoginPage();
    private static UserLoginPage userLoginPage = new UserLoginPage();

    public UserLoginTest(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @Given("I am on the login page for absent")
    public void i_am_on_the_login_page_for_absent(){
        driver.get(Constants.USER_URL);
        Utils.delay(2);
        Assert.assertEquals(driver.getCurrentUrl(), Constants.USER_URL);
        extentTest.log(LogStatus.PASS, "I am on the login page for absent");
    }

    @Then("I should be redirected to dashboard page for absent")
    public void i_should_be_redirected_to_dashboard_page_for_absent(){
        Assert.assertEquals(userLoginPage.getTxtMenu(), "Menu");
        Assert.assertEquals(driver.getCurrentUrl(), "https://magang.dikahadir.com/apps/absent");
        extentTest.log(LogStatus.PASS, "I should be redirected to dashboard page for absent");
    }

    @Given("I am logged in with email {string} and password {string} for absent")
    public void i_am_logged_in_with_email_and_password_for_absent(String email, String password) {
        driver.get(Constants.USER_URL);
        Assert.assertEquals(driver.getCurrentUrl(), Constants.USER_URL);
        loginPage.loginUser(email, password);
        loginPage.setBtnLogin();
        extentTest.log(LogStatus.PASS, "I am logged in with email "+email+" and password "+password+" for absent");
    }

    @When("I click sidebar menu")
    public void i_click_sidebar_menu() {
        userLoginPage.setSidebarMenu();
        extentTest.log(LogStatus.PASS, "I click sidebar menu");
    }

    @And("I click log out button for absent")
    public void i_click_log_out_button_for_absent() {
        userLoginPage.setBtnLogout();
        extentTest.log(LogStatus.PASS, "I click log out button for absent");
    }

    @Then("I should be redirected to login page for absent")
    public void i_should_be_redirected_to_login_page_for_absent() {
        Utils.delay(2);
        Assert.assertEquals(driver.getCurrentUrl(), Constants.USER_URL);
        extentTest.log(LogStatus.PASS, "I should be redirected to login page for absent");
    }

}