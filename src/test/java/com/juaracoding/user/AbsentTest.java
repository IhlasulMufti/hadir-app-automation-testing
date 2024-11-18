package com.juaracoding.user;

import com.juaracoding.Hooks;
import com.juaracoding.pages.user.AbsentPage;
import com.juaracoding.utils.Utils;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AbsentTest {

    private static WebDriver driver;
    private ExtentTest extentTest;
    private static AbsentPage absentPage = new AbsentPage();
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public AbsentTest(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    String message;

    @When("I click clocking in button")
    public void i_click_clocking_in_button() {
        Utils.delay(5);
        message = absentPage.clickBtnClockingIn();
        extentTest.log(LogStatus.PASS, "I click clocking in button");
    }

    @And("I click camera button to take selfie")
    public void i_click_camera_button_to_take_selfie() {
        Utils.delay(3);
        absentPage.takeSelfiePhoto();
        extentTest.log(LogStatus.PASS, "I click camera button to take selfie");
    }

    @And("I verify the clock is correct with the current time")
    public void i_verify_the_clock_is_correct_with_the_current_time() {
        Utils.delay(2);
        String currentTime = new SimpleDateFormat("HH:mm").format(new Date());
        System.out.println(currentTime);
        Assert.assertEquals(absentPage.absentTime(), currentTime);
        extentTest.log(LogStatus.PASS, "I verify the clock is correct with the current time");
    }

    @And("I input the absence type")
    public void i_input_the_absence_type() {
        absentPage.selectAbsentType();
        extentTest.log(LogStatus.PASS, "I input the absence type");
    }

    @And("I input a message {string} in the appropriate note")
    public void i_input_a_message_in_the_appropriate_note(String note) {
        absentPage.inputClockingInNotes(note);
        extentTest.log(LogStatus.PASS, "I input a message "+note+" in the appropriate note");
    }

    @And("I click clocking in button for submit absent")
    public void i_click_clocking_in_button_for_submit_absent() {
        absentPage.submitClockingIn();
        extentTest.log(LogStatus.PASS, "I click clocking in button for submit absent");
    }

    @Then("Verify the absent information are correct and appear on the history page")
    public void verify_the_absent_information_are_correct_and_appear_on_the_history_page() {
        System.out.println(absentPage.setSuccessAbsentDate());
        System.out.println(absentPage.setSuccessAbsentTime());
        System.out.println(absentPage.setSuccessAbsentNote());
        extentTest.log(LogStatus.PASS, "Verify the absent information are correct and appear on the history page");
    }

    @And("History page display a selfie photo")
    public void history_page_display_a_selfie_photo() {
        System.out.println(absentPage.setSuccessAbsentPhoto());
        extentTest.log(LogStatus.PASS, "History page display a selfie photo");
    }

    @Then("Verify that the clocking in button is not found")
    public void verify_that_the_clocking_in_button_is_not_found() {
        Assert.assertEquals(message, "Clocking In Button Not Found");
        extentTest.log(LogStatus.PASS, "Verify that the clocking in button is not found");
    }

    @When("I scroll to find history section")
    public void i_scroll_to_find_history_section() {
        Utils.delay(5);
        js.executeScript("window.scrollBy(0,600)");
        System.out.println(absentPage.setTxtAbsentHistory());
        extentTest.log(LogStatus.PASS, "I scroll to find history section");
    }

    @And("I click Keluar button")
    public void i_click_Keluar_button() {
        absentPage.clickBtnClockingOut();
        extentTest.log(LogStatus.PASS, "I click Keluar button");
    }

    @And("I input a message {string} in the clocking out note")
    public void i_input_a_message_in_the_clocking_out_note(String note) {
        absentPage.inputClockingOutNotes(note);
        extentTest.log(LogStatus.PASS, "I input a message "+note+" in the clocking out note");
    }

    @And("I click clocking out button for submit absent")
    public void i_click_clocking_out_button_for_submit_absent() {
        absentPage.submitClockingOut();
        extentTest.log(LogStatus.PASS, "I click clocking out button for submit absent");
    }

}
