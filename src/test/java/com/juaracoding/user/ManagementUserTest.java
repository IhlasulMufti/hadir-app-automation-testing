package com.juaracoding.user;

import com.juaracoding.Hooks;
import com.juaracoding.pages.admin.LoginPage;
import com.juaracoding.pages.admin.ManagementUserPage;
import com.juaracoding.utils.Utils;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ManagementUserTest {

    private static WebDriver driver;

    private static ExtentTest extentTest;

    private static LoginPage loginPage = new LoginPage();

    private static ManagementUserPage managementUserPage = new ManagementUserPage();

    public ManagementUserTest(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @When("I add name {string}")
    public void i_add_name(String name){
        managementUserPage.setInputSearch(name);
        Utils.delay(3);
        extentTest.log(LogStatus.PASS, "i add name "+name);
    }

    @And("I click the search button")
    public void i_click_the_search_button(){
        managementUserPage.setBtnSearch();
        extentTest.log(LogStatus.PASS, "I click the search button");
    }

    @And("I went to the management user page")
    public void i_went_to_the_management_user_page(){
        managementUserPage.setManagementMenuBar();
        managementUserPage.setUserManagementList();
        Utils.delay(3);
        Assert.assertEquals(managementUserPage.getTxtUser(), "User");
        extentTest.log(LogStatus.PASS, "I went to the management user page");
    }

    @Then("I view list of user data by name")
    public void i_view_list_of_user_data_by_name(){
        Assert.assertEquals(managementUserPage.getTxtUser(), "User");
        Assert.assertEquals(managementUserPage.getTxtNamaKaryawan(), "testerjuara");
        Assert.assertEquals(driver.getCurrentUrl(), "https://magang.dikahadir.com/management/user?fullname%5B%24like%5D=%25testerjuara%25");
        extentTest.log(LogStatus.PASS, "I view list of user data by name");
    }

    @Then("I view list of user data by punctuation input")
    public void i_view_list_of_user_data_by_punctuation_input(){
        Assert.assertEquals(managementUserPage.getTxtUser(), "User");
        extentTest.log(LogStatus.PASS, "I view list of user data by punctuation input");
    }
}
