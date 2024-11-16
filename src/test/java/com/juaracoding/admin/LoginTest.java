package com.juaracoding.admin;

import com.juaracoding.Hooks;
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

    @Given("I am logged in with email {string} and password {string}")
    public void i_am_logged_in_with_email_and_password(String email, String password) {
        driver.get(Constants.ADMIN_URL);
        Assert.assertEquals(driver.getCurrentUrl(), Constants.ADMIN_URL);
        loginPage.loginUser(email, password);
        loginPage.setBtnLogin();
        extentTest.log(LogStatus.PASS, "I am logged in with email "+email+" and password "+password);
    }

    @When("I click user profile")
    public void i_click_user_profile() {
        loginPage.userProfile();
        extentTest.log(LogStatus.PASS, "I click user profile");
    }

    @And("I click log out button")
    public void i_click_log_out_button() {
        loginPage.setBtnLogout();
        extentTest.log(LogStatus.PASS, "I click log out button");
    }

    @Then("I should be redirected to login page")
    public void i_should_be_redirected_to_login_page() {
        Assert.assertEquals(loginPage.getTxtLogin(), "Login");
        Assert.assertEquals(driver.getCurrentUrl(), Constants.ADMIN_URL);
        extentTest.log(LogStatus.PASS, "I should be redirected to login page");
    }

    @Then("Error with message {string} will appear")
    public void error_with_message_will_appear(String expectedErrorMessage){
        Utils.delay(3);
        Assert.assertTrue(loginPage.getErrorMessage().contains(expectedErrorMessage));
        extentTest.log(LogStatus.PASS, "Error with message "+expectedErrorMessage+" will appear");
    }

    @Then("Failed to login and still in the login page {string}")
    public void alert_with_message_will_appear(String url){
        Assert.assertEquals(loginPage.getEmailAttribute(), "email");
        Utils.delay(2);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        extentTest.log(LogStatus.PASS, "Failed to login and still in the login page "+url);
    }

    @Then("Password value is hidden")
    public void password_value_is_hidden() {
        Assert.assertEquals(loginPage.getPasswordType(), "password");
        extentTest.log(LogStatus.PASS, "Password value is hidden");
    }

    @And("I click hidden password button")
    public void i_click_hidden_password_button() {
        loginPage.setBtnHiddenPassword();
        extentTest.log(LogStatus.PASS, "I click hidden password button");
    }

    @Then("Password value revealed")
    public void password_value_revealed() {
        Assert.assertEquals(loginPage.getPasswordType(), "text");
        extentTest.log(LogStatus.PASS, "Password value revealed");
    }

}
